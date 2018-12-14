package com.best.info.mapper.Question;

import org.springframework.stereotype.Component;

import com.best.info.domain.Question.Question;
import com.best.info.domain.role.Role;
import com.best.info.mapper.AbstractModelMapper;
import com.best.info.model.Question.QuestionModel;
import com.best.info.model.role.RoleModel;
@Component
public class QuestionMapper extends AbstractModelMapper<QuestionModel,Question>{

	@Override
	public Class<QuestionModel> entityType() {
		// TODO Auto-generated method stub
		return QuestionModel.class;
	}

	@Override
	public Class<Question> modelType() {
		// TODO Auto-generated method stub
		return Question.class;
	}

}
