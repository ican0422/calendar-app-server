package com.sparta.calendarappserver.repository;

import com.sparta.calendarappserver.dto.manager.request.UpdateManagerRequestDto;
import com.sparta.calendarappserver.dto.manager.response.GetAllManagerResponseDto;
import com.sparta.calendarappserver.entity.Manager;
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
public class ManagerRepository {
    private final JdbcTemplate jdbcTemplate;

    public ManagerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 담당자 등록
    public Manager saveManager(Manager manager) {

        KeyHolder keyHolder = new GeneratedKeyHolder(); // 기본 키를 반환받기 위한 객체

        String sql = "INSERT INTO manager (name, email) VALUES(?, ?)";
        jdbcTemplate.update( con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, manager.getName());
            preparedStatement.setString(2, manager.getEmail());
            return preparedStatement;
        }, keyHolder);
        Long Id = keyHolder.getKey().longValue();
        manager.setId(Id);

        return manager;
    }

    // 담당자 단건 조회
    public Manager getOneManager(Long id) {
        String sql = """
                    SELECT * FROM Manager WHERE id = ?
                    """;

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Manager>() {
            @Override
            public Manager mapRow(ResultSet rs, int rowNum) throws SQLException {
                Long ManagerId = rs.getLong("id");
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                Date registration_Date = rs.getDate("registration_Date");
                Date revision_Date = rs.getDate("revision_Date");
                return new Manager(ManagerId, name, email, registration_Date, revision_Date);
            }
        });
    }

    // 담당자 다건 조회
    public List<GetAllManagerResponseDto> findAllManager(Date revision, String name) {
        StringBuilder sql = new StringBuilder
                (
                        """
                        SELECT Id, Name, Email, Registration_Date, Revision_Date
                        FROM Manager
                        WHERE 1=1
                        """
                );
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

        return jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<GetAllManagerResponseDto>() {
            @Override
            public GetAllManagerResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                // SQL 의 결과로 받아온 schedule 데이터들을 GetAllScheduleResponseDto 타입으로 변환해줄 메서드
                Long id = rs.getLong("id");
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                Date registration_Date = rs.getDate("registration_Date");
                Date revision_Date = rs.getDate("revision_Date");
                return new GetAllManagerResponseDto(id, name, email, registration_Date, revision_Date);
            }
        });
    }

    // 담당자 수정
    public void updateManager(Long id, UpdateManagerRequestDto updateManagerRequestDto) {
        String slq = "UPDATE Manager SET Name = ?, Email = ? WHERE Id = ?";
        jdbcTemplate.update(slq, updateManagerRequestDto.getName(), updateManagerRequestDto.getEmail(), id);
    }

    // 담당자 삭제
    public void deleteManager(Long id) {
        String slq = "DELETE FROM Manager WHERE id = ?";
        jdbcTemplate.update(slq, id);
    }


    // 담당자 ID 조회
    public Manager findById(Long id) {
        // DB 조회
        String sql = "SELECT Id FROM Manager WHERE Id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if(resultSet.next()) {
                Manager manager = new Manager();
                manager.setId(resultSet.getLong("Id"));
                return manager;
            } else {
                return null;
            }
        }, id);
    }
}
