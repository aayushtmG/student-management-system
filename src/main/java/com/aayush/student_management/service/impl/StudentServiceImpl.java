package com.aayush.student_management.service.impl;

import com.aayush.student_management.dto.student.StudentResponseDto;
import com.aayush.student_management.entity.Level;
import com.aayush.student_management.entity.Student;
import com.aayush.student_management.dto.student.StudentCreateDto;
import com.aayush.student_management.exception.ResourceNotFoundException;
import com.aayush.student_management.repository.LevelRepository;
import com.aayush.student_management.repository.StudentRepository;
import com.aayush.student_management.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final LevelRepository levelRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentResponseDto> getAllStudents(Long levelId){
       List<Student> students =  studentRepository.findAll();
       if(levelId != null){
           Level selectedLevel = levelRepository.findById(levelId).orElseThrow(()-> new ResourceNotFoundException("Level not found!"));
           students = students.stream().filter(student ->
                student.getLevel() != null && student.getLevel().equals(selectedLevel)
           ).toList();
       }
     return students.stream().map(student -> modelMapper.map(student, StudentResponseDto.class)).toList();
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

    @Override
    public StudentResponseDto getStudentById(
           Long id
    ){
    Student student =   studentRepository.findById(id).orElseThrow(()-> new  ResourceNotFoundException("Student with id: " + id + " not found!"));
    return modelMapper.map(student, StudentResponseDto.class);
    }

    @Override
    public StudentResponseDto updateStudentById(Long id, StudentCreateDto newStudentDto){
        Student student =   studentRepository.findById(id).orElseThrow(()-> new  ResourceNotFoundException("Student with id: " + id + " not found!"));

        if(newStudentDto.getName() != null){
            student.setName(newStudentDto.getName());
        }
        if(newStudentDto.getLevelId() != null){
            Level level = levelRepository.findById(newStudentDto.getLevelId()).orElseThrow(()-> new  ResourceNotFoundException("Level with id: " + newStudentDto.getLevelId() + " not found!"));
            student.setLevel(level);
        }

        studentRepository.save(student);
        return modelMapper.map(student,StudentResponseDto.class);
    }

    @Override
    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }

}
