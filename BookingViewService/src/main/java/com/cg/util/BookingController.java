package com.cg.util;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.BookingRepositoryProxy;
import com.cg.model.Booking;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

	@Autowired
	private BookingRepositoryProxy proxy;

	@GetMapping("/bookings")
	public List<Booking> findAll() {
		return proxy.findAll();
	}

	@GetMapping("/bookings/date/{startDate}/to/{endDate}")
	public List<Booking> showBookingsByDate(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
		if ((startDate.compareTo(endDate)) > 0) {
			return null;
		} else {
			return proxy.findAll().stream().filter(
					(bookings) -> bookings.getCheckin().isAfter(startDate) && bookings.getCheckout().isBefore(endDate)).collect(Collectors.toList());
		}
		
	}
}