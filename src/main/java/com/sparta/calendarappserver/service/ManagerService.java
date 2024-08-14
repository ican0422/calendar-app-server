package com.sparta.calendarappserver.service;

import com.sparta.calendarappserver.dto.manager.request.PostManagerRequestDto;
import com.sparta.calendarappserver.dto.manager.request.UpdateManagerRequestDto;
import com.sparta.calendarappserver.dto.manager.response.GetAllManagerResponseDto;
import com.sparta.calendarappserver.dto.manager.response.GetManagerResponseDto;
import com.sparta.calendarappserver.dto.manager.response.PostManagerResponseDto;
import com.sparta.calendarappserver.entity.Manager;
import com.sparta.calendarappserver.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    // 담당자 생성
    public PostManagerResponseDto creatManager(PostManagerRequestDto postManagerRequestDto) {
        // requestDto -> entity
        Manager manager = new Manager(postManagerRequestDto);

        // db 저장
        Manager saveManager = managerRepository.saveManager(manager);

        // entity -> requestDto
        PostManagerResponseDto postManagerResponseDto1 = new PostManagerResponseDto(saveManager);

        return postManagerResponseDto1;
    }

    // 담당자 단건 조회
    public GetManagerResponseDto getOneManager(Long id) {
        // entity -> requestDto
        GetManagerResponseDto getManagerResponseDto = new GetManagerResponseDto(managerRepository.getOneManager(id));
        if (getManagerResponseDto != null) {
            return getManagerResponseDto;
        } else {
            throw new IllegalArgumentException("선택한 일정은 존재하지 않습니다.");
        }
    }
    // 담당자 다건 조회
    public List<GetAllManagerResponseDto> getAllManager(Date revision, String name) {
        return managerRepository.findAllManager(revision, name);
    }

    // 담당자 수정
    public Long updateManager(Long id, UpdateManagerRequestDto updateManagerRequestDto) {
        // 담당자 ID 있는지 확인
        Manager findId = managerRepository.findById(id);
        if (findId != null) {
            managerRepository.updateManager(id, updateManagerRequestDto);
                return id;
        } else {
            throw new IllegalArgumentException("해당 담당자가 없습니다.");
        }
    }
    // 담당자 삭제
    public Long deleteManager(Long id) {
        Manager findId = managerRepository.findById(id);
        if (findId != null) {
            managerRepository.deleteManager(id);
            return id;
        } else {
            throw new IllegalArgumentException("해당 담당자가 없습니다.");
        }
    }
}
