package com.devamateur.Todo_App.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@Getter
@AllArgsConstructor
public enum ErrorCode {
        TASK_NOT_FOUND(1001, "Task not found"),
        UNCATEGORIZED_EXCEPTION(9999, "Uncategorized exception"),
        TITLE_REQUIRED(1002, "Title is required"),
        TITLE_TOO_LONG(1003, "Title must be at most 100 characters"),
        DESCRIPTION_TOO_LONG(1004, "Description must be at most 500 characters")
        ;
     int code;
     String message;
}
