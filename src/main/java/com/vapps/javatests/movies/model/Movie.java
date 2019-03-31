package com.vapps.javatests.movies.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Movie {

    private Integer id;
    private String name;
    private Integer minutes;
    private Genre genre;
}
