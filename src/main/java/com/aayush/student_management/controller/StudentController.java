package com.aayush.student_management.controller;

import com.aayush.student_management.dto.student.StudentCreateDto;
import com.aayush.student_management.dto.student.StudentResponseDto;
import com.aayush.student_management.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDto>> getAllStudents(
            @RequestParam(required = false ) Long levelId
    ){
        return ResponseEntity.ok(studentService.getAllStudents(levelId));
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(
            @RequestBody StudentCreateDto requestDto
    ){
    StudentResponseDto createdStudent = studentService.createStudent(requestDto);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(
            @PathVariable Long id
    ){
    return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }
}
