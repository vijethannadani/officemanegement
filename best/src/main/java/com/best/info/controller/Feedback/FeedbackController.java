package com.best.info.controller.Feedback;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.best.info.constant.Constants;
import com.best.info.response.Response;
import com.best.info.utils.CommonUtils;

import com.best.info.constant.StatusCode;
import com.best.info.response.ErrorObject;
import com.best.info.model.Feedback.FeedbackModel;
import com.best.info.model.role.RoleModel;
import com.best.info.service.Feedback.FeedbackService;
import com.best.info.service.role.RoleService;

@RestController
@RequestMapping("/v9")
public class FeedbackController implements Constants {
	private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);

	@Autowired
	FeedbackService feedbackservice;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public Response addFeedback(@RequestBody FeedbackModel roleModel, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("addEmployeeAccess: Received request URL:" + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addEmployeeAccess: Received Request: " + CommonUtils.getJson(roleModel));
		return feedbackservice.addFeedback(roleModel);
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getFeedback(HttpServletRequest request, HttpServletResponse response)throws Exception {
	
			logger.info("getFeedback List: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
			List<FeedbackModel> roleModel=feedbackservice.getFeedback();
			Response res = CommonUtils.getResponseObject("List of Feedback");
			if (roleModel == null) {
				ErrorObject err = CommonUtils.getErrorResponse("Feedback Not Found", "Feedback Not Found");
				res.setErrors(err);
				res.setStatus(StatusCode.ERROR.name());
			} else {
				res.setData(roleModel);
			}
			logger.info("getEmployeesAccess: Sent response");
			return CommonUtils.getJson(res);
			
	}
	
	@RequestMapping(value = "/getAll/{feeId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getFeedback(@PathVariable("feeId") String roleId,HttpServletRequest request, HttpServletResponse response)throws Exception {
	
			logger.info("getFeedback List: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
			FeedbackModel roleModel=feedbackservice.getFeedbackById(roleId);
			Response res = CommonUtils.getResponseObject("List of roles");
			if (roleModel == null) {
				ErrorObject err = CommonUtils.getErrorResponse("roles Not Found", "roles Not Found");
				res.setErrors(err);
				res.setStatus(StatusCode.ERROR.name());
			} else {
				res.setData(roleModel);
			}
			logger.info("getEmployeesAccess: Sent response");
			return CommonUtils.getJson(res);
			
	}

	@RequestMapping(value="/delete/{feeId}", method=RequestMethod.DELETE, produces="application/json")
	public @ResponseBody Response deleteFeedback(@PathVariable("feeId") String roleId, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		logger.info("deleterole: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("deleteroleId: Received request: " + CommonUtils.getJson(roleId));
		return feedbackservice.deleteFeedback(roleId);
	}

	@RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json")
	public Response updateFeedback(@RequestBody FeedbackModel rolemodel, HttpServletRequest request, HttpServletResponse response)throws Exception{
		logger.info("updateEmployee: Received request URL: " + request.getRequestURL().toString()
				+((request.getQueryString()==null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateDepartment : Received request:" + CommonUtils.getJson(rolemodel));
		return feedbackservice.updateFeedback(rolemodel);
	}
	
	

	

}
