package com.cmpe202.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cmpe202.models.Booking;

public class BookingDTO {

	private Long id;

	private HotelDTO hotel;

	private UserDTO user;

	Date startDate;

	Date endDate;

	int price;

	int totalRooms;

	int noOfAdults;

	int noOfChilderns;

	private List<AmenitiesDTO> amenities = new ArrayList<>();

	private RoomDTO room;

	public BookingDTO() {

	}

	public BookingDTO(Long id, HotelDTO hotel, UserDTO user, Date startDate, Date endDate, int price, int totalRooms,
			int noOfAdults, int noOfChilderns, List<AmenitiesDTO> amenities, RoomDTO room) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.user = user;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.totalRooms = totalRooms;
		this.noOfAdults = noOfAdults;
		this.noOfChilderns = noOfChilderns;
		this.amenities = amenities;
		this.room = room;
	}

	public int getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}

	public RoomDTO getRoom() {
		return room;
	}

	public void setRoom(RoomDTO room) {
		this.room = room;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public HotelDTO getHotel() {
		return hotel;
	}

	public void setHotel(HotelDTO hotel) {
		this.hotel = hotel;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public int getNoOfChilderns() {
		return noOfChilderns;
	}

	public void setNoOfChilderns(int noOfChilderns) {
		this.noOfChilderns = noOfChilderns;
	}

	public List<AmenitiesDTO> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<AmenitiesDTO> amenities) {
		this.amenities = amenities;
	}

	public static BookingDTO convertToBookingDTO(Booking b) {

		BookingDTO bookingDTO = new BookingDTO();
		bookingDTO.setEndDate(b.getEndDate());
		bookingDTO.setStartDate(b.getStartDate());
		bookingDTO.setId(b.getId());
		bookingDTO.setNoOfAdults(b.getNoOfAdults());
		bookingDTO.setNoOfChilderns(b.getNoOfChilderns());
		bookingDTO.setPrice(b.getPrice());
		bookingDTO.setTotalRooms(b.getTotalRooms());

		return bookingDTO;

	}

	public static List<BookingDTO> convertToBookingDTOSet(List<Booking> list) {

		List<BookingDTO> bookingDTOs = new ArrayList<BookingDTO>();
		for (Booking b : list) {
			bookingDTOs.add(convertToBookingDTO(b));
		}

		return bookingDTOs;

	}

}
