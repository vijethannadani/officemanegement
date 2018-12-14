package com.best.info.service.Admin;
import java.util.List;

import com.best.info.model.Admin.AdminModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;

public interface AdminService {
	
	

	public List<AdminModel> getAdmin()throws Exception;
	public AdminModel getAdminById(String adminId)throws Exception;

	public Response deleteAdmin(String adminId)throws Exception;

public Response addAdmin(AdminModel adminmodel)throws Exception;

	public Response updateAdmin(AdminModel adminmodel)throws Exception;

}
