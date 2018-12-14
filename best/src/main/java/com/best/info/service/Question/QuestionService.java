package com.best.info.service.Question;
import java.util.List;

import com.best.info.model.Question.QuestionModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;

public interface QuestionService {




	public Response addQuestion(QuestionModel roleModel)throws Exception;

	public List<QuestionModel> getQuestion()throws Exception;

	public QuestionModel getQuestionById(String qusId)throws Exception;

	public Response deleteQuestion(String qusId)throws Exception;

	public Response updateQuestion(QuestionModel rolemodel)throws Exception;

}
