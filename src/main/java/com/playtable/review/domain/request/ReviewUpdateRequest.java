package com.playtable.review.domain.request;

import com.playtable.review.domain.entity.Review;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public record ReviewUpdateRequest(
    String content,
    String imgUrl,
    Integer rating
){
    public Review toEntity(){
        return Review.builder()
                .content(content)
                .imgUrl(imgUrl)
                .rating(rating)
                .build();
    }
}
