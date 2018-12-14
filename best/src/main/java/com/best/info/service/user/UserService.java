package com.best.info.service.user;
import java.util.List;


import com.best.info.model.role.RoleModel;
import com.best.info.model.user.UserModel;
import com.best.info.response.Response;

public interface UserService {
	


	public List<UserModel> getUser()throws Exception;

	public UserModel getUserById(String userId)throws Exception;

	public Response deleteUser(String userId)throws Exception;

	public Response updateUser(UserModel userModel)throws Exception;

	public Response addUser(UserModel userModel)throws Exception;

}
