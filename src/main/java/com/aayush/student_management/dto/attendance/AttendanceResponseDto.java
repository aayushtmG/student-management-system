package com.aayush.student_management.dto.attendance;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AttendanceResponseDto {
    private Long id;
    private String studentName;
    private String level;
    private LocalDate date;
    private String status;
}
