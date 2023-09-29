package com.cleverit.demo.domain.exception;

import net.bytebuddy.asm.Advice;

/**
 * @author Miguel Angel
 * @since v1.0.0
 */

public class TaskNotFoundException extends RuntimeException {

    public static TaskNotFoundException thrown() {
        throw new TaskNotFoundException("Task Not found.");
    }

    private TaskNotFoundException(String message) {
        super(message);
    }
}
