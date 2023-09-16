package com.playtable.review.domain.response;

import com.playtable.review.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class ReviewResponse {
    private List<Review> reviews;
}
