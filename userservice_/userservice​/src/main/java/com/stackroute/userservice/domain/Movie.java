package com.stackroute.userservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    int movieId;
    String movieName;


    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                '}';
    }

    public Movie() {
    }

    public Movie(int movieId, String movieName) {
        this.movieId = movieId;
        this.movieName = movieName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}

