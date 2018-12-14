package com.best.info.dao.Question;


import com.best.info.response.Response;
import com.best.info.domain.Question.Question;
import com.best.info.domain.role.Role;

import java.util.List;

public interface QuestionDAO {

	

	public Response addQuestion(Question role) throws Exception;

	public List<Question> getQuestion()throws Exception;

	public Question getQuestion(String roleId)throws Exception;

	public Response deleteQuestion(String roleId)throws Exception;

	public Response updateQuestion(Question role)throws Exception;
		



}
