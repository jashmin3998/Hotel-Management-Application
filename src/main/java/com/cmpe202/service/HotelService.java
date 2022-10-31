package com.cmpe202.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe202.dto.AmenitiesDTO;
import com.cmpe202.dto.HotelDTO;
import com.cmpe202.dto.RoomDTO;
import com.cmpe202.models.Hotel;
import com.cmpe202.models.Room;
import com.cmpe202.repository.HotelRepository;

@Service
public class HotelService {

	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	AmenitiesService amenitiesService;

	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}

	public List<HotelDTO> getAllHotelDTO() {

		List<HotelDTO> list = new ArrayList<>();

		for (Hotel hotel : hotelRepository.findAll()) {
			list.add(convertToHotelDTO(hotel));
		}
		return list;
	}

	public HotelDTO getHotelDTOById(long id) {
		Optional<Hotel> hotel = hotelRepository.findById(id);

		if (!hotel.isEmpty()) {
			return convertToHotelDTO(hotel.get());
		}
		return null;
	}

	public Hotel getHotelById(long id) {
		Optional<Hotel> hotel = hotelRepository.findById(id);

		if (!hotel.isEmpty()) {
			return hotel.get();
		}
		return null;
	}

	public List<Hotel> getHotelByState(String state) {
		return hotelRepository.findByState(state);
	}

	public List<Hotel> getHotelByCountry(String country) {
		return hotelRepository.findByCountry(country);
	}

	public List<HotelDTO> getHotelDTOByState(String state) {
		List<HotelDTO> list = new ArrayList<>();

		for (Hotel hotel : hotelRepository.findByState(state)) {
			list.add(convertToHotelDTO(hotel));
		}
		return list;
	}

	public List<HotelDTO> getHotelDTOByCountry(String country) {
		List<HotelDTO> list = new ArrayList<>();

		for (Hotel hotel : hotelRepository.findByCountry(country)) {
			list.add(convertToHotelDTO(hotel));
		}
		return list;
	}

	public HotelDTO convertToHotelDTO(Hotel hotel) {

		List<RoomDTO> roomDto = new ArrayList<>();
		for (Room room : hotel.getRooms()) {
			roomDto.add(RoomDTO.convertToRoomDTO(room));
		}
		
		List<AmenitiesDTO> amenitiesDTO =AmenitiesDTO.convertToAmenitiesDTOSet(hotel.getAmenities());
		
		HotelDTO hotelDTO = HotelDTO.convertToHotelDTO(hotel);
		hotelDTO.setAmenities(amenitiesDTO);
		hotelDTO.setRooms(roomDto);
		
		return hotelDTO;
	}

}
