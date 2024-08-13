package com.sparta.calendarappserver.dto;

import lombok.Getter;

import java.time.LocalDate;

// 받는 요청 데이터
@Getter
public class ScheduleRequestDto {
    private String Content;
    private Long Manager_Id; // 담당자 고유 ID (수정 필요)
    private String Password;
    private LocalDate Registration_Date;
    private LocalDate Revision_Date;
}
