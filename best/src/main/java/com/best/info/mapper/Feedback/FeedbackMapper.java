package com.best.info.mapper.Feedback;

import org.springframework.stereotype.Component;

import com.best.info.domain.Feedback.Feedback;
import com.best.info.domain.role.Role;
import com.best.info.mapper.AbstractModelMapper;
import com.best.info.model.Feedback.FeedbackModel;
import com.best.info.model.role.RoleModel;
@Component
public class FeedbackMapper extends AbstractModelMapper<FeedbackModel,Feedback>{

	@Override
	public Class<FeedbackModel> entityType() {
		// TODO Auto-generated method stub
		return FeedbackModel.class;
	}

	@Override
	public Class<Feedback> modelType() {
		// TODO Auto-generated method stub
		return Feedback.class;
	}

}
