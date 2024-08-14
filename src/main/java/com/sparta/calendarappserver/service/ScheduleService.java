package com.sparta.calendarappserver.service;

import com.sparta.calendarappserver.dto.schedule.request.DeleteScheduleRequestDto;
import com.sparta.calendarappserver.dto.schedule.request.PostScheduleRequestDto;
import com.sparta.calendarappserver.dto.schedule.request.UpdateScheduleRequestDto;
import com.sparta.calendarappserver.dto.schedule.response.GetAllScheduleResponseDto;
import com.sparta.calendarappserver.dto.schedule.response.GetScheduleResponseDto;
import com.sparta.calendarappserver.dto.schedule.response.PostScheduleResponseDto;
import com.sparta.calendarappserver.entity.Schedule;
import com.sparta.calendarappserver.repository.ScheduleRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // 일정 생성
    public PostScheduleResponseDto creatSchedule(PostScheduleRequestDto requestDto) {
        // requestDto -> entity
        Schedule schedule = new Schedule(requestDto);

        // db 저장
        Schedule saveSchedule = scheduleRepository.saveSchedule(schedule);

        // entity -> requestDto
        PostScheduleResponseDto scheduleResponseDto = new PostScheduleResponseDto(saveSchedule);

        return scheduleResponseDto;
    }

    // 일정 하나만 조회
    public GetScheduleResponseDto getScheduleResponseDto(Long id) {
        // entity -> requestDto
        GetScheduleResponseDto getSchedule = new GetScheduleResponseDto(scheduleRepository.getOneSchedule(id));
        if (getSchedule != null) {
            return getSchedule;
        } else {
            throw new NullPointerException("선택한 일정은 존재하지 않습니다.");
        }
    }

    // 일정 전부 조회
    public List<GetAllScheduleResponseDto> getAllSchedule(Date revision , String name, Pageable pageable) {
        // db 조회
        return scheduleRepository.findAllSchedule(revision, name, pageable);
    }

    // 일정 수정
    public Long updateSchedule(Long id, UpdateScheduleRequestDto updateScheduleRequestDto) {
        // 일정이 있는지 확인
        Schedule findId = scheduleRepository.findById(id);
        if (findId != null){
            Schedule findPwd = scheduleRepository.findByPwd(id);
            if (findPwd.getPassword().equals(updateScheduleRequestDto.getPassword())) {
                scheduleRepository.update(id, updateScheduleRequestDto);
                return id;
            } else {
                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
            }
        } else {
            throw new NullPointerException("해당 일정이 없습니다.");
        }
    }

    // 일정 삭제
    public Long deleteSchedule(Long id, DeleteScheduleRequestDto deleteScheduleRequestDto) {
        // 일정이 있는지 확인
        Schedule findId = scheduleRepository.findById(id);
        if (findId != null){
            Schedule findPwd = scheduleRepository.findByPwd(id);
            if (findPwd.getPassword().equals(deleteScheduleRequestDto.getPassword())) {
                scheduleRepository.delete(id);
                return id;
            } else {
                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
            }
        } else {
            throw new NullPointerException("해당 일정이 없습니다.");
        }
    }
}
