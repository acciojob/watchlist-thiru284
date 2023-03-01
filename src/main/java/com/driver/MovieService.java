package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepositorys;

    public void addMovie(Movie movie){
        movieRepositorys.saveMovie(movie);
    }

    public void addDirector(Director director){
        movieRepositorys.saveDirector(director);
    }
    public void createMovieDirectorPair(String movie, String director){
        movieRepositorys.saveMovieDirectorPair(movie, director);
    }

    public Movie findMovie(String name){
        return movieRepositorys.findMovie(name);
    }

    public Director getDirectorByName(String name){
        return movieRepositorys.findDirector(name);
    }

    public List<String> getMoviesByDirectorName(String name){
        return movieRepositorys.findMoviesFromDirector(name);
    }

    public List<String> findAllMovies(){
        return movieRepositorys.findAllMovies();
    }

    public void deleteDirectorByName(String name){
        movieRepositorys.deleteDirectorByName(name);
    }

    public void deleteAllDirectors(){
        movieRepositorys.deleteAllDirectors();
    }

}
