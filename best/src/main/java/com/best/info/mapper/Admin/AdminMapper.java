package com.best.info.mapper.Admin;

import org.springframework.stereotype.Component;

import com.best.info.domain.Admin.Admin;
import com.best.info.domain.role.Role;
import com.best.info.mapper.AbstractModelMapper;
import com.best.info.model.Admin.AdminModel;
import com.best.info.model.role.RoleModel;
@Component
public class AdminMapper extends AbstractModelMapper<AdminModel,Admin>{

	@Override
	public Class<AdminModel> entityType() {
		
		return AdminModel.class;
	}

	@Override
	public Class<Admin> modelType() {
	
		return Admin.class;
	}

}
