package com.playtable.review.domain.request;

import com.playtable.review.domain.entity.Review;

import java.util.UUID;

public record ReviewRequest(
        UUID storeId,
        UUID reservationSituationId,

        Integer rating,

        String content,

        String imgUrl

){
    public Review toEntity(UUID customerId){
        return Review.builder()
                .storeId(storeId)
                .reservationSituationId(reservationSituationId)
                .customerId(customerId)
                .rating(rating)
                .content(content)
                .imgUrl(imgUrl)
                .isDelete(0)
                .build();
    }
}
