package com.sparta.calendarappserver.controller;

import com.sparta.calendarappserver.dto.ScheduleRequestDto;
import com.sparta.calendarappserver.dto.ScheduleResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller
@Controller
// RequestMapping ("/api")
@RequestMapping("/api")
public class ScheduleController {

    // 일정 등록 (POST)
    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return null;
    }
    // 일정 조회 (GET)
    @GetMapping("/schedules/{id}")
    public ScheduleResponseDto getOneSchedule(@PathVariable Long id) {
        return null;
    }
    // 일정 전체 조회 (GET)
    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getAllSchedule() {
        return null;
    }
    // 일정 수정 (PUT)
    @PutMapping("/schedules/{id}/managers/{pwd}")
    public Long updateSchedule(@PathVariable Long id, @PathVariable String pwd, @RequestBody ScheduleRequestDto requestDto) {
        return null;
    }
    // 일정 삭제 (DELETE)
    @DeleteMapping("/schedules/{id}/managers/{pwd}")
    public Long deleteSchedule(@PathVariable Long id, @PathVariable String pwd) {
        return null;
    }
}
