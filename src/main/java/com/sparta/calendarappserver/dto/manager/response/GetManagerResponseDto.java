package com.sparta.calendarappserver.dto.manager.response;

import lombok.Getter;

import java.util.Date;

@Getter
public class GetManagerResponseDto {
    private Long id;
    private String name;
    private String email;
    private Date registrationDate;
    private Date revisionDate;
}
