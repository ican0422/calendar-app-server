package com.sparta.calendarappserver.service;

import com.sparta.calendarappserver.dto.GetAllScheduleResponseDto;
import com.sparta.calendarappserver.dto.PostScheduleRequestDto;
import com.sparta.calendarappserver.dto.PostScheduleResponseDto;
import com.sparta.calendarappserver.entity.Schedule;
import com.sparta.calendarappserver.repository.ScheduleRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ScheduleService {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 일정 생성
    public PostScheduleResponseDto creatSchedule(PostScheduleRequestDto requestDto) {
        // requestDto -> entity
        Schedule schedule = new Schedule(requestDto);

        // db 저장
        ScheduleRepository scheduleRepository = new ScheduleRepository(jdbcTemplate);
        Schedule saveSchedule = scheduleRepository.saveSchedule(schedule);

        // entity -> requestDto
        PostScheduleResponseDto scheduleResponseDto = new PostScheduleResponseDto(saveSchedule);

        return scheduleResponseDto;
    }

    // 일정 전부 조회
    public List<GetAllScheduleResponseDto> getAllSchedule() {
        // db 조회
        ScheduleRepository scheduleRepository = new ScheduleRepository(jdbcTemplate);
        return scheduleRepository.findAllSchedule();
    }
}
