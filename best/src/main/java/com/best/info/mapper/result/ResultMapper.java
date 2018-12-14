package com.best.info.mapper.result;

import org.springframework.stereotype.Component;

import com.best.info.domain.result.Result;
import com.best.info.domain.role.Role;
import com.best.info.mapper.AbstractModelMapper;
import com.best.info.model.result.ResultModel;
import com.best.info.model.role.RoleModel;
@Component
public class ResultMapper extends AbstractModelMapper<ResultModel,Result>{

	@Override
	public Class<ResultModel> entityType() {
		// TODO Auto-generated method stub
		return ResultModel.class;
	}

	@Override
	public Class<Result> modelType() {
		// TODO Auto-generated method stub
		return Result.class;
	}

}
