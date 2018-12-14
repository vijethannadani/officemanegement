package com.best.info.dao.Question;
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
import com.best.info.domain.Question.Question;
import com.best.info.domain.role.Role;
import com.best.info.model.role.RoleModel;


@Transactional
@Repository
public class QuestionDAOimpl implements QuestionDAO  {


private static final Logger logger = LoggerFactory.getLogger(QuestionDAOimpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Response addQuestion(Question department) throws Exception {
		Response response = CommonUtils.getResponseObject("Add question data");
		try {
			entityManager.persist(department);
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			logger.error("Exception in addquestion", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestion() throws Exception  {
		try {
			String hql = "FROM Question where isActive=true";
			return (List<Question>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getQuestion", e);
		}
		return null;
	}

	@Override
	public Question getQuestion(String roleId) throws Exception {
		try {
			String hql = "From Question where qusId=? and isActive=true";
			return (Question) entityManager.createQuery(hql).setParameter(0, roleId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getDepartment", e);
			return null;
		}
		
		
		
		
		
	
	}

	@Override
	public Response deleteQuestion(String roleId) throws Exception {
	
		Response response=CommonUtils.getResponseObject("delete role data ");
		
	try {
		Question role=getQuestion(roleId);
		role.setActive(false);
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
	public Response updateQuestion(Question role) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Department data");
		try {
			Question dept = getQuestion(role.getQusId());
			dept.setSubId(role.getSubId());
			dept.setCreateDate(role.getCreateDate());
			dept.setQusTxt(role.getQusTxt());
		
			
		
			
			entityManager.flush();
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			logger.error("Exception in updatequestion", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;	
}
}
