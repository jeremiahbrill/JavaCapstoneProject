package com.techelevator.model;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.NotBlank;

/**
 * User
 */
public class User {

    private String userName; 
    private String role;
    private long id;
 
    private String password;
    private String confirmPassword;
    private boolean passwordMatching;
    
    private String firstName;
    private String LastName;
    private String avatar;
    private List<JobPosition> jobSelections;


    public boolean isPasswordMatching() {
        if (password != null) {
            return password.equals(confirmPassword);
        }
        return true;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @param username the username to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<JobPosition> getJobSelections() {
		return jobSelections;
	}

	public void setJobSelections(List<JobPosition> jobSelections) {
		this.jobSelections = jobSelections;
	}

	public void setPasswordMatching(boolean passwordMatching) {
		this.passwordMatching = passwordMatching;
	}
    
    
}