package com.sparta.calendarappserver.controller;

import com.sparta.calendarappserver.dto.request.UpdateScheduleRequestDto;
import com.sparta.calendarappserver.dto.response.GetAllScheduleResponseDto;
import com.sparta.calendarappserver.dto.response.GetScheduleResponseDto;
import com.sparta.calendarappserver.dto.request.PostScheduleRequestDto;
import com.sparta.calendarappserver.dto.response.PostScheduleResponseDto;
import com.sparta.calendarappserver.service.ScheduleService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    @GetMapping("/schedules/param")
    public List<GetAllScheduleResponseDto> getAllSchedule(@RequestParam(required = false) Date revision,
                                                          @RequestParam(required = false) String name) {
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.getAllSchedule(revision, name);
    }
    // 일정 수정 (PUT)
    @PutMapping("/schedules/{id}")
    public Long updateSchedule(@PathVariable Long id, @RequestBody UpdateScheduleRequestDto updateScheduleRequestDto) {
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.updateSchedule(id, updateScheduleRequestDto);
    }
    // 일정 삭제 (DELETE)
    @DeleteMapping("/schedules/{id}")
    public Long deleteSchedule(@PathVariable Long id, @RequestBody PostScheduleRequestDto requestDto) {
        return null;
    }
}
