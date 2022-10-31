package com.cmpe202.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Object relational Model of Hotel entity

@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "hotelname")
	/* @NotEmpty(message = "Please provide a hotel name") */
	private String hotelname;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Room> rooms = new ArrayList<>();

	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
	private List<Amenities> amenities = new ArrayList<>();

	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Booking> booking;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Amenities> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<Amenities> amenities) {
		this.amenities = amenities;
	}

	@Column(name = "rating")
	/* @NotEmpty(message = "Please provide a rating for hotel") */
	private String rating;

	@Column(name = "price")
	/* @NotEmpty(message = "Please provide a rating for hotel") */
	private String price;

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

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
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

	@Override
	public String toString() {
		return "Hotel [hotelname=" + hotelname + ", rooms=" + rooms + ", rating=" + rating + ", price=" + price + "]";
	}

}
