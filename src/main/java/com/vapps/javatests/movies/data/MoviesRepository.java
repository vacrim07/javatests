package com.vapps.javatests.movies.data;

import com.vapps.javatests.movies.model.Movie;

import java.util.Collection;

public interface MoviesRepository {

    Movie findById(Integer id);

    Collection<Movie> findAll();

    void update(Movie movie);

    Collection<Movie> findByName(String name);

    Collection<Movie> findByTemplate(Movie template);
}
