package com.sparta.calendarappserver.dto.manager.response;

import com.sparta.calendarappserver.entity.Manager;
import lombok.Getter;

import java.util.Date;

@Getter
public class GetManagerResponseDto {
    private Long id;
    private String name;
    private String email;
    private Date registrationDate;
    private Date revisionDate;

    public GetManagerResponseDto(Manager oneManager) {
        this.id = oneManager.getId();
        this.name = oneManager.getName();
        this.email = oneManager.getEmail();
        this.registrationDate = oneManager.getRegistrationDate();
        this.revisionDate = oneManager.getRevisionDate();
    }
}
