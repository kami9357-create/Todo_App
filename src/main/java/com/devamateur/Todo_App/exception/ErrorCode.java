package com.devamateur.Todo_App.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@Getter
@AllArgsConstructor
public enum ErrorCode {

    TASK_NOT_FOUND(
            1001,
            "Task not found",
            HttpStatus.NOT_FOUND
            ),

    UNCATEGORIZED_EXCEPTION(
            9999,
            "Uncategorized exception",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),

    TITLE_REQUIRED(
            1002,
            "Title is required",
            HttpStatus.BAD_REQUEST
    ),

    TITLE_TOO_LONG(
            1003,
            "Title must be at most 100 characters",
            HttpStatus.BAD_REQUEST
    ),

    DESCRIPTION_TOO_LONG(
            1004,
            "Description must be at most 500 characters",
            HttpStatus.BAD_REQUEST
    ),

    DUE_DATE_INVALID(
            1005,
            "Due date must be in the present or future",
            HttpStatus.BAD_REQUEST),

    INVALID_REQUEST(
            1006,
            "Invalid request",
            HttpStatus.BAD_REQUEST
    ),

    PRIORITY_INVALID(
            1007,
            "Invalid priority value",
            HttpStatus.BAD_REQUEST
    )
    ;

    int code;
    String message;
    HttpStatus httpStatus;
}
