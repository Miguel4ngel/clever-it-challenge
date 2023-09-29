package com.cleverit.demo.domain.model;

import com.cleverit.demo.domain.model.enums.TaskStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.time.Instant;
import java.time.LocalDate;

/**
 * @author Miguel Angel
 * @since v1.0.0
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @NotEmpty(message = "The field title is required.")
    private String title;

    @NotEmpty(message = "The field description is required.")
    private String description;

    @Future
    private LocalDate expirationDate;

    @NotEmpty(message = "The field title is required and must be a valid status.")
    private TaskStatusEnum status;

}
