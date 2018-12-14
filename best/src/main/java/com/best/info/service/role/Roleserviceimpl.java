package com.best.info.service.role;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.info.controller.role.RoleController;
import com.best.info.dao.role.RoleDAO;
import com.best.info.domain.role.Role;
import com.best.info.mapper.role.RoleMapper;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;
import com.best.info.utils.CommonUtils;
import com.best.info.utils.DateUtility;



@Service("roleservice")
public class Roleserviceimpl implements RoleService{
	
	

	@Autowired
	RoleDAO roleDAO;

	@Autowired
	RoleMapper roleMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(Roleserviceimpl.class);
	@Override
	public Response addRole(RoleModel roleModel) throws Exception {

		try {
			Role role = new Role();
			BeanUtils.copyProperties(roleModel, role);

			Response response = roleDAO.addRole(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}
	@Override
	public List<RoleModel> getRole() throws Exception {
try {
	List<Role> role =roleDAO.getRole();
	return roleMapper.entityList(role);
	}
catch (Exception e) {
	logger.info("Exception getDepartments:", e.getMessage());
	return null;
}


}
	@Override
	public RoleModel getRoleById(String roleId) throws Exception {

		try {
			Role role = roleDAO.getRole(roleId);
			RoleModel rolemodel = new RoleModel();
			if (role == null)
				return null;
			BeanUtils.copyProperties(role, rolemodel);
			return rolemodel;
		} catch (Exception e) {
			logger.info("Exception getUser:", e.getMessage());
			return null;
		}
}
	@Override
	public Response deleteRole(String roleId) throws Exception {
		try {
			return roleDAO.deleteRole(roleId);
		} catch (Exception e) {
			logger.info("Exception deleteUser:", e.getMessage());

			return null;
		}
		}
	@Override
	public Response updateRole(RoleModel rolemodel) throws Exception {
		try {
			Role role = new Role();
			BeanUtils.copyProperties(rolemodel, role);
		
			Response response = roleDAO.updateRole(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;

	}
	


}
