package com.example.cinema.Ticket;

import com.example.cinema.Movie.Movie;
import com.example.cinema.Movie.MovieRepository;
import com.example.cinema.Room.Room;
import com.example.cinema.Room.RoomRepository;
import com.example.cinema.User.User;
import com.example.cinema.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private TicketRepo ticketRepo;

    public List<Ticket> getAllTickets()
    {
        return ticketRepo.findAll();
    }

    public ResponseEntity<String> saveTicket(Ticket ticket)
    {
        Long movie_id = ticket.getMovie().getId();
        Movie movie = movieRepository.getById(movie_id);

        Long room_id = ticket.getRoom().getId();
        Room room = roomRepository.getById(room_id);

        Long user_id = ticket.getUser().getId();
        User user = userRepository.getById(user_id);


        if (movie != null && room != null && user != null){
            ticket.setMovie(movie);
            ticket.setRoom(room);
            ticket.setUser(user);
            ticketRepo.save(ticket);
            return ResponseEntity.ok().body("Saved Successfully");
        }
        else {
            return ResponseEntity.badRequest().body("Not Found???????");
        }
    }
}
