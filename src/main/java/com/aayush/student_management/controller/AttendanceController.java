package com.aayush.student_management.controller;

import com.aayush.student_management.dto.attendance.AttendanceRequestDto;
import com.aayush.student_management.dto.attendance.AttendanceResponseDto;
import com.aayush.student_management.dto.attendance.AttendanceStatusUpdateDto;
import com.aayush.student_management.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;


    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AttendanceResponseDto>>  getAllAttendance(){
      return  new ResponseEntity<>(attendanceService.getAllAttendance(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AttendanceResponseDto> createAttendance(
            @RequestBody AttendanceRequestDto attendanceRequestDto
            ){
        AttendanceResponseDto newAttendanceRecord = attendanceService.createAttendance(attendanceRequestDto);
        return new ResponseEntity<>(newAttendanceRecord,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(
           @PathVariable Long id
    ){
        attendanceService.deleteAttendanceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AttendanceResponseDto> updateAttendanceStatus(
            @PathVariable Long id,
            @RequestBody AttendanceStatusUpdateDto newStatusDto
    ){
        AttendanceResponseDto updatedData = attendanceService.updateAttendanceById(id,newStatusDto);
        return new ResponseEntity<>(updatedData,HttpStatus.OK);
    }

}
