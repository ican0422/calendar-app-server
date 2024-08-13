package com.sparta.calendarappserver.repository;

import com.sparta.calendarappserver.dto.GetAllScheduleResponseDto;
import com.sparta.calendarappserver.dto.GetScheduleRequestDto;
import com.sparta.calendarappserver.dto.GetScheduleResponseDto;
import com.sparta.calendarappserver.dto.PostScheduleResponseDto;
import com.sparta.calendarappserver.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 사용자 일정 등록 저장
    public Schedule saveSchedule(Schedule schedule) {

        KeyHolder keyHolder = new GeneratedKeyHolder(); // 기본 키를 반환받기 위한 객체

        String sql = "INSERT INTO schedule (name, content, password) VALUES(?, ?, ?)";
        jdbcTemplate.update( con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, schedule.getName());
            preparedStatement.setString(2, schedule.getContent());
            preparedStatement.setString(3, schedule.getPassword());
            return preparedStatement;
        }, keyHolder);
        Long Id = keyHolder.getKey().longValue();
        schedule.setId(Id);

        return schedule;
    }

    // 사용자 일정 한개 조회
    public GetScheduleResponseDto getOneSchedule(Long id) {
        String sql = "SELECT * FROM Schedule WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<GetScheduleResponseDto>() {
            @Override
            public GetScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                Long scheduleId = rs.getLong("id");
                String name = rs.getString("Name");
                String content = rs.getString("Content");
                Date registration_Date = rs.getDate("registration_Date");
                Date revision_Date = rs.getDate("revision_Date");
                return new GetScheduleResponseDto(scheduleId, name, content, registration_Date, revision_Date);
            }
        });
    }

    // 사용자 일정 조회
    public List<GetAllScheduleResponseDto> findAllSchedule(Date revision, String name) {
        StringBuilder sql = new StringBuilder("SELECT * FROM schedule WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (revision != null){
            sql.append(" AND Revision_Date = ?");
            params.add(revision);
        }
        if (name != null) {
            sql.append(" AND Name = ?");
            params.add(name);
        }

        sql.append(" ORDER BY Revision_Date DESC");

        return jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<GetAllScheduleResponseDto>() {
            @Override
            public GetAllScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                // SQL 의 결과로 받아온 schedule 데이터들을 GetAllScheduleResponseDto 타입으로 변환해줄 메서드
                Long id = rs.getLong("id");
                String name = rs.getString("Name");
                String content = rs.getString("Content");
                Date registration_Date = rs.getDate("registration_Date");
                Date revision_Date = rs.getDate("revision_Date");
                return new GetAllScheduleResponseDto(id, name, content, registration_Date, revision_Date);
            }
        });
    }
    // 사용자 일정 수정 ( 내용, 담당자 변경)

    // 사용자 일정 삭제
}
