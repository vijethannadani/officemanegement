package com.best.info.service.Admin;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.info.controller.role.RoleController;
import com.best.info.dao.Admin.AdminDAO;
import com.best.info.dao.role.RoleDAO;
import com.best.info.domain.Admin.Admin;
import com.best.info.domain.role.Role;
import com.best.info.mapper.Admin.AdminMapper;
import com.best.info.mapper.role.RoleMapper;
import com.best.info.model.Admin.AdminModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;
import com.best.info.utils.CommonUtils;
import com.best.info.utils.DateUtility;



@Service("adminservice")
public class Adminserviceimpl implements AdminService{
	
	

	@Autowired
	AdminDAO adminDAO;

	@Autowired
	AdminMapper adminMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(Adminserviceimpl.class);
	@Override
	public Response addAdmin(AdminModel adminmodel) throws Exception {

		try {
			Admin admin = new Admin();
			BeanUtils.copyProperties(adminmodel, admin);
			admin.setAdminId(CommonUtils.generateRandomId());

			Response response = adminDAO.addAdmin(admin);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}
	@Override
	public List<AdminModel> getAdmin() throws Exception {
try {
	List<Admin> admin =adminDAO.getAdmin();
	return adminMapper.entityList(admin);
	}
catch (Exception e) {
	logger.info("Exception getDepartments:", e.getMessage());
	return null;
}


}
	@Override
	public AdminModel getAdminById(String adminId) throws Exception {

		try {
			Admin admin = adminDAO.getAdmin(adminId);
			AdminModel adminmodel = new AdminModel();
			if (admin == null)
				return null;
			BeanUtils.copyProperties(admin, adminmodel);
			return adminmodel;
		} catch (Exception e) {
			logger.info("Exception getUser:", e.getMessage());
			return null;
		}
}
	@Override
	public Response deleteAdmin(String adminId) throws Exception {
		try {
			return adminDAO.deleteAdmin(adminId);
		} catch (Exception e) {
			logger.info("Exception deleteUser:", e.getMessage());

			return null;
		}
		}
	@Override
	public Response updateAdmin(AdminModel adminmodel) throws Exception {
		try {
			Admin admin = new Admin();
			BeanUtils.copyProperties(adminmodel, admin);
		
			Response response = adminDAO.updateAdmin(admin);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;

	}
	


}
