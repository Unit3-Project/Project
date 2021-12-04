package com.example.cinema.Movie_Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("available_movies")
@CrossOrigin("*")
public class Movie_Room_Controller {

    @Autowired
    private Movie_Room_Service movie_room_service;

    @GetMapping
    public List<Movie_Room> getAllAvailableMovies()
    {
        return movie_room_service.getAllAvailableMovies();
    }

    @PostMapping
    public ResponseEntity<String> saveAvailableMovie(@RequestBody Movie_Room movie_room)
    {
        return movie_room_service.saveAvailableMovie(movie_room);
    }
}
