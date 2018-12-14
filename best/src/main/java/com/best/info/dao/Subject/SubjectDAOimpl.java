package com.best.info.dao.Subject;
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
import com.best.info.domain.Subject.Subject;
import com.best.info.domain.role.Role;
import com.best.info.model.role.RoleModel;


@Transactional
@Repository
public class SubjectDAOimpl implements SubjectDAO  {


private static final Logger logger = LoggerFactory.getLogger(SubjectDAOimpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Response addSubject(Subject department) throws Exception {
		Response response = CommonUtils.getResponseObject("Add Subject data");
		try {
			entityManager.persist(department);
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			logger.error("Exception in addSubject", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> getSubject() throws Exception  {
		try {
			String hql = "FROM Subject where isActive=true";
			return (List<Subject>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getsubject", e);
		}
		return null;
	}

	@Override
	public Subject getSubject(String roleId) throws Exception {
		try {
			String hql = "From Subject where roleId=? and isActive=true";
			return (Subject) entityManager.createQuery(hql).setParameter(0, roleId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getsubject", e);
			return null;
		}
		
		
		
		
		
	
	}

	@Override
	public Response deleteSubject(String roleId) throws Exception {
	
		Response response=CommonUtils.getResponseObject("delete Subject data ");
		
	try {
		Subject role=getSubject(roleId);
		role.setActive(false);
		entityManager.flush();
		
		response.setStatus(StatusCode.SUCCESS.name());
		
	}
	catch (Exception e) {
		logger.info("Exception in deleteSubject", e);
		response.setStatus(StatusCode.ERROR.name());
		response.setErrors(e.getMessage());	
	}
	return response;
	}

	@Override
	public Response updateSubject(Subject role) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Department data");
		try {
			Subject dept = getSubject(role.getSubId());
			dept.setSubName(role.getSubName());
			
		
			
			entityManager.flush();
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			logger.error("Exception in updateSubject", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;	
}
}
