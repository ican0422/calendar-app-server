package com.sparta.calendarappserver.dto.request;

import lombok.Getter;

// 받는 요청 데이터
@Getter
public class PostScheduleRequestDto {
//    private Long Manager_Id; // 담당자 고유 ID (수정 필요)
    private String name;
    private String content;
    private String password;
}
