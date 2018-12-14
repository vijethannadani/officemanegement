 package com.best.info.dao.user;


import com.best.info.response.Response;
import com.best.info.domain.role.Role;
import com.best.info.domain.user.User;

import java.util.List;

public interface UserDAO {

	public Response addUser(User user) throws Exception;

	public List<User> getUser()throws Exception;

	public  User getUser(String userId)throws Exception ;

	public Response deleteUser(String userId)throws Exception;

	public Response updateUser(User user)throws Exception;
		



}
