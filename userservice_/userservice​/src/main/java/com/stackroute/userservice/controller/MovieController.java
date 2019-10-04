package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.Movie;
import com.stackroute.userservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.userservice.service.MovieService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="api/v1")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService){

        this.movieService=movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveUser(@RequestBody Movie movie)
    {
        ResponseEntity responseEntity;
        try {
            movieService.saveMovie(movie);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (MovieAlreadyExistsException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("movie")
    public ResponseEntity<?> getAllMovies()
    {
        ResponseEntity responseEntity;

        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovieId(@PathVariable(value = "id") int movieId)
            throws Exception {
        Movie movie = movieService.findById(movieId);

        return ResponseEntity.ok().body(movie);
    }

   /* @PutMapping("/movie/{id}")
    public ResponseEntity<Movie> updateUser(
            @PathVariable(value = "id") int movieId, @Valid @RequestBody User userDetails)
          *//*  throws Exception {
        *//**//*Movie movie = movieService.findById(movieId);user.setEmail(userDetails.getEmail());
        user.setFirstName(userDetails.getFirstName());
        user.setUpdatedAt(new Date());
        final User updatedUser = userRepository.save(user);*//**//**//**//*
        return ResponseEntity.ok(updatedUser);*//**//*
    }*/

 /*   @DeleteMapping("/movie/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
        User user =
                movieService
                        .findById(userId)
                        .orElseThrow(() -> new Exception("User not found on :: " + userId));
        movieService.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }*/


}
