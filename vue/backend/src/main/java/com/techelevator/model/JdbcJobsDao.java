package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JdbcJobsDao implements JobsDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcJobsDao(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	
	private Jobs mapRowToJobs(SqlRowSet results) {
		
		Jobs jobs = new Jobs();
		jobs.setId(results.getInt("id"));
		jobs.setName(results.getString("name"));
		jobs.setJobDescription(results.getString("jobDescription"));
		jobs.setJobCity(results.getString("jobCity"));
		jobs.setJobState(results.getString("jobState"));
		jobs.setJobUrl(results.getString("jobUrl"));
		jobs.setJobPositionId(results.getString("positionId"));
		
		return jobs;
	}

	@Override
	public List<Jobs> getAllJobs() {
		
		List<Jobs> allJobs = new ArrayList<>();
		String sqlSelectAllJobs = "SELECT id, name, jobDescription, jobCity, jobState, jobUrl, positionId FROM jobs";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllJobs);
		while(results.next()) {
			allJobs.add(mapRowToJobs(results));
		}
		
		return allJobs;
	}


	@Override
	public List<Jobs> getJobsById() {
		
		List<Jobs> allJobsById = new ArrayList<>();
		String sqlSelectAllJobsById = "SELECT id, name, jobDescription, jobCity, jobState, jobUrl, positionId FROM jobs WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllJobsById);
		while(results.next()) {
			allJobsById.add(mapRowToJobs(results));
		}
		
		return allJobsById;
	}
	
	

}
