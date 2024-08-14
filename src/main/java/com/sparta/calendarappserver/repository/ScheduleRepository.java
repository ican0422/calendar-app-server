package com.sparta.calendarappserver.repository;

import com.sparta.calendarappserver.dto.schedule.request.UpdateScheduleRequestDto;
import com.sparta.calendarappserver.dto.schedule.response.GetAllScheduleResponseDto;
import com.sparta.calendarappserver.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
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
    public Schedule getOneSchedule(Long id) {
        String sql = "SELECT * FROM Schedule WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                Long scheduleId = rs.getLong("id");
                String name = rs.getString("Name");
                String content = rs.getString("Content");
                Date registration_Date = rs.getDate("registration_Date");
                Date revision_Date = rs.getDate("revision_Date");
                return new Schedule(scheduleId, name, content, registration_Date, revision_Date);
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
    public void update(Long id, UpdateScheduleRequestDto updateScheduleRequestDto) {
        String sql ="UPDATE schedule SET Name = ?, Content = ? WHERE Id = ?";
        jdbcTemplate.update(sql, updateScheduleRequestDto.getName(), updateScheduleRequestDto.getContent(), id);
    }

    // 사용자 일정 삭제
    public void delete(Long id) {
        String sql = "DELETE FROM schedule WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // 비밀번호 확인
    public Schedule findByPwd(Long id) {
        // DB 조회
        String sql = "SELECT Password FROM schedule WHERE Id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if(resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setPassword(resultSet.getString("Password"));
                return schedule;
            } else {
                return null;
            }
        }, id);
    }

    // 일정 ID 확인
    public Schedule findById(Long id) {
        // DB 조회
        String sql = "SELECT Id FROM schedule WHERE Id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if(resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getLong("Id"));
                return schedule;
            } else {
                return null;
            }
        }, id);
    }
}
