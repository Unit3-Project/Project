package com.example.cinema.Room;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Integer num_seats;

    public Room(Long id, String type, Integer num_seats) {
        this.id = id;
        this.type = type;
        this.num_seats = num_seats;
    }
    public Room(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNum_seats() {
        return num_seats;
    }

    public void setNum_seats(Integer num_seats) {
        this.num_seats = num_seats;
    }
}
