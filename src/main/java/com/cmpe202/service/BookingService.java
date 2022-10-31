package com.cmpe202.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe202.dto.AmenitiesDTO;
import com.cmpe202.dto.BookingDTO;
import com.cmpe202.dto.HotelDTO;
import com.cmpe202.dto.RoomDTO;
import com.cmpe202.dto.UserDTO;
import com.cmpe202.models.Amenities;
import com.cmpe202.models.Booking;
import com.cmpe202.models.ERole;
import com.cmpe202.models.User;
import com.cmpe202.payload.request.BookingRequest;
import com.cmpe202.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	HotelService hotelService;

	@Autowired
	UserService userService;

	@Autowired
	RoomService roomService;

	@Autowired
	AmenitiesService amenitiesService;

	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	public List<BookingDTO> getAllBookingsDTO(long id) {
		
		User user = userService.getUserById(id);
		if(user.getRoles().get(0).getName().equals(ERole.ROLE_USER)) {
			return null;
		}

		List<BookingDTO> list = new ArrayList<>();

		for (Booking b : getAllBookings()) {
			list.add(getBookingDTOWithUser(b));
		}
		return list;
	}

	public Booking getBookingById(Long id) {
		Optional<Booking> b = bookingRepository.findById(id);
		if (!b.isEmpty()) {
			return b.get();
		}
		return null;
	}

	public BookingDTO getBookingDTOById(Long id) {
		return getBookingDTOWithUser(getBookingById(id));
	}

	public BookingDTO getBookingDTOWithUser(Booking b) {

		UserDTO userDTO = UserDTO.convertToUserDTO(b.getUser());

		BookingDTO bookingDTO = convertToBookingDTO(b);
		bookingDTO.setUser(userDTO);

		return bookingDTO;
	}

	public BookingDTO convertToBookingDTO(Booking b) {

		BookingDTO bookingDTO = BookingDTO.convertToBookingDTO(b);

		HotelDTO hotelDTO = HotelDTO.convertToHotelDTO(b.getHotel());
		RoomDTO roomDTO = RoomDTO.convertToRoomDTO(b.getRoom());
		List<AmenitiesDTO> amenitiesDTO = AmenitiesDTO.convertToAmenitiesDTOSet(b.getAmenities());

		bookingDTO.setAmenities(amenitiesDTO);
		bookingDTO.setHotel(hotelDTO);
		bookingDTO.setRoom(roomDTO);

		return bookingDTO;
	}

	public void addBooking(BookingRequest bookingRequest) {

		System.out.println(bookingRequest);

		long hotel_id = bookingRequest.getHotel_id();
		long user_id = bookingRequest.getUser_id();
		long room_id = bookingRequest.getRoom_id();
		int noOfAdults = bookingRequest.getNoOfAdults();
		int noOfChildrens = bookingRequest.getNoOfChildrens();
		int price = bookingRequest.getPrice();
		int totalRooms = bookingRequest.getTotalRooms();
		List<Long> amenities_id = bookingRequest.getAmenities_id();
		List<Amenities> amenities = new ArrayList<>();
		int rewardPoints = bookingRequest.getRewardPoints();
		rewardPoints += amenities_id.size() + (price/100) + noOfAdults *2 + noOfChildrens + totalRooms * 10 ;
		User user = userService.getUserById(user_id);
		user.setRewardPoints(rewardPoints);
		

		for (Long id : amenities_id) {
			amenities.add(amenitiesService.getAmenitiesById(id));
		}

		Date startDate = bookingRequest.getStartDate();
		Date endDate = bookingRequest.getEndDate();

		Booking booking = new Booking(hotelService.getHotelById(hotel_id), user, startDate,
				endDate, price, noOfAdults, noOfChildrens, amenities, roomService.getRoomById(room_id), totalRooms);

		bookingRepository.save(booking);

		user = userService.getUserById(user_id);
		if (user.getBooking().size() >= 3) {
			if (!user.getIsLoyal()) {
				user.setIsLoyal(true);
				userService.saveUser(user);
			}
		}
		else {
			if(user.getIsLoyal()) {
				user.setIsLoyal(false);
				userService.saveUser(user);
			}
		}

	}

	public List<BookingDTO> getUserWithBookingById(long id) {
		// TODO Auto-generated method stub
		List<Booking> list = bookingRepository.findByUserId(id);
		List<BookingDTO> bookingDTOs = new ArrayList<BookingDTO>();

		RoomDTO roomDTO;
		HotelDTO hotelDTO;
		List<AmenitiesDTO> amenities;

		for (Booking b : list) {
			roomDTO = RoomDTO.convertToRoomDTO(b.getRoom());
			hotelDTO = HotelDTO.convertToHotelDTO(b.getHotel());
			amenities = AmenitiesDTO.convertToAmenitiesDTOSet(b.getAmenities());

			BookingDTO bookingDTO = BookingDTO.convertToBookingDTO(b);
			bookingDTO.setAmenities(amenities);
			bookingDTO.setHotel(hotelDTO);
			bookingDTO.setRoom(roomDTO);
			bookingDTOs.add(bookingDTO);
		}
		return bookingDTOs;
	}

	public void deleteBookingById(Long id) {


		Booking booking = getBookingById(id);

		bookingRepository.deleteById(id);
		User user = booking.getUser();
		
		if(user.getBooking().size()<3) {
			if(user.getIsLoyal()) {
				user.setIsLoyal(false);
				userService.saveUser(user);
			}
		}
	}

	public void updateBooking(Long id, BookingRequest bookingRequest) {

		long hotel_id = bookingRequest.getHotel_id();
		long room_id = bookingRequest.getRoom_id();
		List<Long> amenities_id = bookingRequest.getAmenities_id();
		List<Amenities> amenities = new ArrayList<>();

		for (Long amen : amenities_id) {
			amenities.add(amenitiesService.getAmenitiesById(amen));
		}

		Booking booking = getBookingById(id);

		booking.setEndDate(bookingRequest.getEndDate());
		booking.setStartDate(bookingRequest.getStartDate());
		booking.setHotel(hotelService.getHotelById(hotel_id));
		booking.setNoOfAdults(bookingRequest.getNoOfAdults());
		booking.setNoOfChilderns(bookingRequest.getNoOfChildrens());
		booking.setTotalRooms(bookingRequest.getTotalRooms());
		booking.setAmenities(amenities);
		booking.setPrice(bookingRequest.getPrice());
		booking.setRoom(roomService.getRoomById(room_id));

		bookingRepository.save(booking);
	}

}
