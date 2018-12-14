package com.best.info.mapper.Pay;

import org.springframework.stereotype.Component;

import com.best.info.domain.Pay.Pay;
import com.best.info.domain.role.Role;
import com.best.info.mapper.AbstractModelMapper;
import com.best.info.model.Pay.PayModel;
import com.best.info.model.role.RoleModel;
@Component
public class PayMapper extends AbstractModelMapper<PayModel,Pay>{

	@Override
	public Class<PayModel> entityType() {
		// TODO Auto-generated method stub
		return PayModel.class;
	}

	@Override
	public Class<Pay> modelType() {
		// TODO Auto-generated method stub
		return Pay.class;
	}

}
