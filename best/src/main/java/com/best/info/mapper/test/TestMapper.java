package com.best.info.mapper.test;

import org.springframework.stereotype.Component;

import com.best.info.domain.role.Role;
import com.best.info.domain.test.Test;
import com.best.info.mapper.AbstractModelMapper;
import com.best.info.model.role.RoleModel;
import com.best.info.model.test.TestModel;
@Component
public class TestMapper extends AbstractModelMapper<TestModel,Test>{

	@Override
	public Class<TestModel> entityType() {
		// TODO Auto-generated method stub
		return TestModel.class;
	}

	@Override
	public Class<Test> modelType() {
		// TODO Auto-generated method stub
		return Test.class;
	}

}
