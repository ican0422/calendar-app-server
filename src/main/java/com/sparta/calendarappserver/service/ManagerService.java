package com.sparta.calendarappserver.service;

import com.sparta.calendarappserver.repository.ManagerRepository;
import com.sparta.calendarappserver.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    // 담당자 생성

    // 담당자 단건 조회

    // 담당자 다건 조회

    // 담당자 수정

    // 담당자 삭제
}
