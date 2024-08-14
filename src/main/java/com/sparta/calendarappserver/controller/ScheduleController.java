package com.sparta.calendarappserver.controller;

import com.sparta.calendarappserver.dto.schedule.request.DeleteScheduleRequestDto;
import com.sparta.calendarappserver.dto.schedule.request.PostScheduleRequestDto;
import com.sparta.calendarappserver.dto.schedule.request.UpdateScheduleRequestDto;
import com.sparta.calendarappserver.dto.schedule.response.GetAllScheduleResponseDto;
import com.sparta.calendarappserver.dto.schedule.response.GetScheduleResponseDto;
import com.sparta.calendarappserver.dto.schedule.response.PostScheduleResponseDto;
import com.sparta.calendarappserver.service.ScheduleService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

// RestController
@RestController
// RequestMapping ("/api")
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 일정 등록 (POST)
    @PostMapping("/schedules")
    public PostScheduleResponseDto createSchedule(@RequestBody PostScheduleRequestDto requestDto) {
        return scheduleService.creatSchedule(requestDto);
    }
    // 일정 조회 (GET)
    @GetMapping("/schedules/{id}")
    public GetScheduleResponseDto getOneSchedule(@PathVariable Long id) {
        return scheduleService.getScheduleResponseDto(id);
    }
    // 일정 전체 조회 (GET)
    @GetMapping("/schedules/param")
    public List<GetAllScheduleResponseDto> getAllSchedule(
            @RequestParam(required = false) Date revision,
            @RequestParam(required = false) String name,
            @PageableDefault(page = 0, size = 5) Pageable pageable
    ) {
        return scheduleService.getAllSchedule(revision, name, pageable);
    }
    // 일정 수정 (PUT)
    @PutMapping("/schedules/{id}")
    public Long updateSchedule(@PathVariable Long id, @RequestBody UpdateScheduleRequestDto updateScheduleRequestDto) {
        return scheduleService.updateSchedule(id, updateScheduleRequestDto);
    }
    // 일정 삭제 (DELETE)
    @DeleteMapping("/schedules/{id}")
    public Long deleteSchedule(@PathVariable Long id, @RequestBody DeleteScheduleRequestDto deleteScheduleRequestDto) {
        return scheduleService.deleteSchedule(id, deleteScheduleRequestDto);
    }

    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<String> exception(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
