package com.sapient.ota.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.ota.entities.Ticket;
import com.sapient.ota.entities.TicketDTO;
import com.sapient.ota.services.BookingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/booking")
@Slf4j
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/bookTicket")
	public ResponseEntity<String> addProductDetails(@Valid @RequestBody TicketDTO ticketDTO,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			//log.error(bindingResult.getFieldErrors().toString());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
		}
		Ticket ticket = bookingService.saveBookingDetails(ticketDTO);
		return ResponseEntity.status(HttpStatus.OK)
				.body(ticket.getUrn());
		
	}
}
