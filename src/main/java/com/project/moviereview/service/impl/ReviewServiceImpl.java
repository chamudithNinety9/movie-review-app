package com.project.moviereview.service.impl;

import com.project.moviereview.entity.Movie;
import com.project.moviereview.entity.Review;
import com.project.moviereview.repo.ReviewRepo;
import com.project.moviereview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){

        Review review = reviewRepo.insert(new Review(reviewBody));


        /* every movie has an empty array named "reviewIds", so we update that array
        pushing new review id into that */

        /*
        which movie we update the review is, we update the movie where IMDB id of the movie in
        the database matches the imdb id that we have received from the user. (line 38)
         */

        /* then we should apply this update - to do we call apply, and we create a new update definition
        and make change inside the db (line 39) */
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;


    }
}
