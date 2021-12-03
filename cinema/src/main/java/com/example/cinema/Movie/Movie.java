package com.example.cinema.Movie;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="movies" )
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Double rating;
    private String type;
    private Integer minimum_age;
    private String img;
    private String trailer;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
//    private List<Movie> movie = new ArrayList<>();

    public Movie() {
    }
    public Movie(String name,
                 String description,
                 Double rating, String type,
                 Integer minimum_age,
                 String img, String trailer) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.type = type;
        this.minimum_age = minimum_age;
        this.img = img;
        this.trailer = trailer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMinimum_age() {
        return minimum_age;
    }

    public void setMinimum_age(Integer minimum_age) {
        this.minimum_age = minimum_age;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", type='" + type + '\'' +
                ", minimum_age=" + minimum_age +
                ", img=" + img +
                ", trailer='" + trailer + '\'' +
                '}';
    }
}
