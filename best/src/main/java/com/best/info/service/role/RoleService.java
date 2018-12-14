package com.best.info.service.role;
import java.util.List;


import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;

public interface RoleService {
	public Response addRole(RoleModel roleModel) throws Exception;

	

	public List<RoleModel> getRole()throws Exception;

	public RoleModel getRoleById(String roleId)throws Exception;



	public Response deleteRole(String roleId)throws Exception;



	public Response updateRole(RoleModel rolemodel)throws Exception;

}
