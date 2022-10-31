package com.cmpe202.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe202.models.Room;
import com.cmpe202.repository.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	RoomRepository roomRepository;
	
	
	public Room getRoomById(Long roomId) {
	
		Optional<Room> room =roomRepository.findById(roomId);
		
		if(!room.isEmpty()) {
			return room.get();
		}
		return null;
	}

}
