package com.playtable.review.repository;

import com.playtable.review.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {

    List<Review> findAllByStoreIdAndIsDelete(UUID storeId, int isDelete);

    Review findByReviewIdAndIsDeleteIs(UUID reviewId, int isDelete);

}
