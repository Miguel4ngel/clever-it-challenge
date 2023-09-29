package com.cleverit.demo.presentation;

import com.cleverit.demo.domain.model.Task;
import com.cleverit.demo.domain.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * @author Miguel Angel
 * @since v1.0.0
 */

@RestController
@RequestMapping("/task")
@Log4j2
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/{task-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> getTaskById(@PathVariable("task-id") Long id){
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Task>> getAllTask(){
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> creatTask(@Valid @RequestBody Task task){
        taskService.createTask(task);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping(value = "/{task-id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("task-id") Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{task-id}")
    public ResponseEntity<Void> deleteTask(@RequestBody Task task, @PathVariable("task-id") Long id){
        taskService.updateTask(id, task);
        return ResponseEntity.ok().build();
    }

}
