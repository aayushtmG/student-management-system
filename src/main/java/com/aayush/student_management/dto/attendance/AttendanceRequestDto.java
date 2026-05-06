package com.aayush.student_management.dto.attendance;

import lombok.Data;

@Data
public class AttendanceRequestDto {
    private Long studentId;
    private Long levelId;
    private String status;
}
