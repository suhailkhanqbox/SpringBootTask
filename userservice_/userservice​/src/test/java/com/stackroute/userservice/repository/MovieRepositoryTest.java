package com.stackroute.userservice.repository;


import com.stackroute.userservice.domain.Movie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {


    @Autowired
    private MovieRepository movieRepository;
    private Movie movie;

    @Before
    public void setUp() throws Exception {
        movie = new Movie(101, "War");
    }

    @After
    public void tearDown() throws Exception {
        movieRepository.deleteAll();
    }

    @Test
    public void testSaveMovie(){
        movieRepository.save(movie);
        Movie savedMovie = movieRepository.findById(movie.getMovieId()).get();
        Assert.assertEquals(101,savedMovie.getMovieId());
    }

    @Test
    public void testSaveMovieFailure(){
        Movie testMovie = new Movie(102, "Pokemon");
        movieRepository.save(movie);
        Movie savedMovie = movieRepository.findById(movie.getMovieId()).get();
        Assert.assertNotSame(testMovie, savedMovie);
    }


    @Test
    public void testGetAllMovies() {
        Movie movie1 = new Movie(102, "Batman");
        Movie movie2 = new Movie(103, "Joker");
        movieRepository.save(movie1);
        movieRepository.save(movie2);

        List<Movie> list = movieRepository.findAll();
        Assert.assertEquals("Batman", list.get(1).getMovieName());
    }

    @Test
    public void testFindMovieById(){
        movieRepository.save(movie);
        Movie retrievedMovie = movieRepository.findById(movie.getMovieId()).get();
        Assert.assertEquals(movie, retrievedMovie);
    }

    @Test
    public void testFindMovieByIdFailure(){

    }


    @Test
    public void testUpdateMovie(){
        Movie testMovie = new Movie(101, "Pokemon");
        movieRepository.save(movie);
        Movie updatedMovie = movieRepository.save(testMovie);
        Assert.assertEquals(testMovie, updatedMovie);
        Assert.assertNotSame(testMovie, movie);
    }

    @Test
    public void testUpdateMovieFailure(){

    }


    @Test
    public void testDeleteMovie(){
        movieRepository.save(movie);
        movieRepository.delete(movie);
        Assert.assertFalse(movieRepository.existsById(movie.getMovieId()));
    }

    @Test
    public void testDeleteMovieFailure(){

    }


    @Test
    public void testFindByMovieName() {
        movieRepository.save(movie);
        List<Movie> retrievedList = movieRepository.findByName(movie.getMovieName());
        Assert.assertEquals(movie, retrievedList.get(0));
    }

    @Test
    public void testFindByMovieNameFailure() {

    }










}
