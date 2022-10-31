package com.cmpe202.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe202.payload.request.BookingRequest;
import com.cmpe202.service.BookingService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/booking")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@GetMapping("/{id}/getAllBookings")
	@ResponseBody
	public ResponseEntity getAllBookings(@PathVariable long id) {
		return new ResponseEntity<>(bookingService.getAllBookingsDTO(id), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity getBookingById(@PathVariable long id) {
		return new ResponseEntity(bookingService.getBookingDTOById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity updateBookingById(@PathVariable Long id, @Valid @RequestBody BookingRequest bookingRequest) {
		bookingService.updateBooking(id, bookingRequest);
		return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity deleteBookingById(@PathVariable long id) {
		bookingService.deleteBookingById(id);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/addBooking")
	public ResponseEntity addBooking(@Valid @RequestBody BookingRequest bookingRequest) {
		bookingService.addBooking(bookingRequest);
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	@ResponseBody
	public ResponseEntity getUserBookingById(@PathVariable long id) {
		return new ResponseEntity(bookingService.getUserWithBookingById(id), HttpStatus.OK);
	}

}
