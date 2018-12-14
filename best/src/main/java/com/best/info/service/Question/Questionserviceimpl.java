 package com.best.info.service.Question;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.info.controller.role.RoleController;
import com.best.info.dao.Question.QuestionDAO;
import com.best.info.dao.role.RoleDAO;
import com.best.info.domain.Question.Question;
import com.best.info.domain.role.Role;
import com.best.info.mapper.Question.QuestionMapper;
import com.best.info.mapper.role.RoleMapper;
import com.best.info.model.Question.QuestionModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;
import com.best.info.utils.CommonUtils;
import com.best.info.utils.DateUtility;



@Service("qusservice")
public class Questionserviceimpl implements QuestionService{
	
	

	@Autowired
	QuestionDAO qusDAO;

	@Autowired
	QuestionMapper qusMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(Questionserviceimpl.class);
	@Override
	public Response addQuestion(QuestionModel roleModel) throws Exception {

		try {
			Question role = new Question();
			BeanUtils.copyProperties(roleModel, role);

			Response response = qusDAO.addQuestion(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}
	@Override
	public List<QuestionModel> getQuestion() throws Exception {
try {
	List<Question> role =qusDAO.getQuestion();
	return qusMapper.entityList(role);
	}
catch (Exception e) {
	logger.info("Exception getDepartments:", e.getMessage());
	return null;
}


}
	@Override
	public QuestionModel getQuestionById(String roleId) throws Exception {

		try {
			Question role = qusDAO.getQuestion(roleId);
			QuestionModel rolemodel = new QuestionModel();
			if (role == null)
				return null;
			BeanUtils.copyProperties(role, rolemodel);
			return rolemodel;
		} catch (Exception e) {
			logger.info("Exception getUser:", e.getMessage());
			return null;
		}
}
	@Override
	public Response deleteQuestion(String roleId) throws Exception {
		try {
			return qusDAO.deleteQuestion(roleId);
		} catch (Exception e) {
			logger.info("Exception deleteUser:", e.getMessage());

			return null;
		}
		}
	@Override
	public Response updateQuestion(QuestionModel rolemodel) throws Exception {
		try {
			Question role = new Question();
			BeanUtils.copyProperties(rolemodel, role);
		
			Response response = qusDAO.updateQuestion(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;

	}
	


}
