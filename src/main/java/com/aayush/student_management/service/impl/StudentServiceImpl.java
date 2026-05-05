package com.aayush.student_management.service.impl;

import com.aayush.student_management.dto.student.StudentResponseDto;
import com.aayush.student_management.entity.Level;
import com.aayush.student_management.entity.Student;
import com.aayush.student_management.dto.student.StudentCreateDto;
import com.aayush.student_management.repository.LevelRepository;
import com.aayush.student_management.repository.StudentRepository;
import com.aayush.student_management.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final LevelRepository levelRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentCreateDto> getAllStudents(){
       List<Student> students =  studentRepository.findAll();
     return students.stream().map(student -> modelMapper.map(student, StudentCreateDto.class)).toList();
    }


    @Override
    public StudentResponseDto createStudent(
            StudentCreateDto studentCreateDto
    ){
       //getting the level
        Level level = levelRepository.findById(studentCreateDto.getLevelId()).orElseThrow(()-> new RuntimeException("Level id: " + studentCreateDto.getLevelId() +  " not found!"));

        Student student = new Student();
        student.setLevel(level);
        student.setName(studentCreateDto.getName());
        studentRepository.save(student);
        return modelMapper.map(student, StudentResponseDto.class);
    }


}
