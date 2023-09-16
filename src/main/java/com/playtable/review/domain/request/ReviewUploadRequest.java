package com.playtable.review.domain.request;

import com.playtable.review.domain.entity.Review;

import java.util.UUID;

public record ReviewUploadRequest (
        UUID storeId,
        String content,
        Integer rating
){
   public Review toEntity(){
       return  Review.builder()
               .storeId(storeId)
               .content(content)
               .rating(rating)
               .build();
   }
}

