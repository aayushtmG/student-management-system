package com.aayush.student_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Attendance {

   @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

  @ManyToOne
  @JoinColumn(name = "student_id")
   private Student student;

  @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

   private LocalDate date;
   private String status;



}

