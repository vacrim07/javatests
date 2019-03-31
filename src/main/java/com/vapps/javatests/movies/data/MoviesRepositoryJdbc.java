package com.vapps.javatests.movies.data;

import com.vapps.javatests.movies.model.Genre;
import com.vapps.javatests.movies.model.Movie;
import com.vapps.javatests.movies.service.MoviesService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MoviesRepositoryJdbc implements MoviesRepository {

    private JdbcTemplate jdbcTemplate;

    public MoviesRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(Integer id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void update(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies(name, minutes, genre) VALUES (?, ?, ?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString());
    }

    @Override
    public Collection<Movie> findByName(String name) {
        return findAll().stream().filter (movie -> movie.getName().matches("(?i).*" + name + ".*")).collect(Collectors.toList());
    }

    @Override
    public Collection<Movie> findByTemplate(Movie template) {
        Collection<Movie> movies = findAll();

        if(template.getName() != null){
            movies = movies.stream()
                    .filter (movie -> movie.getName().matches("(?i).*" + template.getName() + ".*"))
                    .collect(Collectors.toList());
        }

        if(template.getGenre() != null){
            movies = movies.stream()
                    .filter(movie -> movie.getGenre().equals(template.getGenre()))
                    .collect(Collectors.toList());
        }

        if(template.getMinutes() != null){
            movies = movies.stream()
                    .filter(movie -> movie.getMinutes() <= template.getMinutes())
                    .collect(Collectors.toList());
        }

        return movies;
    }









    public Collection<Movie> findMovieByGenre(Genre genre) {
        return findAll().stream()
                .filter(movie -> movie.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByLength(Integer length) {
        return findAll().stream()
                .filter(movie -> movie.getMinutes() <= length)
                .collect(Collectors.toList());
    }


    private static RowMapper<Movie> movieMapper = (resultSet, i) -> Movie.builder()
            .id(resultSet.getInt("id"))
            .name(resultSet.getString("name"))
            .minutes(resultSet.getInt("minutes"))
            .genre(Genre.valueOf(resultSet.getString("genre")))
            .build();
}
