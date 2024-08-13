package com.sparta.calendarappserver.controller;

import com.sparta.calendarappserver.dto.GetAllScheduleResponseDto;
import com.sparta.calendarappserver.dto.GetScheduleResponseDto;
import com.sparta.calendarappserver.dto.PostScheduleRequestDto;
import com.sparta.calendarappserver.dto.PostScheduleResponseDto;
import com.sparta.calendarappserver.service.ScheduleService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RestController
@RestController
// RequestMapping ("/api")
@RequestMapping("/api")
public class ScheduleController {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 일정 등록 (POST)
    @PostMapping("/schedules")
    public PostScheduleResponseDto createSchedule(@RequestBody PostScheduleRequestDto requestDto) {
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.creatSchedule(requestDto);
    }
    // 일정 조회 (GET)
    @GetMapping("/schedules/{id}")
    public GetScheduleResponseDto getOneSchedule(@PathVariable Long id) {
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.getScheduleResponseDto(id);
    }
    // 일정 전체 조회 (GET)
    @GetMapping("/schedules")
    public List<GetAllScheduleResponseDto> getAllSchedule() {
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.getAllSchedule();
    }
    // 일정 수정 (PUT)
    @PutMapping("/schedules/{id}")
    public Long updateSchedule(@PathVariable Long id, @RequestBody PostScheduleRequestDto requestDto) {
        return null;
    }
    // 일정 삭제 (DELETE)
    @DeleteMapping("/schedules/{id}")
    public Long deleteSchedule(@PathVariable Long id) {
        return null;
    }
}
