package com.best.info.dao.Admin;


import com.best.info.response.Response;
import com.best.info.domain.Admin.Admin;
import com.best.info.domain.role.Role;

import java.util.List;

public interface AdminDAO {

	

	

	public Response addAdmin(Admin admin) throws Exception;



	public List<Admin> getAdmin() throws Exception;



	public Admin getAdmin(String adminId) throws Exception;



	public Response deleteAdmin(String adminId) throws Exception;



	public Response updateAdmin(Admin admin) throws Exception;
		



}
