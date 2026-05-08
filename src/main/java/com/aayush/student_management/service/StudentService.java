package com.aayush.student_management.service;

import com.aayush.student_management.dto.student.StudentCreateDto;
import com.aayush.student_management.dto.student.StudentResponseDto;

import java.util.List;

public interface StudentService {
    List<StudentResponseDto> getAllStudents(Long levelId);
    StudentResponseDto createStudent(StudentCreateDto studentDto);
    StudentResponseDto getStudentById(Long id);
    StudentResponseDto updateStudentById(Long id,StudentCreateDto newStudentData);
    void deleteStudentById(Long id);
}
