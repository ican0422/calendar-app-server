package com.sparta.calendarappserver.entity;

import com.sparta.calendarappserver.dto.ScheduleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    // 스케줄러 DB 컬럼
    private Long id;
    private Long Manager_Id; // 담당자 고유 ID (수정 필요)
    private String Content;
    private String Password;
    private LocalDate Registration_Date;
    private LocalDate Revision_Date;
}
