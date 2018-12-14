package com.best.info.dao.role;


import com.best.info.response.Response;
import com.best.info.domain.role.Role;

import java.util.List;

public interface RoleDAO {

	public Response addRole(Role department) throws Exception;

	public List<Role> getRole()throws Exception;

	public  Role getRole(String roleId)throws Exception ;

	public Response deleteRole(String roleId)throws Exception;

	public Response updateRole(Role role)throws Exception;
		



}
