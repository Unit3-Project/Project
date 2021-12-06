package com.example.cinema.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tickets")
@CrossOrigin("*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets()
    {
        return  ticketService.getAllTickets();
    }

    @PostMapping
    public ResponseEntity<String> saveTicket(@RequestBody Ticket ticket)
    {
        return ticketService.saveTicket(ticket);
    }


}
