package com.best.info.controller.options;
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
import com.best.info.model.options.OptionModel;
import com.best.info.model.role.RoleModel;
import com.best.info.service.options.OptionService;
import com.best.info.service.role.RoleService;

@RestController
@RequestMapping("/v6")
public class OptionController implements Constants {
	private static final Logger logger = LoggerFactory.getLogger(OptionController.class);

	@Autowired
	OptionService Optionservice;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public Response addOption(@RequestBody OptionModel roleModel, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("addEmployeeAccess: Received request URL:" + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addEmployeeAccess: Received Request: " + CommonUtils.getJson(roleModel));
		return Optionservice.addOption(roleModel);
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getOption(HttpServletRequest request, HttpServletResponse response)throws Exception {
	
			logger.info("getOption List: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
			List<OptionModel> roleModel=Optionservice.getOption();
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
	
	@RequestMapping(value = "/getAll/{optId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getOption(@PathVariable("optId") String optId,HttpServletRequest request, HttpServletResponse response)throws Exception {
	
			logger.info("getrole List: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
			OptionModel roleModel=Optionservice.getOptionById(optId);
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

	@RequestMapping(value="/delete/{optId}", method=RequestMethod.DELETE, produces="application/json")
	public @ResponseBody Response deleteOption(@PathVariable("optId") String roleId, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		logger.info("deleterole: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("deleteroleId: Received request: " + CommonUtils.getJson(roleId));
		return Optionservice.deleteOption(roleId);
	}

	@RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json")
	public Response updateOption(@RequestBody OptionModel rolemodel, HttpServletRequest request, HttpServletResponse response)throws Exception{
		logger.info("updateEmployee: Received request URL: " + request.getRequestURL().toString()
				+((request.getQueryString()==null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateDepartment : Received request:" + CommonUtils.getJson(rolemodel));
		return Optionservice.updateOption(rolemodel);
	}
	
	

	

}
