package com.sparta.calendarappserver.dto;

import lombok.Getter;

@Getter
public class GetAllScheduleResponseDto {
    private Long id;
    //    private Long Manager_Id; // 담당자 고유 ID (수정 필요)
    private String name;
    private String content;

    public GetAllScheduleResponseDto(Long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }
}
