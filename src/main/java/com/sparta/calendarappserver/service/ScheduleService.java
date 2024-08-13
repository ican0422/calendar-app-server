package com.sparta.calendarappserver.service;

import org.springframework.jdbc.core.JdbcTemplate;

public class ScheduleService {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
