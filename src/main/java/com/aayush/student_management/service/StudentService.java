package com.aayush.student_management.service;

import com.aayush.student_management.dto.student.StudentCreateDto;
import com.aayush.student_management.dto.student.StudentResponseDto;

import java.util.List;

public interface StudentService {
    List<StudentCreateDto> getAllStudents();
    StudentResponseDto createStudent(StudentCreateDto studentDto);
}
