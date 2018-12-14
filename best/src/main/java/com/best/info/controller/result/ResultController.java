package com.best.info.controller.result;
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
import com.best.info.model.result.ResultModel;
import com.best.info.model.role.RoleModel;
import com.best.info.service.result.ResultService;
import com.best.info.service.role.RoleService;

@RestController
@RequestMapping("/v7")
public class ResultController implements Constants {
	private static final Logger logger = LoggerFactory.getLogger(ResultController.class);

	@Autowired
	ResultService reservice;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public Response addResult(@RequestBody ResultModel roleModel, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("addEmployeeAccess: Received request URL:" + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addEmployeeAccess: Received Request: " + CommonUtils.getJson(roleModel));
		return reservice.addResult(roleModel);
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getResult(HttpServletRequest request, HttpServletResponse response)throws Exception {
	
			logger.info("getRole List: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
			List<ResultModel> roleModel=reservice.getResult();
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
	
	@RequestMapping(value = "/getAll/{resId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getResult(@PathVariable("resId") String roleId,HttpServletRequest request, HttpServletResponse response)throws Exception {
	
			logger.info("getrole List: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
			ResultModel roleModel=reservice.getResultById(roleId);
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

	@RequestMapping(value="/delete/{resId}", method=RequestMethod.DELETE, produces="application/json")
	public @ResponseBody Response deleteResult(@PathVariable("resId") String roleId, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		logger.info("deleterole: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("deleteroleId: Received request: " + CommonUtils.getJson(roleId));
		return reservice.deleteResult(roleId);
	}

	@RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json")
	public Response updateResult(@RequestBody ResultModel rolemodel, HttpServletRequest request, HttpServletResponse response)throws Exception{
		logger.info("updateEmployee: Received request URL: " + request.getRequestURL().toString()
				+((request.getQueryString()==null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateDepartment : Received request:" + CommonUtils.getJson(rolemodel));
		return reservice.updateResult(rolemodel);
	}
	
	

	

}
