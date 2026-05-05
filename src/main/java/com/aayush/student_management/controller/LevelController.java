package com.aayush.student_management.controller;

import com.aayush.student_management.dto.level.LevelRequestDto;
import com.aayush.student_management.dto.level.LevelResponseDto;
import com.aayush.student_management.service.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/levels")
public class LevelController {

    public final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping
    public ResponseEntity<List<LevelResponseDto>> getAllLevels(){
          return new ResponseEntity<>(levelService.getAllLevels(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LevelResponseDto> createLevel(
            @RequestBody LevelRequestDto levelData
            ){
        LevelResponseDto createdLevel = levelService.createLevel(levelData);
        return  new ResponseEntity<>(createdLevel,HttpStatus.CREATED);
    }

}