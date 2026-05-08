package com.aayush.student_management.service.impl;

import com.aayush.student_management.dto.level.LevelRequestDto;
import com.aayush.student_management.dto.level.LevelResponseDto;
import com.aayush.student_management.dto.level.LevelUpdateDto;
import com.aayush.student_management.entity.Level;
import com.aayush.student_management.exception.ResourceNotFoundException;
import com.aayush.student_management.repository.LevelRepository;
import com.aayush.student_management.service.LevelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;
    private final ModelMapper modelMapper;

    public LevelServiceImpl(LevelRepository levelRepository, ModelMapper modelMapper) {
        this.levelRepository = levelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<LevelResponseDto> getAllLevels(){
        List<Level> levels =  levelRepository.findAll();
        return levels.stream().map(level ->  modelMapper.map(level, LevelResponseDto.class)).toList();
    }

    @Override
    public LevelResponseDto createLevel(LevelRequestDto levelRequestDto){
        Level level = new Level();
        level.setName(levelRequestDto.getName());
        level.setTime(levelRequestDto.getTime());
        levelRepository.save(level);
        return modelMapper.map(level, LevelResponseDto.class);
    }

    @Override
    public void deleteLevelById(Long levelId) {
       Level level = levelRepository.findById(levelId).orElseThrow(()-> new ResourceNotFoundException("Level with id: " + levelId + " not found"));
       levelRepository.deleteById(levelId);
    }

    @Override
    public LevelResponseDto updateById(
            Long levelId,
            LevelUpdateDto levelUpdateDto) {
        Level level = levelRepository.findById(levelId).orElseThrow(()-> new ResourceNotFoundException("Level with id: " + levelId + " not found"));

        modelMapper.map(levelUpdateDto, level);
        levelRepository.save(level);
       return modelMapper.map(level, LevelResponseDto.class);
    }
}
