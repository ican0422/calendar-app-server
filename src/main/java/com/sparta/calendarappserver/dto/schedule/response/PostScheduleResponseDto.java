package com.sparta.calendarappserver.dto.schedule.response;

import com.sparta.calendarappserver.entity.Schedule;
import lombok.Getter;

// 반환 데이터
@Getter
public class PostScheduleResponseDto {
    private Long id;
//    private Long Manager_Id; // 담당자 고유 ID (수정 필요)
    private Long manager_id;
    private String content;
    private String password;

    public PostScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.manager_id = schedule.getManager_Id();
        this.content = schedule.getContent();
        this.password = schedule.getPassword();
    }
}
