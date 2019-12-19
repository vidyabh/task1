package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TicketDao;
import com.example.demo.model.Ticket;

@RestController
@RequestMapping("/Ticket")
public class TicketController {
	@Autowired
	private TicketDao dao;
	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Ticket> tickets)
	{
		dao.saveAll(tickets);
		
		return "ticket booked:" +tickets.size();
		
	}

	@GetMapping("/getTickets")
	public Object getTickets()
	{
		return (List<Ticket>) dao.findAll();
	}
}








