package com.cmpe202.payload.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookingRequest {

	@NotNull
	Long hotel_id;

	@NotNull
	Long user_id;

	@NotNull
	Long room_id;

	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date startDate;

	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date endDate;

	@NotNull
	Integer price;

	@NotNull
	Integer noOfAdults;

	@NotNull
	Integer noOfChildrens;

	@NotNull
	Integer totalRooms;

	List<Long> amenities_id;

	@NotNull
	Integer rewardPoints;

	public BookingRequest() {
		// TODO Auto-generated constructor stub
	}

	public BookingRequest(@NotNull Long hotel_id, @NotNull Long user_id, @NotNull Long room_id, @NotNull Date startDate,
			@NotNull Date endDate, @NotNull Integer price, @NotNull Integer noOfAdults, @NotNull Integer noOfChildrens,
			@NotNull Integer totalRooms, List<Long> amenities_id, @NotNull Integer rewardPoints) {
		super();
		this.hotel_id = hotel_id;
		this.user_id = user_id;
		this.room_id = room_id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.noOfAdults = noOfAdults;
		this.noOfChildrens = noOfChildrens;
		this.totalRooms = totalRooms;
		this.amenities_id = amenities_id;
		this.rewardPoints = rewardPoints;
	}

	public Long getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(Long hotel_id) {
		this.hotel_id = hotel_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Long room_id) {
		this.room_id = room_id;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(Integer noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public Integer getNoOfChildrens() {
		return noOfChildrens;
	}

	public void setNoOfChildrens(Integer noOfChildrens) {
		this.noOfChildrens = noOfChildrens;
	}

	public Integer getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(Integer totalRooms) {
		this.totalRooms = totalRooms;
	}

	public List<Long> getAmenities_id() {
		return amenities_id;
	}

	public void setAmenities_id(List<Long> amenities_id) {
		this.amenities_id = amenities_id;
	}

	public Integer getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		return getHotel_id() + ", " + getRoom_id() + ", " + getPrice() + ", " + getUser_id() + ", " + getTotalRooms()
				+ ", " + getNoOfAdults() + ", " + getNoOfChildrens() + ", " + getAmenities_id() + ", " + getStartDate()
				+ ", " + getEndDate();
	}

}
