package com.devamateur.Todo_App.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

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
}
