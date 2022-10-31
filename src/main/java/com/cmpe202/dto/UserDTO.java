package com.cmpe202.dto;

import java.util.ArrayList;
import java.util.List;

import com.cmpe202.models.Role;
import com.cmpe202.models.User;

public class UserDTO {

	private Long id;

	private String username;

	private String email;

	private String password;

	private List<Role> roles = new ArrayList<>();

	private List<BookingDTO> booking;

	private int rewardPoints;

	private String phoneNumber;

	private String address;
	
	private Boolean isLoyal;

	public UserDTO() {
	}

	public UserDTO(Long id, String username, String email, String password, List<Role> roles, List<BookingDTO> booking,
			int rewardPoints, String phoneNumber, String address, Boolean isLoyal) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.booking = booking;
		this.rewardPoints = rewardPoints;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.isLoyal = isLoyal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<BookingDTO> getBooking() {
		return booking;
	}

	public void setBooking(List<BookingDTO> booking) {
		this.booking = booking;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	public Boolean getIsLoyal() {
		return isLoyal;
	}

	public void setIsLoyal(Boolean isLoyal) {
		this.isLoyal = isLoyal;
	}

	public static UserDTO convertToUserDTO(User user) {

		UserDTO dto = new UserDTO();
		dto.setEmail(user.getEmail());
		dto.setId(user.getId());
		dto.setPassword(user.getPassword());
		dto.setRoles(user.getRoles());
		dto.setUsername(user.getUsername());
		dto.setRewardPoints(user.getRewardPoints());
		dto.setAddress(user.getAddress());
		dto.setPhoneNumber(user.getPhoneNumber());
		dto.setIsLoyal(user.getIsLoyal());
		return dto;

	}

}
