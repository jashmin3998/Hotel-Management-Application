package com.cmpe202.dto;

import java.util.ArrayList;
import java.util.List;

import com.cmpe202.models.Hotel;


public class HotelDTO {

	private Long id;

	private String hotelname;

	private String state;

	private String country;

	private List<RoomDTO> rooms = new ArrayList<>();

	private List<AmenitiesDTO> amenities = new ArrayList<>();

	private String rating;
	
	public HotelDTO(Long id, String hotelname, String state, String country, List<RoomDTO> rooms, List<AmenitiesDTO> amenities,
			String rating, String price) {
		super();
		this.id = id;
		this.hotelname = hotelname;
		this.state = state;
		this.country = country;
		this.rooms = rooms;
		this.amenities = amenities;
		this.rating = rating;
		this.price = price;
	}

	private String price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RoomDTO> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomDTO> rooms) {
		this.rooms = rooms;
	}

	public List<AmenitiesDTO> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<AmenitiesDTO> amenities) {
		this.amenities = amenities;
	}


	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public HotelDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public static HotelDTO convertToHotelDTO(Hotel hotel) {
		
		HotelDTO hotelDTO = new HotelDTO();
		hotelDTO.setId(hotel.getId());
		hotelDTO.setCountry(hotel.getCountry());
		hotelDTO.setPrice(hotel.getPrice());
		hotelDTO.setHotelname(hotel.getHotelname());
		hotelDTO.setRating(hotelDTO.getRating());
		hotelDTO.setState(hotel.getState());
		
		return hotelDTO;
		
	}

}
