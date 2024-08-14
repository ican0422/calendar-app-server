package com.sparta.calendarappserver.dto.schedule.response;

import com.sparta.calendarappserver.entity.Schedule;
import lombok.Getter;

// 반환 데이터
@Getter
public class PostScheduleResponseDto {
    private Long id;
//    private Long Manager_Id; // 담당자 고유 ID (수정 필요)
    private String name;
    private String content;
    private String password;

    public PostScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.content = schedule.getContent();
        this.password = schedule.getPassword();
    }
}
