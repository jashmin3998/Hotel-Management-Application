package com.cmpe202.dto;

import com.cmpe202.models.ERoom;
import com.cmpe202.models.Room;

public class RoomDTO {

	private Long id;

	private ERoom name;

	private int price;

	int availableRooms;



	public RoomDTO(Long id, ERoom name, int price, int availableRooms) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.availableRooms = availableRooms;
	}

	public RoomDTO() {
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


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public static RoomDTO convertToRoomDTO(Room room) {
		
		return new RoomDTO(room.getId(), room.getName(), room.getPrice(), room.getAvailableRooms());
		
		
	}

}