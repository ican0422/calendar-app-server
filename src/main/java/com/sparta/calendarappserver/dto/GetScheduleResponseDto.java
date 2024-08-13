package com.sparta.calendarappserver.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class GetScheduleResponseDto {
    private Long id;
    //    private Long Manager_Id; // 담당자 고유 ID (수정 필요)
    private String name;
    private String content;
    private Date registrationDate;
    private Date revisionDate;

    public GetScheduleResponseDto(Long id, String name, String content, Date registrationDate, Date revisionDate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.registrationDate = registrationDate;
        this.revisionDate = revisionDate;
    }
}
