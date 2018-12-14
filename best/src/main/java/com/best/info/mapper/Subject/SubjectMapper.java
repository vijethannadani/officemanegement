package com.best.info.mapper.Subject;

import org.springframework.stereotype.Component;

import com.best.info.domain.Subject.Subject;
import com.best.info.domain.role.Role;
import com.best.info.mapper.AbstractModelMapper;
import com.best.info.model.Subject.SubjectModel;
import com.best.info.model.role.RoleModel;
@Component
public class SubjectMapper extends AbstractModelMapper<SubjectModel,Subject>{

	@Override
	public Class<SubjectModel> entityType() {
		// TODO Auto-generated method stub
		return SubjectModel.class;
	}

	@Override
	public Class<Subject> modelType() {
		// TODO Auto-generated method stub
		return Subject.class;
	}

}
