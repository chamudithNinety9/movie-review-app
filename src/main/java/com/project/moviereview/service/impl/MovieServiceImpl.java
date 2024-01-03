package com.project.moviereview.service.impl;
import com.project.moviereview.entity.Movie;
import com.project.moviereview.repo.MovieRepo;
import com.project.moviereview.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MovieServiceImpl implements MovieService {


    @Autowired
    private MovieRepo movieRepo;

    public List<Movie> allMovies(){
        return movieRepo.findAll();
    }

    @Override
    public Optional<Movie> getSingleMovie(String imdbId) {
        return movieRepo.findMovieByImdbId(imdbId);
    }


}
