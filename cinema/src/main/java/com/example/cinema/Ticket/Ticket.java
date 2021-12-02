package com.example.cinema.Ticket;

import com.example.cinema.Movie.Movie;
import com.example.cinema.Room.Room;
import com.example.cinema.User.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private User user;

    public Ticket() {
    }

    public Ticket(Long id, Movie movie, Room room, User user) {
        this.id = id;
        this.movie = movie;
        this.room = room;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
