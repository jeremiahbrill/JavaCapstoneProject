package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSubWorkflowDao implements SubWorkflowDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSubWorkflowDao(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<SubWorkflow> getAllSubWorkflows(int workflowId) {
		
		List<SubWorkflow> allSubWorkFlowsByWorkflowID = new ArrayList<>();
		String sqlSelectAllSubWorkFlowsByWorkflowID = "select * from subworkflow where workflow_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSubWorkFlowsByWorkflowID, workflowId);
		while(results.next()) {
			allSubWorkFlowsByWorkflowID.add(mapRowToSubWorkflow(results));
		}
		return allSubWorkFlowsByWorkflowID;
	}
	
	private SubWorkflow mapRowToSubWorkflow(SqlRowSet row) {
		
		SubWorkflow subWorkflow = new SubWorkflow();
		subWorkflow.setSubWorkflowId(row.getInt("subworkflow_id"));
		subWorkflow.setSubWorkflowName(row.getString("name"));
		subWorkflow.setTextAnswer(row.getString("text_answer"));
		subWorkflow.setVideoAnswer(row.getString("video_answer"));
		subWorkflow.setImageAnswer(row.getString("image_answer"));	
		subWorkflow.setLinkAnswer(row.getString("link_answer"));
		return subWorkflow;
	}

}
