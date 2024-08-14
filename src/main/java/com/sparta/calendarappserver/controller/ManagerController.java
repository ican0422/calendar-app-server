package com.sparta.calendarappserver.controller;

import com.sparta.calendarappserver.dto.manager.request.PostManagerRequestDto;
import com.sparta.calendarappserver.dto.manager.request.UpdateManagerRequestDto;
import com.sparta.calendarappserver.dto.manager.response.GetAllManagerResponseDto;
import com.sparta.calendarappserver.dto.manager.response.GetManagerResponseDto;
import com.sparta.calendarappserver.dto.manager.response.PostManagerResponseDto;
import com.sparta.calendarappserver.dto.schedule.request.UpdateScheduleRequestDto;
import com.sparta.calendarappserver.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }


    // 담당자 등록
    @PostMapping("/managers")
    public PostManagerResponseDto createManager(@RequestBody PostManagerRequestDto postManagerRequestDto) {
        return managerService.creatManager(postManagerRequestDto);
    }

    // 담당자 단건 조회
    @GetMapping("/managers/{id}")
    public GetManagerResponseDto getOneManager(@PathVariable Long id) {
        return managerService.getOneManager(id);
    }

    // 담당자 다건 조회
    @GetMapping("/managers/param")
    public List<GetAllManagerResponseDto> getAllManager(
            @RequestParam(required = false) Date revision,
            @RequestParam(required = false) String name
    ) {
        return managerService.getAllManager(revision, name);
    }

    // 담당자 수정
    @PutMapping("/managers/{id}")
    public Long updateManager(@PathVariable Long id, @RequestBody UpdateManagerRequestDto updateManagerRequestDto) {
        return managerService.updateManager(id, updateManagerRequestDto);
    }

    // 담당자 삭제
    @DeleteMapping("/managers/{id}")
    public Long deleteManager(@PathVariable Long id) {
        return managerService.deleteManager(id);
    }
}
