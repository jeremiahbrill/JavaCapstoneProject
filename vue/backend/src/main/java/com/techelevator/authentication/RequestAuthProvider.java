package com.techelevator.authentication;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.techelevator.model.JobPosition;
import com.techelevator.model.User;
import com.techelevator.model.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RequestAuthProvider
 */
@Component
public class RequestAuthProvider implements AuthProvider {

    private HttpServletRequest request;
    private UserDao dao;
    public final static String USER_KEY = "appCurrentUser";

    @Autowired
    public RequestAuthProvider(HttpServletRequest request, UserDao dao) {
        this.request = request;
        this.dao = dao;
    }

    @Override
    public boolean isLoggedIn() {
        return (request.getAttribute(USER_KEY) != null);
    }

    @Override
    public User getCurrentUser() {
        return (User) request.getAttribute(USER_KEY);
    }

    @Override
    public boolean signIn(String username, String password) {
        User authenticatedUser = dao.getValidUserWithPassword(username, password);
        if (authenticatedUser != null) {
            request.setAttribute(USER_KEY, authenticatedUser);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void logOff() {
        request.removeAttribute(USER_KEY);
    }

    @Override
    public boolean changePassword(String existingPassword, String newPassword) {
        User userFromSession = (User) request.getAttribute(USER_KEY);
        if (userFromSession == null) {
            return false;
        }
        User userFromDb = dao.getValidUserWithPassword(userFromSession.getUserName(), existingPassword);
        if (userFromDb != null && userFromDb.getId() == userFromDb.getId()) {
            dao.changePassword(userFromSession, newPassword);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void registerOld(String username, String password, String role) {
        dao.saveUserOld(username, password, role);
    }
    
    @Override
    public void register(String username, String password, String role, String firstName, String lastName, String avatar, List<JobPosition> jobSelection) {
    	
        dao.saveUser(username, password, role, firstName, lastName, avatar);
    
        dao.saveUserIdAndJobPositionId(username, jobSelection);
    }
    
    @Override
    public void saveJobSelections(String username, List<JobPosition> jobSelection) {
        dao.saveUserIdAndJobPositionId(username, jobSelection);
    }

    @Override
    public boolean userHasRole(String[] roles) {
        User currentUser = getCurrentUser();
        if (currentUser != null && roles != null) {
            return Arrays.asList(roles).contains(currentUser.getRole());
        } else {
            return false;
        }
    }
}