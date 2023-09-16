package com.playtable.review.service;

import com.playtable.review.common.expection.ReviewNotFoundException;
import com.playtable.review.domain.entity.Review;
import com.playtable.review.domain.request.ReviewRequest;
import com.playtable.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Transactional
    public Review uploadReview(ReviewRequest request){
        return reviewRepository.save(request.toEntity());
    }

    @Transactional
    public Review updateReview(UUID reviewId, String content, Integer rating, String imgUrl) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            review.update(content, rating, imgUrl);
            return reviewRepository.save(review);
        } else {
            throw new ReviewNotFoundException();
        }
    }

    public List<Review> findAll(String storeId) {
        return reviewRepository.findAllByStoreIdAndIsDelete(UUID.fromString(storeId), 0);
    }

    public Optional<Review> findById(UUID id){
        return reviewRepository.findById(id);
    }

    @Transactional
    public void deleteReview(UUID reviewId) {
        // 1. 제거할 리뷰 데이터 조회 & null 체크
        Review findReview = Optional.ofNullable(reviewRepository.findByReviewIdAndIsDeleteIs(reviewId, 0))
                .orElseThrow(ReviewNotFoundException::new);

        // 2. isDelete 업데이트 (서비스 상 제거)
        findReview.updateIsDelete(1);
    }
}


