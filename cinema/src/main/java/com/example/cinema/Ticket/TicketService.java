package com.example.cinema.Ticket;

import com.example.cinema.Movie.Movie;
import com.example.cinema.Movie.MovieRepository;
import com.example.cinema.Room.Room;
import com.example.cinema.Room.RoomRepository;
import com.example.cinema.User.User;
import com.example.cinema.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketService {
    @Autowired
    private  TicketRepository ticketRepository;
    @Autowired
    private  RoomRepository roomRepository;
    @Autowired
    private  MovieRepository movieRepository;
    @Autowired
    private  UserRepository userRepository;
//
//    public TicketService(TicketRepository ticketRepository, RoomRepository roomRepository, MovieRepository movieRepository, UserRepository userRepository) {
//        this.ticketRepository = ticketRepository;
//        this.roomRepository = roomRepository;
//        this.movieRepository = movieRepository;
//        this.userRepository = userRepository;
//    }

    public List<Ticket> getTicket (){return ticketRepository.findAll();}

    public Ticket getTickets(String id) {
        Long ticket_id = Long.parseLong(id);
        return ticketRepository.findById(ticket_id).orElse(null);
    }





    public Ticket bookMovie(Movie movie, User user, Room room) {
        Movie ticket_movie = movieRepository.findById(movie.getId()).orElse(null);
        User ticket_user = userRepository.findById(user.getId()).orElse(null);
        Room ticket_room = roomRepository.findById(room.getId()).orElse(null);

        Ticket ticket = new Ticket();
        ticket.setMovie(ticket_movie);
        ticket.setRoom(ticket_room);
        ticket.setUser(ticket_user);
        ticket.setStatus("pending");

        return ticketRepository.save(ticket);

    }
}
