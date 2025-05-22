package com.jar100.mssproduct.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonResponse<T> {
    private final Result result;
    private final T data;
    private final String message;
    private final String errorCode;

    /**
     * 성공 응답 (데이터 없음)
     */
    public static CommonResponse<Void> success() {
        return CommonResponse.<Void>builder()
            .result(Result.SUCCESS)
            .build();
    }

    /**
     * 성공 응답 (데이터 포함)
     */
    public static <T> CommonResponse<T> success(T data) {
        return CommonResponse.<T>builder()
            .result(Result.SUCCESS)
            .data(data)
            .build();
    }

    /**
     * 성공 응답 (데이터 및 메시지 포함)
     */
    public static <T> CommonResponse<T> success(T data, String message) {
        return CommonResponse.<T>builder()
            .result(Result.SUCCESS)
            .data(data)
            .message(message)
            .build();
    }

    /**
     * 실패 응답 (에러 코드 및 메시지 포함)
     */
    public static CommonResponse<Void> fail(String errorCode, String message) {
        return CommonResponse.<Void>builder()
            .result(Result.FAIL)
            .errorCode(errorCode)
            .message(message)
            .build();
    }

    /**
     * 실패 응답 (ErrorCode 사용)
     */
    public static CommonResponse<Void> fail(ErrorCode error) {
        return CommonResponse.<Void>builder()
            .result(Result.FAIL)
            .errorCode(error.getCode())
            .message(error.getMessage())
            .build();
    }

    public enum Result {
        SUCCESS,
        FAIL
    }
}