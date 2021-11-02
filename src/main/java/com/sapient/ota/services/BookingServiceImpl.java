package com.sapient.ota.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.ota.constants.Status;
import com.sapient.ota.entities.Ticket;
import com.sapient.ota.entities.TicketDTO;
import com.sapient.ota.repositories.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Override
	public Ticket getBookingDetails(String urn) {
		return bookingRepository.findByUrn(urn);
	}
	

	@Override
	public Ticket saveBookingDetails(TicketDTO ticketDTO) {
		
		LocalDate localDate= LocalDate.now();
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		Ticket ticket = new Ticket();
		ticket.setTourName(ticketDTO.getTourName());
		ticket.setDescription(ticketDTO.getDescription());
		ticket.setPrice(ticketDTO.getPrice());
		ticket.setTourDate(ticketDTO.getTourDate());
		ticket.setStatus(Status.CONFIRMED);
		ticket.setBookingDate(dateformatter.format(localDate));
		ticket.setUrn(UUID.randomUUID().toString());
		try {
			return bookingRepository.save(ticket);
		} catch (Exception e) {
			System.out.println(e.toString());
			return ticket;
		}
		
	}
}
