package com.sparta.calendarappserver.entity;

import com.sparta.calendarappserver.dto.manager.request.PostManagerRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Manager {
    private Long Id;
    private String Name;
    private String Email;
    private Date RegistrationDate;
    private Date RevisionDate;

    public Manager(PostManagerRequestDto postManagerRequestDto) {
        this.Name = postManagerRequestDto.getName();
        this.Email = postManagerRequestDto.getEmail();
    }

    public Manager(Long managerId, String name, String email, Date registrationDate, Date revisionDate) {
        this.Id = managerId;
        this.Name = name;
        this.Email = email;
        this.RegistrationDate = registrationDate;
        this.RevisionDate = revisionDate;
    }
}
