package com.aayush.student_management.service.impl;

import com.aayush.student_management.dto.attendance.AttendanceRequestDto;
import com.aayush.student_management.dto.attendance.AttendanceResponseDto;
import com.aayush.student_management.entity.Attendance;
import com.aayush.student_management.entity.Level;
import com.aayush.student_management.entity.Student;
import com.aayush.student_management.exception.ResourceNotFoundException;
import com.aayush.student_management.repository.AttendanceRepository;
import com.aayush.student_management.repository.LevelRepository;
import com.aayush.student_management.repository.StudentRepository;
import com.aayush.student_management.service.AttendanceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

   private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final LevelRepository levelRepository;
    private final ModelMapper modelMapper;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, StudentRepository studentRepository, LevelRepository levelRepository, ModelMapper modelMapper) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
        this.levelRepository = levelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AttendanceResponseDto> getAllAttendance(){
        List<Attendance> attendanceList =  attendanceRepository.findAll();
        return   attendanceList.stream().map(
                attendance -> modelMapper.map(attendance, AttendanceResponseDto.class)).toList();
    }
    @Override
    public AttendanceResponseDto createAttendance(
            @RequestBody AttendanceRequestDto attendanceData
    ){
       //fetch the student  from the db
        Student student  = studentRepository.findById(attendanceData.getStudentId()).orElseThrow(()-> new RuntimeException("Couldn't find student with id: " + attendanceData.getStudentId()));

        //fetch the student  from the db
        Level level = levelRepository.findById(attendanceData.getLevelId()).orElseThrow(()-> new RuntimeException("Couldn't find level with id: " + attendanceData.getLevelId() ));

        Attendance attendance =  new Attendance();
        attendance.setStudent(student);
        attendance.setLevel(level);
        attendance.setStatus(attendanceData.getStatus());
        attendanceRepository.save(attendance);
        return modelMapper.map(attendance, AttendanceResponseDto.class);
    }

    public void deleteAttendanceById(Long id){
        attendanceRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id doesn't exists"));
        attendanceRepository.deleteById(id);
    }
}
