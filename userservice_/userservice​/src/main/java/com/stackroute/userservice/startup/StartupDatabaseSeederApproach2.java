package com.stackroute.startup;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import com.stackroute.userservice.domain.Movie;
import com.stackroute.userservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupDatabaseSeederApproach2 implements CommandLineRunner {

    private MovieRepository movieRepository;
    private Movie movie;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Movie movie = new Movie();
        movie.setMovieId(2);
        movie.setMovieName("Frozen");
        movieRepository.save(movie);
    }
}