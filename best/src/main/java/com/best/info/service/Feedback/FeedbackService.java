package com.best.info.service.Feedback;
import java.util.List;

import com.best.info.model.Feedback.FeedbackModel;
import com.best.info.response.Response;

public interface FeedbackService {




	public Response deleteFeedback(String roleId)throws Exception;

	public Response updateFeedback(FeedbackModel rolemodel)throws Exception;

	public Response addFeedback(FeedbackModel roleModel)throws Exception;

	public List<FeedbackModel> getFeedback()throws Exception;

	public FeedbackModel getFeedbackById(String roleId)throws Exception;

}
