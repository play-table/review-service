package com.playtable.review.repository;

import com.playtable.review.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
    @Query("select count(*) as review from Review ")
    Long findByReview();
    List<Review> findAllByStoreIdAndIsDelete(UUID storeId, int isDelete);

    Review findByReviewIdAndIsDeleteIs(UUID reviewId, int isDelete);

}
