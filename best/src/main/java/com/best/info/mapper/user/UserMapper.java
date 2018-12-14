package com.best.info.mapper.user;

import org.springframework.stereotype.Component;

import com.best.info.domain.user.User;
import com.best.info.mapper.AbstractModelMapper;
import com.best.info.model.user.UserModel;

@Component
public class UserMapper extends AbstractModelMapper<UserModel,User>{

	@Override
	public Class<UserModel> entityType() {
		// TODO Auto-generated method stub
		return UserModel.class;
	}

	@Override
	public Class<User> modelType() {
		// TODO Auto-generated method stub
		return User.class;
	}

}
