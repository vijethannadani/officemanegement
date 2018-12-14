package com.best.info.dao.role;
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
import com.best.info.model.role.RoleModel;


@Transactional
@Repository
public class RoleDAOimpl implements RoleDAO  {


private static final Logger logger = LoggerFactory.getLogger(RoleDAOimpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Response addRole(Role department) throws Exception {
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
	public List<Role> getRole() throws Exception  {
		try {
			String hql = "FROM Role  where isActive=true";
			return (List<Role>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getroles", e);
		}
		return null;
	}

	@Override
	public Role getRole(String roleId) throws Exception {
		try {
			String hql = "From Role where roleId=? and isActive=true";
			return (Role) entityManager.createQuery(hql).setParameter(0, roleId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getDepartment", e);
			return null;
		}
		
		
		
		
		
	
	}

	@Override
	public Response deleteRole(String roleId) throws Exception {
	
		Response response=CommonUtils.getResponseObject("delete role data ");
		
	try {
		Role role=getRole(roleId);
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
	public Response updateRole(Role role) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Role data");
		try {
			Role dept = getRole(role.getRoleId());
			dept.setRoleName(role.getRoleName());
			
		
			
			entityManager.flush();
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			logger.error("Exception in updateRole", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;	
}
}
