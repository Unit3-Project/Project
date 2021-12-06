package com.example.cinema.Ticket;

import com.example.cinema.Movie.Movie;
import com.example.cinema.Movie_Room.Movie_Room;
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

    @Column(name = "status")
    private String status;

//    @ManyToOne
//    @JoinColumn(name = "movie_id")
//    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
//    private Movie movie;
//
//    @ManyToOne
//    @JoinColumn(name = "room_id")
//    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
//    private Room room;


    @ManyToOne
    @JoinColumn(name = "movie_room_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Movie_Room movie_room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private User user;

    public Ticket() {
    }

    public Ticket(Long id, String status, Movie_Room movie_room, User user) {
        this.id = id;
        this.status = status;
        this.movie_room = movie_room;
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie_Room getMovie_room() {
        return movie_room;
    }

    public void setMovie_room(Movie_Room movie_room) {
        this.movie_room = movie_room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
