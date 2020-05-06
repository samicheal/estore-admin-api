package com.snowcoder.onlinestore.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.snowcoder.onlinestore.enums.ApiErrorEnums;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import java.util.List;

public class ApiError {

    private HttpStatus httpStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    public ApiError() {
        timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus httpStatus, String message, Throwable ex) {
        this();
        this.httpStatus = httpStatus;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }
}
