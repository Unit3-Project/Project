package com.example.cinema.API_Requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class ApiController {

    @Autowired
    private ApiService apiService;


    @GetMapping("/getAdminPageData")
    public AdminPageData getAdminPageData(){
        return apiService.getAdminPageData();
    }
}

class AdminPageData{
    private int users ;
    private int movies ;
    private int rooms ;
    private int availableMovies ;
    private int Tickets ;

    public AdminPageData(int users, int movies, int rooms, int availableMovies, int tickets) {
        this.users = users;
        this.movies = movies;
        this.rooms = rooms;
        this.availableMovies = availableMovies;
        Tickets = tickets;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getMovies() {
        return movies;
    }

    public void setMovies(int movies) {
        this.movies = movies;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getAvailableMovies() {
        return availableMovies;
    }

    public void setAvailableMovies(int availableMovies) {
        this.availableMovies = availableMovies;
    }

    public int getTickets() {
        return Tickets;
    }

    public void setTickets(int tickets) {
        Tickets = tickets;
    }
}

