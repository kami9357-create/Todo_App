package com.devamateur.Todo_App.dto.request;

import com.devamateur.Todo_App.enums.Priority;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
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
public class TaskRequest {
    @NotBlank(message = "TITLE_REQUIRED")
    @Size(max = 100, message = "TITLE_TOO_LONG")
    String title;

    @Size(max = 500, message = "DESCRIPTION_TOO_LONG")
    String description;

    @FutureOrPresent(message = "DUE_DATE_INVALID")
    LocalDateTime dueDate;

    Priority priority;
}
