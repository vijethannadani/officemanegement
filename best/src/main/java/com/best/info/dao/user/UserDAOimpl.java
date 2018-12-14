package com.best.info.dao.user;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.best.info.constant.StatusCode;
import com.best.info.response.Response;
import com.best.info.utils.CommonUtils;

import com.best.info.domain.user.User;



@Transactional
@Repository
public class UserDAOimpl implements UserDAO  {


private static final Logger logger = LoggerFactory.getLogger(UserDAOimpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Response addUser(User user) throws Exception {
		Response response = CommonUtils.getResponseObject("Add user data");
		try {
			entityManager.persist(user);
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			logger.error("Exception in addrole", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUser() throws Exception  {
		try {
			String hql = "FROM User where isActive=true";
			return (List<User>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getroles", e);
		}
		return null;
	}

	@Override
	public User getUser(String userId) throws Exception {
		try {
			String hql = "From User where userId=? and isActive=true";
			return (User) entityManager.createQuery(hql).setParameter(0, userId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in get users", e);
			return null;
		}
		
		
		
		
		
	
	}

	@Override
	public Response deleteUser(String userId) throws Exception {
	
		Response response=CommonUtils.getResponseObject("delete user data ");
		
	try {
		User user=getUser(userId);
		user.setActive(false);
		entityManager.flush();
		
		response.setStatus(StatusCode.SUCCESS.name());
		
	}
	catch (Exception e) {
		logger.info("Exception in deleteUser", e);
		response.setStatus(StatusCode.ERROR.name());
		response.setErrors(e.getMessage());	
	}
	return response;
	}

	@Override
	public Response updateUser(User user) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Department data");
		try {
			User dept = getUser(user.getUserId());

			
			
			dept.setFirstName(user.getFirstName());
			dept.setEmail(user.getEmail());
			dept.setLastName(user.getLastName());
		
			
			entityManager.flush();
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			logger.error("Exception in updateDepartment", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;	
}
}
