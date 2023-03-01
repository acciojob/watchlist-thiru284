package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMap;

    public MovieRepository(){
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.directorMovieMap = new HashMap<>();
    }

    public void saveMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }

    public void saveDirector(Director director){
        directorMap.put(director.getName(), director);
    }

    public void saveMovieDirectorPair(String movie, String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            List<String> currentMovies = new ArrayList<>();
            if(directorMovieMap.containsKey(director))
                currentMovies = directorMovieMap.get(director);
            currentMovies.add(movie);
            directorMovieMap.put(director, currentMovies);
        }
    }

    public Movie findMovie(String movie){
        return movieMap.get(movie);
    }

    public Director findDirector(String director){
        return directorMap.get(director);
    }

    public List<String> findMoviesFromDirector(String director){
        List<String> moviesList = new ArrayList<>();
        if(directorMovieMap.containsKey(director))
            moviesList = directorMovieMap.get(director);
        return moviesList;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirectorByName(String name){
        List<String> movieList = directorMovieMap.get(name);
        for(String s: movieList){
            movieMap.remove(s);
        }
        directorMap.remove(name);
        directorMovieMap.remove(name);
    }

    public void deleteAllDirectors(){
        for(String direct: directorMovieMap.keySet()){
            deleteDirectorByName(direct);
        }
    }

}
