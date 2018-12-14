package com.best.info.dao.Admin;
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
import com.best.info.domain.Admin.Admin;
import com.best.info.domain.role.Role;
import com.best.info.model.role.RoleModel;


@Transactional
@Repository
public class AdminDAOimpl implements AdminDAO  {


private static final Logger logger = LoggerFactory.getLogger(AdminDAOimpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Response addAdmin(Admin department) throws Exception {
		Response response = CommonUtils.getResponseObject("Add admins data");
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
	public List<Admin> getAdmin() throws Exception  {
		try {
			String hql = "FROM Admin  where isActive=true";
			return (List<Admin>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getroles", e);
		}
		return null;
	}

	@Override
	public Admin getAdmin(String adminId) throws Exception {
		try {
			String hql = "From admin where roleId=? and isActive=true";
			return (Admin) entityManager.createQuery(hql).setParameter(0, adminId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getDepartment", e);
			return null;
		}
		
		
		
		
		
	
	}

	@Override
	public Response deleteAdmin(String adminId) throws Exception {
	
		Response response=CommonUtils.getResponseObject("delete role data ");
		
	try {
		Admin admins=getAdmin(adminId);
		//admins.setActive(false);
		entityManager.flush();
		
		response.setStatus(StatusCode.SUCCESS.name());
		
	}
	catch (Exception e) {
		logger.info("Exception in deleteAdmin", e);
		response.setStatus(StatusCode.ERROR.name());
		response.setErrors(e.getMessage());	
	}
	return response;
	}

	@Override
	public Response updateAdmin(Admin admin) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Department data");
		try {
			Admin dept = getAdmin(admin.getAdminId());
			dept.setFirstName(admin.getFirstName());
			//(admin.getAdminId());
			
		
			
			entityManager.flush();
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			logger.error("Exception in updateadmins", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;	
}
}
