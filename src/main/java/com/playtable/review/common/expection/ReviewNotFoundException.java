package com.playtable.review.common.expection;

import com.playtable.review.common.enumerate.ApiStatusCode;

public class ReviewNotFoundException extends ReviewServiceException {
    public ReviewNotFoundException() {
        super(ApiStatusCode.REVIEW_NOT_FOUND);
    }

}