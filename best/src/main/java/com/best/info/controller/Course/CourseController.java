package com.best.info.controller.Course;
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
import com.best.info.model.Course.CourseModel;
import com.best.info.model.role.RoleModel;
import com.best.info.service.Course.CourseService;
import com.best.info.service.role.RoleService;

@RestController
@RequestMapping("/v10")
public class CourseController implements Constants {
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	CourseService courseservice;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public Response addCourse(@RequestBody CourseModel roleModel, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("addEmployeeAccess: Received request URL:" + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addEmployeeAccess: Received Request: " + CommonUtils.getJson(roleModel));
		return courseservice.addCourse(roleModel);
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getCourse(HttpServletRequest request, HttpServletResponse response)throws Exception {
	
			logger.info("getCourse List: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
			List<CourseModel> roleModel=courseservice.getCourse();
			Response res = CommonUtils.getResponseObject("List of course");
			if (roleModel == null) {
				ErrorObject err = CommonUtils.getErrorResponse("course Not Found", "course Not Found");
				res.setErrors(err);
				res.setStatus(StatusCode.ERROR.name());
			} else {
				res.setData(roleModel);
			}
			logger.info("getEmployeesAccess: Sent response");
			return CommonUtils.getJson(res);
			
	}
	
	@RequestMapping(value = "/getAll/{curId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getCourse(@PathVariable("curId") String roleId,HttpServletRequest request, HttpServletResponse response)throws Exception {
	
			logger.info("getCourse List: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
			CourseModel roleModel=courseservice.getCourseById(roleId);
			Response res = CommonUtils.getResponseObject("List of course");
			if (roleModel == null) {
				ErrorObject err = CommonUtils.getErrorResponse("Course Not Found", "Course Not Found");
				res.setErrors(err);
				res.setStatus(StatusCode.ERROR.name());
			} else {
				res.setData(roleModel);
			}
			logger.info("getEmployeesAccess: Sent response");
			return CommonUtils.getJson(res);
			
	}

	@RequestMapping(value="/delete/{curId}", method=RequestMethod.DELETE, produces="application/json")
	public @ResponseBody Response deleteCourse(@PathVariable("curId") String roleId, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		logger.info("deleterole: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("deleteroleId: Received request: " + CommonUtils.getJson(roleId));
		return courseservice.deleteCourse(roleId);
	}

	@RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json")
	public Response updateCourse(@RequestBody CourseModel rolemodel, HttpServletRequest request, HttpServletResponse response)throws Exception{
		logger.info("updateEmployee: Received request URL: " + request.getRequestURL().toString()
				+((request.getQueryString()==null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateDepartment : Received request:" + CommonUtils.getJson(rolemodel));
		return courseservice.updateCourse(rolemodel);
	}
	
	

	

}
