package com.example.first.proj.controller;

import com.example.first.proj.dao.TicketDao;
import com.example.first.proj.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketDao dao;

    // Save multiple tickets
    @PostMapping("/bookTickets")
    public String bookTicket(@RequestBody List<Ticket> tickets) {
        dao.saveAll(tickets);  // Use saveAll() to save a list of tickets
        return "Tickets booked: " + tickets.size();
    }

    // Retrieve all tickets
    @GetMapping("/getTickets")
    public List<Ticket> getTickets() {
        return (List<Ticket>) dao.findAll();
    }

    // Retrieve ticket by ID
    @GetMapping("/getTicket/{id}")
    public Ticket getTicketById(@PathVariable int id) {
        Optional<Ticket> ticket = dao.findById(id);
        return ticket.orElse(null);  // Return null if not found
    }

    @PutMapping("/updateTicket/{id}")
    public String updateTicket(@PathVariable int id, @RequestBody Ticket updatedTicket) {
        Optional<Ticket> existingTicket = dao.findById(id);

        if (existingTicket.isPresent()) {
            Ticket ticket = existingTicket.get();
            ticket.setAmount(updatedTicket.getAmount());
            ticket.setCategory(updatedTicket.getCategory());
            dao.save(ticket);  // Save the updated ticket
            return "Ticket updated successfully!";
        } else {
            return "Ticket with ID " + id + " not found!";
        }
    }

    @DeleteMapping("/deleteTicket/{id}")
    public String deleteTicket(@PathVariable int id) {
        Optional<Ticket> ticket = dao.findById(id);

        if (ticket.isPresent()) {
            dao.deleteById(id);  // Delete the ticket by ID
            return "Ticket deleted successfully!";
        } else {
            return "Ticket with ID " + id + " not found!";
        }
    }
}
