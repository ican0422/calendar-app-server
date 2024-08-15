package com.sparta.calendarappserver.dto.manager.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class PostManagerRequestDto {
    @NotEmpty(message = "이름을 입력하세요.")
    private String name;

    @Email(message = "이메일 규격에 맞게 입력해주세요.")
    private String email;
}
