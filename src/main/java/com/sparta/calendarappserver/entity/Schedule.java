package com.sparta.calendarappserver.entity;

import com.sparta.calendarappserver.dto.request.PostScheduleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public Schedule(PostScheduleRequestDto requestDto) {
        this.Name = requestDto.getName();
        this.Content = requestDto.getContent();
        this.Password = requestDto.getPassword();
    }
}
