package com.sparta.calendarappserver.dto.schedule.request;

import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {
    private String name;
    private String content;
    private String password;
}
