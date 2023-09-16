package com.playtable.review.controller;

import com.playtable.review.domain.entity.Review;

import com.playtable.review.domain.request.ReviewRequest;
import com.playtable.review.domain.request.ReviewUpdateRequest;

import com.playtable.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("{storeId}")
    public ResponseEntity<List<Review>> getReviewsByStoreId(@PathVariable String storeId) {
        List<Review> reviews = reviewService.findAll(storeId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping
    public ResponseEntity<Review> uploadReview(@RequestBody ReviewRequest request) {
        Review savedReview = reviewService.uploadReview(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReview);
    }

    @PutMapping("{reviewId}")
    public ResponseEntity<Review> updateReview(
            @PathVariable UUID reviewId,
            @RequestBody ReviewUpdateRequest request
    ){
        String content = "Updated Content";
        Integer rating = 5;
        String imgUrl = "Updated Image URL";
        Review updatedReview = reviewService.updateReview(reviewId, content, rating, imgUrl);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable UUID reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}

