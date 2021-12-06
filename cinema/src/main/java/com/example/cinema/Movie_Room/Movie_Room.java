package com.example.cinema.Movie_Room;

import com.example.cinema.Movie.Movie;
import com.example.cinema.Room.Room;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "movie_room")
public class Movie_Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Room room;

    public Movie_Room() {
    }

    public Movie_Room(Long id, LocalDate date, Double price, Movie movie, Room room) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.movie = movie;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
