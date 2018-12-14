package com.best.info.mapper.options;

import org.springframework.stereotype.Component;

import com.best.info.domain.options.Option;
import com.best.info.domain.role.Role;
import com.best.info.mapper.AbstractModelMapper;
import com.best.info.model.options.OptionModel;
import com.best.info.model.role.RoleModel;
@Component
public class OptionMapper extends AbstractModelMapper<OptionModel,Option>{

	@Override
	public Class<OptionModel> entityType() {
		// TODO Auto-generated method stub
		return OptionModel.class;
	}

	@Override
	public Class<Option> modelType() {
		// TODO Auto-generated method stub
		return Option.class;
	}

}
