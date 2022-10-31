package com.cmpe202.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe202.service.HotelService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity getAllHotel() {
		return new ResponseEntity<>(hotelService.getAllHotelDTO(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity getHotel(@PathVariable long id) {
		return new ResponseEntity(hotelService.getHotelDTOById(id), HttpStatus.OK);
	}
	
	@GetMapping("/getHotelByState/{state}")
	@ResponseBody
	public ResponseEntity getHotelByState(@PathVariable String state) {
		return new ResponseEntity(hotelService.getHotelDTOByState(state), HttpStatus.OK);
	}
	
	@GetMapping("/getHotelByCountry/{country}")
	@ResponseBody
	public ResponseEntity getHotelByCountry(@PathVariable String country) {
		return new ResponseEntity(hotelService.getHotelDTOByCountry(country), HttpStatus.OK);
	}
	
	
	
	

}
