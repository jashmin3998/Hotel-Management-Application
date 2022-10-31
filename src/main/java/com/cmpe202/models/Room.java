package com.cmpe202.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERoom name;

	@Column
	private int price;

	@Column(name = "available_rooms")
	int availableRooms;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_id")
	Hotel hotel;

	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY , orphanRemoval = true , cascade = CascadeType.ALL)
	private List<Booking> booking;

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public Room(ERoom name, int price, int availableRooms, Hotel hotel, List<Booking> booking) {
		super();
		this.name = name;
		this.price = price;
		this.availableRooms = availableRooms;
		this.hotel = hotel;
		this.booking = booking;
	}

	public Room() {
		// TODO Auto-generated constructor stub
	}

	public ERoom getName() {
		return name;
	}

	public void setName(ERoom name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}