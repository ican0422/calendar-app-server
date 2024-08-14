package com.sparta.calendarappserver.dto.manager.response;

import lombok.Getter;

import java.util.Date;

@Getter
public class GetAllManagerResponseDto {
    private Long id;
    private String name;
    private String content;
    private Date registrationDate;
    private Date revisionDate;
}
