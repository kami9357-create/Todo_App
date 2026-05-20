package com.devamateur.Todo_App.dto.request;

import com.devamateur.Todo_App.enums.Priority;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class TaskPatchRequest {
    @Size(min = 1, max = 100, message = "TITLE_TOO_LONG")
    private String title;

    @Size(max = 500, message = "DESCRIPTION_TOO_LONG")
    private String description;

    @FutureOrPresent(message = "DUE_DATE_INVALID")
    private LocalDateTime dueDate;

    private Priority priority;
}
