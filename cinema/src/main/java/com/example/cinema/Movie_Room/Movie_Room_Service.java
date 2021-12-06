package com.example.cinema.Movie_Room;

import com.example.cinema.Movie.Movie;
import com.example.cinema.Movie.MovieRepository;
import com.example.cinema.Room.Room;
import com.example.cinema.Room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Movie_Room_Service {

    @Autowired
    private  MovieRepository movieRepository;
    @Autowired
    private  RoomRepository roomRepository;
    @Autowired
    private Movie_Room_Repo movie_room_repo;

//    public Movie_Room_Service(Movie_Room_Repo movie_room_repo) {
//        this.movie_room_repo = movie_room_repo;
//    }

    public List<Movie_Room> getAllAvailableMovies()
    {
        return movie_room_repo.findAll();
    }

    public ResponseEntity<String> saveAvailableMovie(Movie_Room movie_room)
    {
        Long movie_id = movie_room.getMovie().getId();
        Movie movie = movieRepository.getById(movie_id);

        Long room_id = movie_room.getRoom().getId();
        Room room = roomRepository.getById(room_id);
        if (movie != null && room != null){
            movie_room.setMovie(movie);
            movie_room.setRoom(room);
            movie_room_repo.save(movie_room);
            return ResponseEntity.ok().body("Saved Successfully");
        }
        else {
            return ResponseEntity.badRequest().body("Not Found???????");
        }

    }
    public Movie_Room getAvailableMovie(String id)
    {
        Long movie_room_id = Long.parseLong(id);
        return movie_room_repo.findById(movie_room_id).orElse(null);
    }
}
