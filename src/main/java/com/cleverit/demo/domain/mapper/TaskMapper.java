package com.cleverit.demo.domain.mapper;

import com.cleverit.demo.data.entities.TaskEntity;
import com.cleverit.demo.domain.model.Task;
import com.cleverit.demo.domain.model.enums.TaskStatusEnum;

import java.time.LocalDate;

/**
 * @author Miguel Angel
 * @since v1.0.0
 */

public class TaskMapper {

    public static TaskEntity fromTaskDTO(Task task) {
        return TaskEntity.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .expirationDate(task.getExpirationDate().toString())
                .status(task.getStatus().name())
                .build();
    }

    public static Task fromEntity(TaskEntity taskEntity) {
        return Task.builder()
                .title(taskEntity.getTitle())
                .description(taskEntity.getDescription())
                .expirationDate(LocalDate.parse(taskEntity.getExpirationDate()))
                .status(TaskStatusEnum.valueOf(taskEntity.getStatus()))
                .build();
    }

    public static TaskEntity updateFromTaskDTO(Task task, TaskEntity taskEntity) {
        taskEntity.setTitle(task.getTitle());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setExpirationDate(task.getExpirationDate().toString());
        taskEntity.setStatus(task.getStatus().name());
        return taskEntity;
    }

}
