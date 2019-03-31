package com.vapps.javatests.movies.service;

import com.vapps.javatests.movies.data.MoviesRepository;
import com.vapps.javatests.movies.model.Genre;
import com.vapps.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MoviesService {

    private MoviesRepository repository;

    public MoviesService(MoviesRepository repository) {
        this.repository = repository;
    }

    public Collection<Movie> findMovieByGenre(Genre genre) {
        return repository.findAll().stream()
                .filter(movie -> movie.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByLength(Integer length) {
        return repository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length)
                .collect(Collectors.toList());
    }
}
