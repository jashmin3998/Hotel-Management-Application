package com.cmpe202.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe202.dto.AmenitiesDTO;
import com.cmpe202.dto.BookingDTO;
import com.cmpe202.dto.HotelDTO;
import com.cmpe202.dto.RoomDTO;
import com.cmpe202.dto.UserDTO;
import com.cmpe202.models.Booking;
import com.cmpe202.models.User;
import com.cmpe202.payload.request.SignupRequest;
import com.cmpe202.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(long id) {

		return userRepository.getById(id);
	}

	public UserDTO convertToUserDTO(User user) {

		List<BookingDTO> list = new ArrayList<>();

		for (Booking b : user.getBooking()) {
			BookingDTO bookingDTO = BookingDTO.convertToBookingDTO(b);
			RoomDTO roomDTO = RoomDTO.convertToRoomDTO(b.getRoom());
			HotelDTO hotelDTO = HotelDTO.convertToHotelDTO(b.getHotel());
			List<AmenitiesDTO> amenitiesDTO = AmenitiesDTO.convertToAmenitiesDTOSet(b.getAmenities());

			bookingDTO.setRoom(roomDTO);
			bookingDTO.setAmenities(amenitiesDTO);
			bookingDTO.setHotel(hotelDTO);
			bookingDTO.setUser(null);

			list.add(bookingDTO);

		}

		UserDTO userDTO = UserDTO.convertToUserDTO(user);
		userDTO.setBooking(list);

		return userDTO;
	}

	public UserDTO getUserWithBookingById(Long id) {

		User user = userRepository.getById(id);
		return convertToUserDTO(user);

	}

	public UserDTO getUserDTOById(Long id) {

		User user = getUserById(id);
		return convertToUserDTO(user);

	}

	public List<UserDTO> getAllUserDTO() {

		List<UserDTO> dto = new ArrayList<>();

		for (User user : getAllUsers()) {
			dto.add(convertToUserDTO(user));
		}
		return dto;

	}
	
	public void updateUser(Long id, SignupRequest signupRequest) {
		
		User user = getUserById(id);
		user.setAddress(signupRequest.getAddress());
		user.setPhoneNumber(signupRequest.getPhoneNumber());
		
		userRepository.save(user);
		
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
		
	}

}
