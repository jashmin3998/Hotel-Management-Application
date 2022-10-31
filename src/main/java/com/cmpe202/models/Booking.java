package com.cmpe202.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_id", referencedColumnName = "id")
	private Hotel hotel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "start_date")
	Date startDate;

	@Column(name = "end_date")
	Date endDate;

	@Column(name = "price")
	int price;

	@Column(name = "total_rooms")
	int totalRooms;

	@Column(name = "no_of_adults")
	int noOfAdults;

	@Column(name = "no_of_childrens")
	int noOfChilderns;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "booking_amenities", joinColumns = @JoinColumn(name = "booking_id"), inverseJoinColumns = @JoinColumn(name = "amenities_id"))
	private List<Amenities> amenities = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id", referencedColumnName = "id")
	private Room room;

	public Booking(Hotel hotel, User user, Date startDate, Date endDate, int price, int noOfAdults, int noOfChilderns,
			List<Amenities> amenities, Room room, int totalRooms) {
		super();
		this.hotel = hotel;
		this.user = user;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.noOfAdults = noOfAdults;
		this.noOfChilderns = noOfChilderns;
		this.amenities = amenities;
		this.room = room;
		this.totalRooms = totalRooms;
	}

	public int getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Booking() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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

	public List<Amenities> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<Amenities> amenities) {
		this.amenities = amenities;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", hotel=" + hotel + ", user=" + user + ", startDate=" + startDate + ", endDate="
				+ endDate + ", price=" + price + ", totalRooms=" + totalRooms + ", noOfAdults=" + noOfAdults
				+ ", noOfChilderns=" + noOfChilderns + ", amenities=" + amenities + ", room=" + room + "]";
	}
}
