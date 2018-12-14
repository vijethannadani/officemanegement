package com.best.info.controller.Subject;
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
import com.best.info.model.Subject.SubjectModel;
import com.best.info.model.role.RoleModel;
import com.best.info.service.Subject.SubjectService;
import com.best.info.service.role.RoleService;

@RestController
@RequestMapping("/v8")
public class SubjectController implements Constants {
	private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);

	@Autowired
	SubjectService subservice;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public Response addSubject(@RequestBody SubjectModel roleModel, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("addEmployeeAccess: Received request URL:" + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addEmployeeAccess: Received Request: " + CommonUtils.getJson(roleModel));
		return subservice.addSubject(roleModel);
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getSubject(HttpServletRequest request, HttpServletResponse response)throws Exception {
	
			logger.info("getsub List: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
			List<SubjectModel> roleModel=subservice.getSubject();
			Response res = CommonUtils.getResponseObject("List of subjects");
			if (roleModel == null) {
				ErrorObject err = CommonUtils.getErrorResponse("subjects Not Found", "subjects Not Found");
				res.setErrors(err);
				res.setStatus(StatusCode.ERROR.name());
			} else {
				res.setData(roleModel);
			}
			logger.info("getEmployeesAccess: Sent response");
			return CommonUtils.getJson(res);
			
	}
	
	@RequestMapping(value = "/getAll/{subId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getSubject(@PathVariable("subId") String roleId,HttpServletRequest request, HttpServletResponse response)throws Exception {
	
			logger.info("getrole List: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
			SubjectModel roleModel=subservice.getSubjectById(roleId);
			Response res = CommonUtils.getResponseObject("List of subjects");
			if (roleModel == null) {
				ErrorObject err = CommonUtils.getErrorResponse("subjects Not Found", "subjects Not Found");
				res.setErrors(err);
				res.setStatus(StatusCode.ERROR.name());
			} else {
				res.setData(roleModel);
			}
			logger.info("getEmployeesAccess: Sent response");
			return CommonUtils.getJson(res);
			
	}

	@RequestMapping(value="/delete/{subId}", method=RequestMethod.DELETE, produces="application/json")
	public @ResponseBody Response deleteSubject(@PathVariable("subId") String roleId, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		logger.info("deleterole: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("deleteroleId: Received request: " + CommonUtils.getJson(roleId));
		return subservice.deleteSubject(roleId);
	}

	@RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json")
	public Response updateSubject(@RequestBody SubjectModel rolemodel, HttpServletRequest request, HttpServletResponse response)throws Exception{
		logger.info("updateEmployee: Received request URL: " + request.getRequestURL().toString()
				+((request.getQueryString()==null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateDepartment : Received request:" + CommonUtils.getJson(rolemodel));
		return subservice.updateSubject(rolemodel);
	}
	
	

	

}
