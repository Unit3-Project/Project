package com.example.cinema.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public List<Movie> getMovie() {
        return movieRepository.findAll();
    }

    public Movie getMovie(String id) {
        Long movie_id = Long.parseLong(id);
        return movieRepository.findById(movie_id).orElse(null);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);

    }

    public String deleteMovie(String id) {
        Long movie_id = Long.parseLong(id);
        Movie exist = movieRepository.findById(movie_id).orElse(null);
        if (exist != null){
            movieRepository.deleteById(movie_id);
            return ("deleted");
        }
        else {
            return ("id not found");
        }
    }


    public Movie updateMovie(Movie movie, String id ) {
        Movie updatedMovie = movieRepository.findById(Long.parseLong(id)).orElse(null);
        if (updatedMovie != null)
        {
        updatedMovie.setName(movie.getName());
        updatedMovie.setImg(movie.getImg());
        updatedMovie.setDescription(movie.getDescription());
        updatedMovie.setRating(updatedMovie.getRating());
        updatedMovie.setType(movie.getType());
        updatedMovie.setMinimum_age(movie.getMinimum_age());
        updatedMovie.setTrailer(movie.getTrailer());
        return movieRepository.save(updatedMovie);}
        return null;
    }
}
