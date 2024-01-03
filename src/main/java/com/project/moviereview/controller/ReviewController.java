package com.project.moviereview.controller;

import com.project.moviereview.entity.Review;
import com.project.moviereview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/reviews")

public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    /*
    Whatever we get as the Requestbody, we would like to convert it to a map of, key String and
    value String, and we want to name this map as "payload"
    */
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId" )),
                HttpStatus.CREATED);
    }
}
