package com.cleverit.demo.data.repository;

import com.cleverit.demo.data.entities.TaskEntity;
import com.cleverit.demo.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Miguel Angel
 * @since v1.0.0
 */

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}
