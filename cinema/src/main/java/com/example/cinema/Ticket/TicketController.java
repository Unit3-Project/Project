package com.example.cinema.Ticket;

import com.example.cinema.Movie.Movie;
import com.example.cinema.Room.Room;
import com.example.cinema.Ticket.Ticket;
import com.example.cinema.Ticket.TicketService;
import com.example.cinema.User.User;
import com.example.cinema.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "tickets")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {this.ticketService = ticketService;}

    @GetMapping
    public List<Ticket> getTicket(){
        return ticketService.getTicket();
    }
//
//    @GetMapping("/{id}")
//    public Ticket getTicket(@PathVariable String id){return ticketService.getTickets(id);}

    @PostMapping
    public Ticket bookMovie(@RequestBody Form form ) {

        return ticketService.bookMovie(form.getMovie(), form.getUser(), form.getFormRoom());
    }

}

class Form{
    Room room;
    User user;
    Movie movie;

    public Room getFormRoom() {
        return room;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }
}