package com.aayush.student_management.service;


import com.aayush.student_management.dto.level.LevelResponseDto;
import com.aayush.student_management.entity.Level;

import java.util.List;

public interface LevelService {
    List<LevelResponseDto> getAllLevels();
}
