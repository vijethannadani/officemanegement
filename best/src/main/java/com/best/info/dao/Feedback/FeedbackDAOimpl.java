package com.best.info.dao.Feedback;
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
import com.best.info.domain.Feedback.Feedback;
import com.best.info.domain.role.Role;
import com.best.info.model.role.RoleModel;


@Transactional
@Repository
public class FeedbackDAOimpl implements FeedbackDAO  {


private static final Logger logger = LoggerFactory.getLogger(FeedbackDAOimpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Response addFeedback(Feedback department) throws Exception {
		Response response = CommonUtils.getResponseObject("Add role data");
		try {
			entityManager.persist(department);
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
	public List<Feedback> getFeedback() throws Exception  {
		try {
			String hql = "FROM Feedback where isActive=true";
			return (List<Feedback>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getfeedback", e);
		}
		return null;
	}

	@Override
	public Feedback getFeedback(String roleId) throws Exception {
		try {
			String hql = "From Feedback where feeId=? and isActive=true";
			return (Feedback) entityManager.createQuery(hql).setParameter(0, roleId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getFeedback", e);
			return null;
		}
		
		
		
		
		
	
	}

	@Override
	public Response deleteFeedback(String roleId) throws Exception {
	
		Response response=CommonUtils.getResponseObject("delete Feedback data ");
		
	try {
		Feedback role=getFeedback(roleId);
		//role.setActive(false);
		entityManager.flush();
		
		response.setStatus(StatusCode.SUCCESS.name());
		
	}
	catch (Exception e) {
		logger.info("Exception in deleteRole", e);
		response.setStatus(StatusCode.ERROR.name());
		response.setErrors(e.getMessage());	
	}
	return response;
	}

	@Override
	public Response updateFeedback(Feedback role) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Department data");
		try {
			Feedback dept = getFeedback(role.getFeeId());
			dept.setFeedback(role.getFeedback());
			
		
			
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
