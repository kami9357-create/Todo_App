package com.devamateur.Todo_App.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@Getter
@AllArgsConstructor
public enum ErrorCode {
        TASK_NOT_FOUND(1001, "Task not found"),
        UNCATEGORIZED_EXCEPTION(9999, "Uncategorized exception")
        ;
     int code;
     String message;
}
