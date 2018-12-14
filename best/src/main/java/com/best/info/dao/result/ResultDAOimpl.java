package com.best.info.dao.result;
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
import com.best.info.domain.result.Result;
import com.best.info.domain.role.Role;
import com.best.info.model.role.RoleModel;


@Transactional
@Repository
public class ResultDAOimpl implements ResultDAO  {


private static final Logger logger = LoggerFactory.getLogger(ResultDAOimpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Response addResult(Result department) throws Exception {
		Response response = CommonUtils.getResponseObject("Add result data");
		try {
			entityManager.persist(department);
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			logger.error("Exception in addresult", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Result> getResult() throws Exception  {
		try {
			String hql = "FROM Result where isActive=true";
			return (List<Result>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getresult", e);
		}
		return null;
	}

	@Override
	public Result getResult(String resId) throws Exception {
		try {
			String hql = "From Result where resId=? and isActive=true";
			return (Result) entityManager.createQuery(hql).setParameter(0, resId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getresult", e);
			return null;
		}
		
		
		
		
		
	
	}

	@Override
	public Response deleteResult(String roleId) throws Exception {
	
		Response response=CommonUtils.getResponseObject("delete role data ");
		
	try {
		Result role=getResult(roleId);
		//role.setActive(false);
		entityManager.flush();
		
		response.setStatus(StatusCode.SUCCESS.name());
		
	}
	catch (Exception e) {
		logger.info("Exception in deleteResult", e);
		response.setStatus(StatusCode.ERROR.name());
		response.setErrors(e.getMessage());	
	}
	return response;
	}

	@Override
	public Response updateResult(Result role) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Department Result");
		try {
			Result dept = getResult(role.getResId());
			dept.setMarks(role.getMarks());
			
		
			
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
