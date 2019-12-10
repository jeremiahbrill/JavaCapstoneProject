package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Category;
import com.techelevator.model.CategoryDao;
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
		
	

}
