package com.sparta.calendarappserver.entity;

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
}
