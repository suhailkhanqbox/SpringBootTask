package com.stackroute.userservice.service;

        import com.stackroute.userservice.domain.Movie;
        import com.stackroute.userservice.exceptions.MovieAlreadyExistsException;
        import com.stackroute.userservice.exceptions.MovieNotFoundException;
        import org.springframework.context.annotation.Profile;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service("dummy")
//@Profile("test")
public class MovieDummyServiceImpl implements MovieService {

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() throws MovieNotFoundException {
        return null;
    }

    @Override
    public Movie deleteMovie(Movie movie) throws MovieNotFoundException {
return null;
    }

    @Override
    public Movie getMovieById(int id) throws MovieNotFoundException {
        return null;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return null;
    }

    @Override
    public List<Movie> searchMovies(String movieName) {
        return null;
    }


}