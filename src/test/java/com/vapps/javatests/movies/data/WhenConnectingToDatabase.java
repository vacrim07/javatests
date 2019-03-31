package com.vapps.javatests.movies.data;

import com.vapps.javatests.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.vapps.javatests.movies.model.Genre.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WhenConnectingToDatabase {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private MoviesRepositoryJdbc moviesRepository;
    private Movie movie1 = Movie.builder().id(1).name("Dark Knight").genre(ACTION).minutes(152).build();
    private Movie movie2 = Movie.builder().id(2).name("Memento").genre(THRILLER).minutes(113).build();
    private Movie movie3 = Movie.builder().id(3).name("Matrix").genre(ACTION).minutes(136).build();
    private Movie movie4 = Movie.builder().id(4).name("Meme").genre(COMEDY).minutes(95).build();

    @Before
    public void setUp() throws SQLException {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL","sa","sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        jdbcTemplate = new JdbcTemplate(dataSource);
        moviesRepository = new MoviesRepositoryJdbc(jdbcTemplate);
    }

    @After
    public void tearDown() throws Exception {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("DROP ALL OBJECTS DELETE FILES ");
    }

    @Test
    public void load_all_movies() {

        Collection<Movie> movies = moviesRepository.findAll();

        assertThat(movies, is(Arrays.asList(
                movie1, movie2, movie3, movie4
        )));
    }

    @Test
    public void load_movie_by_id() {

        Movie aMovie = moviesRepository.findById(2);

        assertThat(aMovie, is(movie2));
    }

    @Test
    public void insert_a_movie() {

        Movie aMovie = Movie.builder().name("Super 8").minutes(112).genre(THRILLER).build();

        moviesRepository.update(aMovie);
        aMovie.setId(5);
        Movie movieExpected = moviesRepository.findById(5);

        assertThat(aMovie, is(movieExpected));
    }

    @Test
    public void find_by_name() {
        Collection<Movie> movies = moviesRepository.findByName("meme");

        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(movie2);
        expectedMovies.add(movie4);

        assertThat(movies, is(expectedMovies));
    }

    @Test
    public void find_by_template() {
        Movie template = Movie.builder().genre(ACTION).minutes(152).build();

        Collection<Movie> movies = moviesRepository.findByTemplate(template);

        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(movie1);
        expectedMovies.add(movie3);
        assertThat(movies, is(expectedMovies));
    }
}