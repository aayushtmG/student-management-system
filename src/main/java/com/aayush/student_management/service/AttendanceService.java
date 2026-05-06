package com.aayush.student_management.service;

import com.aayush.student_management.dto.attendance.AttendanceRequestDto;
import com.aayush.student_management.dto.attendance.AttendanceResponseDto;
import com.aayush.student_management.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceService {
   List<AttendanceResponseDto> getAllAttendance();
   AttendanceResponseDto createAttendance(AttendanceRequestDto attendanceRequestDto);
}
