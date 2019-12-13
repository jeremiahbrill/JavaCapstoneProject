package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcAnswerDao implements AnswerDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcAnswerDao(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Answer> getAllAnswers(int subworkflowId) {
		
		List<Answer> allAnswersBySubWorkflowID = new ArrayList<>();
		String sqlSelectAnswersBySubWorkflowID = "select * from answer where subworkflow_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAnswersBySubWorkflowID, subworkflowId);
		while(results.next()) {
			allAnswersBySubWorkflowID.add(mapRowToSubWorkflow(results));
		}

		return allAnswersBySubWorkflowID;
	}
	
	private Answer mapRowToSubWorkflow(SqlRowSet row) {
		
		Answer answer = new Answer();
		answer.setId(row.getInt("answer_id"));
		answer.setTextAnswer(row.getString("text_answer"));
		answer.setVideoAnswer(row.getString("video_answer"));
		answer.setImageAnswer(row.getString("image_answer"));	
		answer.setLinkAnswer(row.getString("link_answer"));
		answer.setSubworkflowId(row.getInt("subworkflow_id"));
		answer.setPresentationText(row.getString("presentation_text"));
		return answer;
	}



}
