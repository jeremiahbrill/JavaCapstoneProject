package com.techelevator.model;

import java.util.List;

public interface JobsDao {
	
	public List<Jobs> getAllJobs();
	public List<Jobs> getJobsById();

}
