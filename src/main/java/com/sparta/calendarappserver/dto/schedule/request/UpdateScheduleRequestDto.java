package com.sparta.calendarappserver.dto.schedule.request;

import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {
    private Long manager_id;
    private String content;
    private String password;
}
