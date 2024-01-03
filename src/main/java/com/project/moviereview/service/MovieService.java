package com.project.moviereview.service;

import com.project.moviereview.entity.Movie;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> allMovies();

    Optional<Movie> getSingleMovie(String imdbId);
}
