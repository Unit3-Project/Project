package com.example.cinema.API_Requests;

import com.example.cinema.Movie.Movie;
import com.example.cinema.Movie.MovieRepository;
import com.example.cinema.Movie_Room.Movie_Room_Repo;
import com.example.cinema.Room.Room;
import com.example.cinema.Room.RoomRepository;
import com.example.cinema.Ticket.Ticket;
import com.example.cinema.Ticket.TicketRepo;
import com.example.cinema.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private Movie_Room_Repo movie_room_repo;
    @Autowired
    private TicketRepo ticketRepo;


    public AdminPageData  getAdminPageData()
    {
        int user = userRepository.findAll().size();
        int movie = movieRepository.findAll().size();
        int room = roomRepository.findAll().size();
        int availableMovie = movie_room_repo.findAll().size();
        int ticket = ticketRepo.findAll().size();
        AdminPageData d1 = new AdminPageData(user,movie,room,availableMovie,ticket);
        return d1;
    }

    public String changeTicketStatus(String ticket_id, Ticket ticket)
    {

        Ticket updateTicketStatus = ticketRepo.findById(Long.parseLong(ticket_id)).orElse(null);
        if (updateTicketStatus != null)
        {
            updateTicketStatus.setStatus(ticket.getStatus());
            updateTicketStatus.setUser(ticket.getUser());
            updateTicketStatus.setMovie_room(ticket.getMovie_room());
            ticketRepo.save(updateTicketStatus);
            return "Updated Successfully";
        }
        else{
            return null;
        }
    }
}
