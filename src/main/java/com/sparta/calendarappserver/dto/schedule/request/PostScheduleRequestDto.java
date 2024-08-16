package com.sparta.calendarappserver.dto.schedule.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

// 받는 요청 데이터
@Getter
public class PostScheduleRequestDto {

    @NotBlank(message = "사용자 아이디를 입력해주세요.")
    private Long manager_id;

    @Size(max = 200, message = "1이상 200글자 이내로 입력해주세요.")
    private String content;

    @NotBlank(message = "비밀번호는 필수로 입력하셔야 합니다.")
    private String password;
}
