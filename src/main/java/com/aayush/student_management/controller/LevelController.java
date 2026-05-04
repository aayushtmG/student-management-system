package com.aayush.student_management.controller;

import com.aayush.student_management.dto.level.LevelResponseDto;
import com.aayush.student_management.service.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}