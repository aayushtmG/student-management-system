package com.aayush.student_management.service.impl;

import com.aayush.student_management.dto.attendance.AttendanceResponseDto;
import com.aayush.student_management.entity.Attendance;
import com.aayush.student_management.repository.AttendanceRepository;
import com.aayush.student_management.service.AttendanceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

   private final AttendanceRepository attendanceRepository;
    private final ModelMapper modelMapper;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, ModelMapper modelMapper) {
        this.attendanceRepository = attendanceRepository;
        this.modelMapper =  modelMapper;
    }
    @Override
    public List<AttendanceResponseDto> getAllAttendance(){
        List<Attendance> attendanceList =  attendanceRepository.findAll();
        return   attendanceList.stream().map(
                attendance -> modelMapper.map(attendance, AttendanceResponseDto.class)).toList();
    }
}
