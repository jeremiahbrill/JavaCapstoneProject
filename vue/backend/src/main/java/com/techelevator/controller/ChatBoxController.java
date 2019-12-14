package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Answer;
import com.techelevator.model.AnswerDao;
import com.techelevator.model.Category;
import com.techelevator.model.CategoryDao;
import com.techelevator.model.JobPosition;
import com.techelevator.model.JobPositionDao;
import com.techelevator.model.Jobs;
import com.techelevator.model.JobsDao;
import com.techelevator.model.SubWorkflow;
import com.techelevator.model.SubWorkflowDao;
import com.techelevator.model.Workflow;
import com.techelevator.model.WorkflowDao;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class ChatBoxController {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired	
	private WorkflowDao workflowDao;
	
	@Autowired
	private SubWorkflowDao subWorkflowDao;
	
	@Autowired
	private JobsDao jobsDao;
	
	@Autowired
	private JobPositionDao jobPosition;
	
	@Autowired
	private AnswerDao answerDao;
	
	@GetMapping("/category")
	public List<Category> getCategories() {
		return categoryDao.getAllCategories();
		
	}
	
	@GetMapping("/workflow/{id}")
	public List<Workflow> getWorkflowsById(@PathVariable int id) {
		return workflowDao.getAllWorkFlows(id);
		
	}
	
	@GetMapping("/subworkflow/{id}")
	public List<SubWorkflow> getSubWorkflowsById(@PathVariable int id) {
		return subWorkflowDao.getAllSubWorkflows(id);
		
	}
	
	@GetMapping("/jobSearch")
	public List<Jobs> getAllJobs(){
		return jobsDao.getAllJobs();
		
	}
	
	@GetMapping("/jobSearch/{id}")	
	public List<Jobs> getAllJobsById(@PathVariable int id){
		return jobsDao.getJobsById(id);
	}
	
	@GetMapping("/jobPositionSearch")
	public List<JobPosition> getAllJobPositions(){
		return jobPosition.getAllJobPositions();
	}
	
	@GetMapping("/jobPositionSearch/{id}")
	public List<JobPosition> getAllJobPositionsById(@PathVariable int id){
		return jobPosition.getAllJobPositionsById(id );
		
	}
	
	@GetMapping("/answer/{id}")
	public List<Answer> getAnswersById(@PathVariable int id) {
		return answerDao.getAllAnswers(id);
		
	}

}
