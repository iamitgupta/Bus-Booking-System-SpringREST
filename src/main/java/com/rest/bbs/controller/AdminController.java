package com.rest.bbs.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.bbs.beans.Admin;
import com.rest.bbs.beans.Availability;
import com.rest.bbs.beans.Bus;
import com.rest.bbs.beans.Feedback;
import com.rest.bbs.beans.User;
import com.rest.bbs.services.ServiceDAO;

@RequestMapping(value="/admin")

@RestController
public class AdminController {

	@Autowired
	private ServiceDAO services;


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Admin loginAdmin(@RequestBody Admin admin) {
		Admin adminCheck = services.adminLogin(admin.getAdminId(), admin.getPassword());
		if(adminCheck != null) {
			return adminCheck;
		}
		return adminCheck;
	}

	@RequestMapping(value = "/bus/create", method = RequestMethod.POST)
	public Boolean createBus(@RequestBody Bus bus) {
	return services.createBus(bus);

	}
	@RequestMapping(value = "/bus/update", method = RequestMethod.PUT)
	public Boolean updateBus(@RequestBody Bus bus) {
	return services.updateBus(bus);

	}
	
	
	@RequestMapping(value = "/bus/delete/{id}", method = RequestMethod.DELETE)
	public Boolean deleteBus(@PathVariable("id") int busId) {
		return services.deletebus(busId);
	}
	
	@RequestMapping(value = "/bus/search/{id}", method = RequestMethod.GET)
	public Bus searchBus(@PathVariable("id") int busId) {
		Bus searchBus = services.searchBus(busId);
		return searchBus;
	}
	
	@RequestMapping(value = "/bus/setAvailability", method = RequestMethod.POST)
	public Boolean createBus(@RequestBody Availability available) {
	return services.setBusAvailability(available);

	}
	
	@RequestMapping(value = "/user/search/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") int userId) {
		return services.searchUser(userId);
	}

	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	//public Boolean suggestionUser(@RequestBody Suggestion suggest) {
	public	List<Feedback> getAllSuggestion (@RequestBody Feedback suggest){
		List<Feedback> list= services.viewFeedbac();
		
		return list;
	}
}
	
