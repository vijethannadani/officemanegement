package com.best.info.dao.test;
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

import com.best.info.domain.role.Role;
import com.best.info.domain.test.Test;
import com.best.info.model.role.RoleModel;


@Transactional
@Repository
public class TestDAOimpl implements TestDAO  {


private static final Logger logger = LoggerFactory.getLogger(TestDAOimpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Response addtest(Test department) throws Exception {
		Response response = CommonUtils.getResponseObject("Add test data");
		try {
			entityManager.persist(department);
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			logger.error("Exception in addtest", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Test> getTest() throws Exception  {
		try {
			String hql = "FROM Test where isActive=true";
			return (List<Test>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in get test", e);
		}
		return null;
	}

	@Override
	public Test getTest(String roleId) throws Exception {
		try {
			String hql = "From Test where testId=? and isActive=true";
			return (Test) entityManager.createQuery(hql).setParameter(0, roleId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in gettest", e);
			return null;
		}
		
		
		
		
		
	
	}

	@Override
	public Response deletTest(String roleId) throws Exception {
	
		Response response=CommonUtils.getResponseObject("delete test data ");
		
	try {
		Test role=getTest(roleId);
//		role.setActive(false);
		entityManager.flush();
		
		response.setStatus(StatusCode.SUCCESS.name());
		
	}
	catch (Exception e) {
		logger.info("Exception in deletetest", e);
		response.setStatus(StatusCode.ERROR.name());
		response.setErrors(e.getMessage());	
	}
	return response;
	}

	@Override
	public Response updateTest(Test role) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Department data");
		try {
			Test dept = getTest(role.getTestId());
			dept.setTestName(role.getTestName());
			
		
			
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
