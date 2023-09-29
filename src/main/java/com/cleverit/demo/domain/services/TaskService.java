package com.cleverit.demo.domain.services;

import com.cleverit.demo.data.entities.TaskEntity;
import com.cleverit.demo.data.repository.TaskRepository;
import com.cleverit.demo.domain.exception.TaskNotFoundException;
import com.cleverit.demo.domain.mapper.TaskMapper;
import com.cleverit.demo.domain.model.Task;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miguel Angel
 * @since v1.0.0
 */

@Service
@Log4j2
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTaskById(Long id) {
        log.info("[getTaskById] Searching Task by ID [{}]", id);
        return TaskMapper.fromEntity(taskRepository.findById(id).orElseThrow(TaskNotFoundException::thrown));
    }

    public List<Task> getAllTasks() {
        log.info("[getAllTasks] Searching All Tasks.");
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().stream().forEach(taskEntity -> {
            tasks.add(TaskMapper.fromEntity(taskEntity));
        });
        return tasks;
    }

    public void createTask(Task task) {
        log.info("[createTask] Creating new Task from Request [{}]", task);
        TaskEntity taskEntity = TaskMapper.fromTaskDTO(task);
        try {
            taskRepository.save(taskEntity);
            log.info("[createTask] New Task created with ID [{}]", taskEntity.getId());
        } catch (Exception ex) {
            log.error("[createTask] Error creating new Task. Cause: [{}]", ex.getMessage());
        }
    }

    public void deleteTask(Long id) {
        log.info("[deleteTask] Deleting task with Id [{}]", id);
        taskRepository.delete(taskRepository.findById(id).orElseThrow(TaskNotFoundException::thrown));
        log.info("[deleteTask] Task deleted");
    }

    public void updateTask(Long id, Task task) {
        log.info("[updateTask] Updating task with Id [{}]", id);
        TaskEntity taskEntity =
                TaskMapper.updateFromTaskDTO(task, taskRepository.findById(id)
                        .orElseThrow(TaskNotFoundException::thrown));
        taskRepository.save(taskEntity);
        log.info("[updateTask] Task updated. New values [{}]", task);
    }
}
