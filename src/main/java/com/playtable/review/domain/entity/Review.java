package com.playtable.review.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Review")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID reviewId;
    private UUID storeId;
    private UUID reservationSituationId;
    private UUID customerId;
    @Column(nullable = false)// min = 1,  max = 5
    private Integer rating;
    @Column(nullable = false, length = 1000)
    private String content;
    @Column(length = 300)
    private String imgUrl;
    // 지워진 글은 1 (default는 0)
    @Column( nullable = false)
    private Integer isDelete;


    public void update(String content , Integer rating, String imgUrl) {
        this.content = content;
        this.rating = rating;
        this.imgUrl = imgUrl;
    }
    public void updateIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
