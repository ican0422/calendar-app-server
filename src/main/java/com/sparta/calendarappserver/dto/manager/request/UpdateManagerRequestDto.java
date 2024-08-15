package com.sparta.calendarappserver.dto.manager.request;

import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class UpdateManagerRequestDto {
    private String name;

    @Email(message = "이메일 규격에 맞게 입력해주세요.")
    private String email;
}
