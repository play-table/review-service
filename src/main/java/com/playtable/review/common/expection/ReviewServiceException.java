package com.playtable.review.common.expection;

import com.playtable.review.common.enumerate.ApiStatusCode;

public class ReviewServiceException extends RuntimeException {
    protected ApiStatusCode errorStatusCode;
    protected String errorMessage;

    public ReviewServiceException() {
    }

    public ReviewServiceException(ApiStatusCode errorStatusCode) {
        this.errorStatusCode = errorStatusCode;
        this.errorMessage = errorStatusCode.getMessage(); // 상태 코드에 대한 메시지를 가져옴
    }

    public ApiStatusCode getErrorStatusCode() {
        return errorStatusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
