package com.best.info.service.Feedback;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.info.controller.role.RoleController;
import com.best.info.dao.Feedback.FeedbackDAO;
import com.best.info.dao.role.RoleDAO;
import com.best.info.domain.Feedback.Feedback;
import com.best.info.domain.role.Role;
import com.best.info.mapper.Feedback.FeedbackMapper;
import com.best.info.mapper.role.RoleMapper;
import com.best.info.model.Feedback.FeedbackModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;
import com.best.info.utils.CommonUtils;
import com.best.info.utils.DateUtility;



@Service("feedbackservice")
public class Feedbackserviceimpl implements FeedbackService{
	
	

	@Autowired
	FeedbackDAO feedbackDAO;

	@Autowired
	FeedbackMapper roleMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(Feedbackserviceimpl.class);
	@Override
	public Response addFeedback(FeedbackModel roleModel) throws Exception {

		try {
			Feedback role = new Feedback();
			BeanUtils.copyProperties(roleModel, role);

			Response response = feedbackDAO.addFeedback(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}
	@Override
	public List<FeedbackModel> getFeedback() throws Exception {
try {
	List<Feedback> role =feedbackDAO.getFeedback();
	return roleMapper.entityList(role);
	}
catch (Exception e) {
	logger.info("Exception getDepartments:", e.getMessage());
	return null;
}


}
	@Override
	public FeedbackModel getFeedbackById(String roleId) throws Exception {

		try {
			Feedback role = feedbackDAO.getFeedback(roleId);
			FeedbackModel rolemodel = new FeedbackModel();
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
	public Response deleteFeedback(String roleId) throws Exception {
		try {
			return feedbackDAO.deleteFeedback(roleId);
		} catch (Exception e) {
			logger.info("Exception deleteUser:", e.getMessage());

			return null;
		}
		}
	@Override
	public Response updateFeedback(FeedbackModel rolemodel) throws Exception {
		try {
			Feedback role = new Feedback();
			BeanUtils.copyProperties(rolemodel, role);
		
			Response response = feedbackDAO.updateFeedback(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;

	}
	


}
