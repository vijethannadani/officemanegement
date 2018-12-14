package com.best.info.controller.Admin;
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
import com.best.info.model.Admin.AdminModel;
import com.best.info.service.Admin.AdminService;

@RestController
@RequestMapping("/v2")
public class AdminController implements Constants {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	AdminService adminservice;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public Response addAdmin(@RequestBody AdminModel adminmodel, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("addAdminAccess: Received request URL:" + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addAdminAccess: Received Request: " + CommonUtils.getJson(adminmodel));
		return adminservice.addAdmin(adminmodel);
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getAdmin(HttpServletRequest request, HttpServletResponse response)throws Exception {
	
			logger.info("getRole List: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
			List<AdminModel> adminmodel=adminservice.getAdmin();
			Response res = CommonUtils.getResponseObject("List of admins");
			if (adminmodel == null) {
				ErrorObject err = CommonUtils.getErrorResponse("admin data Not Found", "admin data Not Found");
				res.setErrors(err);
				res.setStatus(StatusCode.ERROR.name());
			} else {
				res.setData(adminmodel);
			}
			logger.info("getEmployeesAccess: Sent response");
			return CommonUtils.getJson(res);
			
	}
	
	@RequestMapping(value = "/getAll/{adminId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getAdmin(@PathVariable("adminId") String adminId,HttpServletRequest request, HttpServletResponse response)throws Exception {
	
			logger.info("getrole List: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
			AdminModel adminmodel=adminservice.getAdminById(adminId);
			Response res = CommonUtils.getResponseObject("List of roles");
			if (adminmodel == null) {
				ErrorObject err = CommonUtils.getErrorResponse("roles Not Found", "roles Not Found");
				res.setErrors(err);
				res.setStatus(StatusCode.ERROR.name());
			} else {
				res.setData(adminmodel);
			}
			logger.info("getEmployeesAccess: Sent response");
			return CommonUtils.getJson(res);
			
	}

	@RequestMapping(value="/delete/{adminId}", method=RequestMethod.DELETE, produces="application/json")
	public @ResponseBody Response deleteAdmin(@PathVariable("adminId") String adminId, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		logger.info("deleterole: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("deleteroleId: Received request: " + CommonUtils.getJson(adminId));
		return adminservice.deleteAdmin(adminId);
	}

	@RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json")
	public Response updateAdmin(@RequestBody AdminModel adminmodel, HttpServletRequest request, HttpServletResponse response)throws Exception{
		logger.info("updateEmployee: Received request URL: " + request.getRequestURL().toString()
				+((request.getQueryString()==null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateDepartment : Received request:" + CommonUtils.getJson(adminmodel));
		return adminservice.updateAdmin(adminmodel);
	}
	
	

	

}
