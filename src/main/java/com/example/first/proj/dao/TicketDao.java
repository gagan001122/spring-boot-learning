package com.example.first.proj.dao;

import com.example.first.proj.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDao extends JpaRepository<Ticket, Integer> {
}
