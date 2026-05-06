package com.aayush.student_management.dto.attendance;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AttendanceResponseDto {
    private Long id;
    private String studentName;
    private String levelName;
    private LocalDate date;
    private String status;
}
