package com.rest.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.bbs.beans.Availability;
import com.rest.bbs.beans.Bus;
import com.rest.bbs.beans.Feedback;
import com.rest.bbs.beans.Ticket;
import com.rest.bbs.beans.User;
import com.rest.bbs.services.ServiceDAO;

@RequestMapping(value="/user")
@RestController
public class UserController {

	@Autowired
	private ServiceDAO services;
	
	//create User
	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		if(services.createUser(user)) {
			return user;
		}else {
			return null;
		}
	}
	//search User
	@RequestMapping(value = "/searchUser/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") int userId) {
		return services.searchUser(userId);
	}

	//update User
	@RequestMapping(value = "/userUpdate", method = RequestMethod.PUT)
	public User createEmpl(@RequestBody User user) {
		if(services.updateUser(user)) {
			return user;
		}else {
			return null;
		}
	}
	//delete user
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Boolean deleteUser(@PathVariable("id") int userId) {
		return services.deleteUser(userId);
	}

	//search Bus
	@RequestMapping(value = "/searchBus/{id}", method = RequestMethod.GET)
	public Bus getBus(@PathVariable("id") int busId) {
		return services.searchBus(busId);
	}

	//Login User
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User loginUser(@RequestBody User user) {
		return services.loginUser(user.getUserId(), user.getPassword());

	}

	//write Feedback
	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	public Boolean writeFeedback(@RequestBody Feedback feed) {
		return services.writeFeedback(feed);
	}

	//book ticket
	@RequestMapping(value = "/bookTicket", method = RequestMethod.POST)
	public Ticket bookTicket(@RequestBody Ticket ticket) {
		return services.bookTicket(ticket);
	}

	//cancel ticket
	@RequestMapping(value = "/cancelTicket", method = RequestMethod.POST)
	public Boolean cancelTicket(@RequestBody Ticket ticket) {
		return services.cancelTicket(ticket.getBookingId(),ticket.getUserId());
	}

}
