package com.example.cinema.Movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "movies")
@CrossOrigin("*")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

        @GetMapping
        public List<Movie> getMovie () {
            return movieService.getMovie();
        }

        @GetMapping("/{id}")
        public Movie getMovie (@PathVariable String id){
            return movieService.getMovie(id);

        }
        @PostMapping
        public Movie createMovie (@RequestBody Movie movie){
            return movieService.createMovie(movie);
        }

        @DeleteMapping("/{id}")
        public void deleteMovie (@PathVariable String id){
            movieService.deleteMovie(id);
        }

        @PatchMapping("/{id}")
        public Movie updateMovie (@RequestBody Movie movie, @PathVariable String id){
            return movieService.updateMovie(movie, id);
        }
    }
