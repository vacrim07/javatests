package com.vapps.javatests.movies.service;

import com.vapps.javatests.movies.data.MoviesRepository;
import com.vapps.javatests.movies.model.Genre;
import com.vapps.javatests.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenGoingToMoviesService {

    MoviesService service;
    MoviesRepository repository;

    Movie movie1 = Movie.builder().id(1).name("Patch Adams").genre(Genre.COMEDY).minutes(180).build();
    Movie movie2 = Movie.builder().id(2).name("Prince of BelAir").genre(Genre.COMEDY).minutes(190).build();
    Movie movie3 = Movie.builder().id(3).name("Avengers").genre(Genre.ACTION).minutes(220).build();
    Movie movie4 = Movie.builder().id(4).name("Spiderman").genre(Genre.ACTION).minutes(120).build();

    @Before
    public void setUp() throws Exception {
        repository = Mockito.mock(MoviesRepository.class);
        service = new MoviesService(repository);
        Mockito.when(repository.findAll())
                .thenReturn(Arrays.asList(
                        movie1,
                        movie2,
                        movie3,
                        movie4
                ));
    }

    @Test
    public void should_return_movies_by_genre() {

        Collection<Movie> toFindById = service.findMovieByGenre(Genre.COMEDY);

        assertThat(collectMovies(toFindById), is(Arrays.asList(1,2)));
    }

    @Test
    public void should_return_movies_by_length() {

        Collection<Movie> toFindById = service.findMovieByLength(180);

        assertThat(collectMovies(toFindById), is(Arrays.asList(1,4)));
    }

    private List<Integer> collectMovies(Collection<Movie> moviesToFind) {
        return moviesToFind.stream()
                .map(Movie::getId)
                .collect(Collectors.toList());
    }
}