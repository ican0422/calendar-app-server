package com.sparta.calendarappserver.exception.custom;

public class ScheduleNotFound extends RuntimeException {
    public ScheduleNotFound(Long id) {
        super("일정 ID를 찾지 못했습니다." + id);
    }
}
