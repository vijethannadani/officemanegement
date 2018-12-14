package com.best.info.mapper.role;

import org.springframework.stereotype.Component;

import com.best.info.domain.role.Role;
import com.best.info.mapper.AbstractModelMapper;
import com.best.info.model.role.RoleModel;
@Component
public class RoleMapper extends AbstractModelMapper<RoleModel,Role>{

	@Override
	public Class<RoleModel> entityType() {
		// TODO Auto-generated method stub
		return RoleModel.class;
	}

	@Override
	public Class<Role> modelType() {
		// TODO Auto-generated method stub
		return Role.class;
	}

}
