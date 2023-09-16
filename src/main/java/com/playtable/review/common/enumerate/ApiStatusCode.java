package com.playtable.review.common.enumerate;

import lombok.Getter;

@Getter
public enum ApiStatusCode {

    //COMMON CODE
    NONE (0,"","")
    ,OK (200,"OK","성공.")
    ,CREATED (201,"Created","리소스 생성 완료.")
    ,CONTENT_NOT_FOUND (204,"Content Not Found", "컨텐츠 없음.")
    ,PARAMETER_CHECK_FAILED (400,"Bad Request","문법상 또는 파라미터 오류가 있어서 서버가 요청사항을 처리하지 못함.")
    ,UNAUTHORIZED (401, "UnAuthorized", "Unauthorized, 사용자 인증 실패.")
    ,FORBIDDEN (403, "Forbidden", "Forbidden, 사용권한 없음.")
    ,PERSON_ALREADY_EXISTS(411, "Person already exists", "이미 존재하는 사용자입니다.")
    ,PERSON_NOT_FOUND(404, "Person not found", "해당 이메일의 회원은 존재하지 않습니다")
    ,REVIEW_NOT_FOUND(404, "Review Not Found", "해당 게시물을 찾을 수 없습니다.")
    ,SYSTEM_ERROR(599,"System Error", "시스템오류.")
    ;

    //Enum 필드
    private int code;
    private String type;
    private String message;

    //Enum 생성자
    ApiStatusCode(int code, String type , String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }
}