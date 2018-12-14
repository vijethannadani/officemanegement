package com.best.info.dao.Pay;
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
import com.best.info.domain.Pay.Pay;
import com.best.info.domain.role.Role;
import com.best.info.model.role.RoleModel;


@Transactional
@Repository
public class PayDAOimpl implements PayDAO  {


private static final Logger logger = LoggerFactory.getLogger(PayDAOimpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Response addPay(Pay department)  {
		Response response = CommonUtils.getResponseObject("Add pay data");
		try {
			entityManager.persist(department);
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			logger.error("Exception in addpay", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pay> getPay() throws Exception  {
		try {
			String hql = "FROM Pay where isActive=true";
			return (List<Pay>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getroles", e);
		}
		return null;
	}

	@Override
	public Pay getPay(String roleId) throws Exception {
		try {
			String hql = "From Pay where payId=? and isActive=true";
			return (Pay) entityManager.createQuery(hql).setParameter(0, roleId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getpays", e);
			return null;
		}
		
		
		
		
		
	
	}

	@Override
	public Response deletePay(String roleId) throws Exception {
	
		Response response=CommonUtils.getResponseObject("delete role data ");
		
	try {
		Pay role=getPay(roleId);
		//role.setActive(false);
		entityManager.flush();
		
		response.setStatus(StatusCode.SUCCESS.name());
		
	}
	catch (Exception e) {
		logger.info("Exception in deletePay", e);
		response.setStatus(StatusCode.ERROR.name());
		response.setErrors(e.getMessage());	
	}
	return response;
	}

	@Override
	public Response updatePay(Pay role) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Department data");
		try {
			Pay dept = getPay(role.getPayId());
			dept.setCost(role.getCost());
			
		
			
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
