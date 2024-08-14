package com.sparta.calendarappserver.entity;

import com.sparta.calendarappserver.dto.schedule.request.PostScheduleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    // 스케줄러 DB 컬럼
    private Long Id;
    private String Name;
//    private Long Manager_Id; // 담당자 고유 ID FK (수정 필요)
    private String Content;
    private String Password;
    private Date RegistrationDate;
    private Date RevisionDate;

    public Schedule(PostScheduleRequestDto requestDto) {
        this.Name = requestDto.getName();
        this.Content = requestDto.getContent();
        this.Password = requestDto.getPassword();
    }

    public Schedule(Long scheduleId, String name, String content, Date registrationDate, Date revisionDate) {
        this.Id = scheduleId;
        this.Name = name;
        this.Content = content;
        this.RegistrationDate = registrationDate;
        this.RevisionDate = revisionDate;
    }
}
