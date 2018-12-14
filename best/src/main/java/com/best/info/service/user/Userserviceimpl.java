package com.best.info.service.user;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.info.controller.role.RoleController;
import com.best.info.dao.role.RoleDAO;
import com.best.info.dao.user.UserDAO;
import com.best.info.domain.role.Role;
import com.best.info.domain.user.User;
import com.best.info.mapper.role.RoleMapper;
import com.best.info.mapper.user.UserMapper;
import com.best.info.model.role.RoleModel;
import com.best.info.model.user.UserModel;
import com.best.info.response.Response;
import com.best.info.utils.CommonUtils;
import com.best.info.utils.DateUtility;



@Service("userservice")
public class Userserviceimpl implements UserService{
	
	

	@Autowired
	UserDAO userDAO;

	@Autowired
	UserMapper userMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(Userserviceimpl.class);
	
	
	
	@Override
	public Response addUser(UserModel userModel) throws Exception {

		try {
			User user = new User();
			BeanUtils.copyProperties(userModel, user);

			Response response = userDAO.addUser(user);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}
	
	
	
	
	
	@Override
	public List<UserModel> getUser() throws Exception {
try {
	List<User> user =userDAO.getUser();
	return userMapper.entityList(user);
	}
catch (Exception e) {
	logger.info("Exception getDepartments:", e.getMessage());
	return null;
}


}
	
	
	
	
	@Override
	public UserModel getUserById(String userId) throws Exception {

		try {
			User user = userDAO.getUser(userId);
			UserModel usermodel = new UserModel();
			if (user == null)
				return null;
			BeanUtils.copyProperties(user, usermodel);
			return usermodel;
		} catch (Exception e) {
			logger.info("Exception getUser:", e.getMessage());
			return null;
		}
}
	@Override
	public Response deleteUser(String userId) throws Exception {
		try {
			return userDAO.deleteUser(userId);
		} catch (Exception e) {
			logger.info("Exception deleteUser:", e.getMessage());

			return null;
		}
		}
	@Override
	public Response updateUser(UserModel usermodel) throws Exception {
		try {
			User user = new User();
			BeanUtils.copyProperties(usermodel, user);
		
			Response response = userDAO.updateUser(user);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;

	}

	
	


}
