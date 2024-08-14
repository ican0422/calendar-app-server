package com.sparta.calendarappserver.dto.manager.response;

import lombok.Getter;

import java.util.Date;

@Getter
public class GetAllManagerResponseDto {
    private Long id;
    private String name;
    private String email;
    private Date registrationDate;
    private Date revisionDate;

    public GetAllManagerResponseDto(Long id, String name, String email, Date registrationDate, Date revisionDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
        this.revisionDate = revisionDate;
    }
}
