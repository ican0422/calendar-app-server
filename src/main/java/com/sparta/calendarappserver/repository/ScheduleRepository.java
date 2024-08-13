package com.sparta.calendarappserver.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
