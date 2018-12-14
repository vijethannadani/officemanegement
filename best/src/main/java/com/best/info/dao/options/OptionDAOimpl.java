package com.best.info.dao.options;
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
import com.best.info.domain.options.Option;
import com.best.info.domain.role.Role;
import com.best.info.model.role.RoleModel;


@Transactional
@Repository
public class OptionDAOimpl implements OptionDAO  {


private static final Logger logger = LoggerFactory.getLogger(OptionDAOimpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Response addOption(Option department) throws Exception {
		Response response = CommonUtils.getResponseObject("Add option data");
		try {
			entityManager.persist(department);
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			logger.error("Exception in addoption", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Option> getOption() throws Exception  {
		try {
			String hql = "FROM Option where isActive=true";
			return (List<Option>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getroles", e);
		}
		return null;
	}

	@Override
	public Option getOption(String roleId) throws Exception {
		try {
			String hql = "From Option where optId=? and isActive=true";
			return (Option) entityManager.createQuery(hql).setParameter(0, roleId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getoption", e);
			return null;
		}
		
		
		
		
		
	
	}

	@Override
	public Response deleteOption(String roleId) throws Exception {
	
		Response response=CommonUtils.getResponseObject("delete role data ");
		
	try {
		Option role=getOption(roleId);
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
	public Response updateOption(Option role) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Department data");
		try {
			Option dept = getOption(role.getOptId());
			dept.setOpt1(role.getOpt1());
			
		
			
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
