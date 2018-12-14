package com.best.info.controller.Question;
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
import com.best.info.model.Question.QuestionModel;
import com.best.info.model.role.RoleModel;
import com.best.info.service.Question.QuestionService;
import com.best.info.service.role.RoleService;

@RestController
@RequestMapping("/v4")
public class QuestionController implements Constants {
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

	@Autowired
	QuestionService qusservice;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public Response addQuestion(@RequestBody QuestionModel roleModel, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("addQuestionAccess: Received request URL:" + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addQuestionAccess: Received Request: " + CommonUtils.getJson(roleModel));
		return qusservice.addQuestion(roleModel);
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getQuestion(HttpServletRequest request, HttpServletResponse response)throws Exception {
	
			logger.info("getQuestion List: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
			List<QuestionModel> roleModel=qusservice.getQuestion();
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
	
	@RequestMapping(value = "/getAll/{qusId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getQuestion(@PathVariable("qusId") String qusId,HttpServletRequest request, HttpServletResponse response)throws Exception {
	
			logger.info("getrole List: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
			QuestionModel roleModel=qusservice.getQuestionById(qusId);
			Response res = CommonUtils.getResponseObject("List of question");
			if (roleModel == null) {
				ErrorObject err = CommonUtils.getErrorResponse("Question Not Found", "Question Not Found");
				res.setErrors(err);
				res.setStatus(StatusCode.ERROR.name());
			} else {
				res.setData(roleModel);
			}
			logger.info("getEmployeesAccess: Sent response");
			return CommonUtils.getJson(res);
			
	}

	@RequestMapping(value="/delete/{qusId}", method=RequestMethod.DELETE, produces="application/json")
	public @ResponseBody Response deleteQuestion(@PathVariable("qusId") String qusId, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		logger.info("deleterole: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("deleteroleId: Received request: " + CommonUtils.getJson(qusId));
		return qusservice.deleteQuestion(qusId);
	}

	@RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json")
	public Response updateQuestion(@RequestBody QuestionModel rolemodel, HttpServletRequest request, HttpServletResponse response)throws Exception{
		logger.info("updateEmployee: Received request URL: " + request.getRequestURL().toString()
				+((request.getQueryString()==null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateDepartment : Received request:" + CommonUtils.getJson(rolemodel));
		return qusservice.updateQuestion(rolemodel);
	}
	
	

	

}
