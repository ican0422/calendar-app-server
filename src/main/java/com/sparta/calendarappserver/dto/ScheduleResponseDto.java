package com.sparta.calendarappserver.dto;

import lombok.Getter;

import java.time.LocalDate;

// 반환 데이터
@Getter
public class ScheduleResponseDto {
    private Long Id;
    private String Content;
    private Long Manager_Id; // 담당자 고유 ID (수정 필요)
    private String Password;
    private LocalDate Registration_Date;
    private LocalDate Revision_Date;
}
