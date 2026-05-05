package com.aayush.student_management.repository;

import com.aayush.student_management.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
}
