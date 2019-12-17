package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcJobPositionDao implements JobPositionDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcJobPositionDao(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	

	@Override
	public List<JobPosition> getAllJobPositions() {
		
		List<JobPosition> allJobPosition = new ArrayList<>();
		String sqlSelectAllJobPosition = "SELECT id, name FROM jobPosition";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllJobPosition);
		while(results.next()) {
			allJobPosition.add(mapRowToJobPosition(results));
		}
		
		return allJobPosition;
	}

	@Override
	public List<JobPosition> getAllJobPositionsById(int jobPositionId) {
		
		List<JobPosition> allJobPositionById = new ArrayList<>();
		String sqlSelectAllJobPositionById = "SELECT id, name FROM jobPosition WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllJobPositionById, jobPositionId);
		while(results.next()) {
			allJobPositionById.add(mapRowToJobPosition(results));
		}
		
		return allJobPositionById;
	}
	
	@Override
	public List<JobPosition> getAllJobSelectionsForUser(String userName) {
		
		List<JobPosition> allJobPositionByUserName = new ArrayList<>();
		String sqlSelectAllJobPositionsByUserName = "select  jobposition.id , jobposition.name\n" + 
				" from users join users_jobposition on users.id = users_jobposition.user_id\n" + 
				" join jobposition on jobposition.id = users_jobposition.jobposition_id\n" + 
				" where username = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllJobPositionsByUserName, userName);
		while(results.next()) {
			allJobPositionByUserName.add(mapRowToJobPosition(results));
		}
		
		return allJobPositionByUserName;
	}
	
	
	private JobPosition mapRowToJobPosition(SqlRowSet results) {
		
		JobPosition jobPosition = new JobPosition();
		jobPosition.setId(results.getInt("id"));
		jobPosition.setName(results.getString("name"));
		
		return jobPosition;
	}
	

}
