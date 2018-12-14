package com.best.info.dao.Feedback;


import com.best.info.response.Response;
import com.best.info.domain.Feedback.Feedback;
import com.best.info.domain.role.Role;

import java.util.List;

public interface FeedbackDAO {


	public Response addFeedback(Feedback role)throws Exception;

	public List<Feedback> getFeedback()throws Exception;

	

	public Feedback getFeedback(String roleId)throws Exception;

	public Response deleteFeedback(String roleId)throws Exception;

	public Response updateFeedback(Feedback role)throws Exception;
		



}
