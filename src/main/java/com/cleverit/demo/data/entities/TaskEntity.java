package com.cleverit.demo.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Miguel Angel
 * @since v1.0.0
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TASK")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "EXPIRATION_DATE")
    private String expirationDate;

    @Column(name = "STATUS")
    private String status;

}
