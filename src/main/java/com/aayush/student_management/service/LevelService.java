package com.aayush.student_management.service;


import com.aayush.student_management.dto.level.LevelRequestDto;
import com.aayush.student_management.dto.level.LevelResponseDto;
import com.aayush.student_management.dto.level.LevelUpdateDto;
import com.aayush.student_management.entity.Level;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LevelService {
    List<LevelResponseDto> getAllLevels();
    LevelResponseDto createLevel(LevelRequestDto levelRequestDto);
    void deleteLevelById(Long id);
    LevelResponseDto updateById(Long levelId,LevelUpdateDto levelUpdateDto);
}
