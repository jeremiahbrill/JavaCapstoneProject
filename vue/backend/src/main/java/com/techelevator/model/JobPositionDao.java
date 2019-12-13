package com.techelevator.model;

import java.util.List;

public interface JobPositionDao {
	
	public List<JobPosition> getAllJobPositions();
	public List<JobPosition> getAllJobPositionsById();

}
