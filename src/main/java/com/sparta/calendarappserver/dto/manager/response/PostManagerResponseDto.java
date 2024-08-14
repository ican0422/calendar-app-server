package com.sparta.calendarappserver.dto.manager.response;

import com.sparta.calendarappserver.entity.Manager;
import lombok.Getter;

@Getter
public class PostManagerResponseDto {
    private Long id;
    private String name;
    private String email;

    public PostManagerResponseDto(Manager saveManager) {
        this.id = saveManager.getId();
        this.name = saveManager.getName();
        this.email = saveManager.getEmail();
    }
}
