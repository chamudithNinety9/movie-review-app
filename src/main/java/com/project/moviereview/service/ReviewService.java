package com.project.moviereview.service;

import com.project.moviereview.entity.Review;

public interface ReviewService {
    Review createReview(String reviewBody, String imdbId);
}
