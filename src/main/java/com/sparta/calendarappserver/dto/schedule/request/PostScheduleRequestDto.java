package com.sparta.calendarappserver.dto.schedule.request;

import lombok.Getter;

// 받는 요청 데이터
@Getter
public class PostScheduleRequestDto {
//    private Long Manager_Id; // 담당자 고유 ID (수정 필요)
    private Long manager_id;
    private String content;
    private String password;
}
