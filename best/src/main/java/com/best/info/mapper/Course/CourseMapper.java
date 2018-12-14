package com.best.info.mapper.Course;

import org.springframework.stereotype.Component;

import com.best.info.domain.Course.Course;
import com.best.info.domain.role.Role;
import com.best.info.mapper.AbstractModelMapper;
import com.best.info.model.Course.CourseModel;
import com.best.info.model.role.RoleModel;
@Component
public class CourseMapper extends AbstractModelMapper<CourseModel,Course>{

	@Override
	public Class<CourseModel> entityType() {
		// TODO Auto-generated method stub
		return CourseModel.class;
	}

	@Override
	public Class<Course> modelType() {
		// TODO Auto-generated method stub
		return Course.class;
	}

}
