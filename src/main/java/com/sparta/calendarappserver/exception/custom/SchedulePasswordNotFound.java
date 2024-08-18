package com.sparta.calendarappserver.exception.custom;

public class SchedulePasswordNotFound extends RuntimeException {
    public SchedulePasswordNotFound(String password) {
        super("비밀번호가 받지 않습니다.");
    }
}
