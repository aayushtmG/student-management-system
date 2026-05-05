package com.aayush.student_management.repository;

import com.aayush.student_management.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LevelRepository extends JpaRepository<Level,Long> {
}
