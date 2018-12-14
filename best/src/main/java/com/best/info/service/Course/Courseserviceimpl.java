package com.best.info.service.Course;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.info.controller.role.RoleController;
import com.best.info.dao.Course.CourseDAO;
import com.best.info.dao.role.RoleDAO;
import com.best.info.domain.Course.Course;
import com.best.info.domain.role.Role;
import com.best.info.mapper.Course.CourseMapper;
import com.best.info.mapper.role.RoleMapper;
import com.best.info.model.Course.CourseModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;
import com.best.info.utils.CommonUtils;
import com.best.info.utils.DateUtility;



@Service("courseservice")
public class Courseserviceimpl implements CourseService{
	
	

	@Autowired
	CourseDAO roleDAO;

	@Autowired
	CourseMapper roleMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(Courseserviceimpl.class);
	@Override
	public Response addCourse(CourseModel roleModel) {

		try {
			Course role = new Course();
			BeanUtils.copyProperties(roleModel, role);

			Response response = roleDAO.addCourse(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}
	@Override
	public List<CourseModel> getCourse() {
try {
	List<Course> role =roleDAO.getCourse();
	return roleMapper.entityList(role);
	}
catch (Exception e) {
	logger.info("Exception getDepartments:", e.getMessage());
	return null;
}


}
	@Override
	public CourseModel getCourseById(String roleId) {

		try {
			Course role = roleDAO.getCourse(roleId);
			CourseModel rolemodel = new CourseModel();
			if (role == null)
				return null;
			BeanUtils.copyProperties(role, rolemodel);
			return rolemodel;
		} catch (Exception e) {
			logger.info("Exception getcourse:", e.getMessage());
			return null;
		}
}
	@Override
	public Response deleteCourse(String roleId) {
		try {
			return roleDAO.deleteCourse(roleId);
		} catch (Exception e) {
			logger.info("Exception deleteUser:", e.getMessage());

			return null;
		}
		}
	@Override
	public Response updateCourse(CourseModel rolemodel){
		try {
			Course role = new Course();
			BeanUtils.copyProperties(rolemodel, role);
		
			Response response = roleDAO.updateCourse(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;

	}
	


}
