package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWorkflowDao implements WorkflowDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcWorkflowDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Workflow> getAllWorkFlows(int categoryID) {
		List<Workflow> allWorkflowsByCategoryId =  new ArrayList<>();
		String sqlSelectAllWorkflowsByCategoryId = "Select * from workflow where category_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllWorkflowsByCategoryId, categoryID);
		while(results.next()) {
			allWorkflowsByCategoryId.add(mapRowToWorkflow(results));
		}
		return allWorkflowsByCategoryId;
	}
	
	private Workflow mapRowToWorkflow(SqlRowSet row) {
		Workflow workflow = new Workflow();
		workflow.setId(row.getInt("workflow_id"));
		workflow.setName(row.getString("name"));
		workflow.setCategoryId(row.getInt("category_id"));
		return workflow;
	}

}
