package com.cleverit.demo.domain.services;

import com.cleverit.demo.data.entities.TaskEntity;
import com.cleverit.demo.data.repository.TaskRepository;
import com.cleverit.demo.domain.exception.TaskNotFoundException;
import com.cleverit.demo.domain.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

/**
 * @author Miguel Angel
 * @since v1.0.0
 */

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    private void init() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should return valid Task Entity.")
    @Test
    public void test1() {
        //Arrange
        Mockito.when(taskRepository.findById(10L)).thenReturn(Optional.empty());

        //Assert
        TaskNotFoundException exception =
                Assertions.assertThrows(TaskNotFoundException.class, () -> {
                    taskService.getTaskById(10L);
                });
        //Act
        Assertions.assertEquals("Task Not found.", exception.getMessage());
    }

    @DisplayName("Should throw NotFoundTaskException when getTaskById isCalled.")
    @Test
    public void test2() {
        //Arrange
        Mockito.when(taskRepository.findById(15L))
                .thenReturn(Optional.of(TaskEntity.builder()
                                .id(15L)
                                .title("Test Task")
                                .description("Test")
                                .expirationDate("2023-09-28")
                                .status("PENDING")
                                .build()));

        //Assert
        Task foundTask = taskService.getTaskById(15L);

        //Act
        Assertions.assertNotNull(foundTask);
        Assertions.assertEquals("Test Task", foundTask.getTitle());
    }

}
