package com.best.info.dao.Course;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.best.info.constant.StatusCode;
import com.best.info.response.Response;
import com.best.info.utils.CommonUtils;
import com.best.info.domain.Course.Course;
import com.best.info.domain.role.Role;
import com.best.info.model.role.RoleModel;


@Transactional
@Repository
public class CourseDAOimpl implements CourseDAO  {


private static final Logger logger = LoggerFactory.getLogger(CourseDAOimpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Response addCourse(Course department) throws Exception {
		Response response = CommonUtils.getResponseObject("Add Course data");
		try {
			entityManager.persist(department);
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			logger.error("Exception in addcourse", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getCourse() throws Exception  {
		try {
			String hql = "FROM Course where isActive=true";
			return (List<Course>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getcourse", e);
		}
		return null;
	}

	@Override
	public Course getCourse(String roleId) throws Exception {
		try {
			String hql = "From Course where roleId=? and isActive=true";
			return (Course) entityManager.createQuery(hql).setParameter(0, roleId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getcourse", e);
			return null;
		}
		
		
		
		
		
	
	}

	@Override
	public Response deleteCourse(String roleId) throws Exception {
	
		Response response=CommonUtils.getResponseObject("delete Course data ");
		
	try {
		Course role=getCourse(roleId);
		//role.setActive(false);
		entityManager.flush();
		
		response.setStatus(StatusCode.SUCCESS.name());
		
	}
	catch (Exception e) {
		logger.info("Exception in deleteCourse", e);
		response.setStatus(StatusCode.ERROR.name());
		response.setErrors(e.getMessage());	
	}
	return response;
	}

	@Override
	public Response updateCourse(Course role) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Department data");
		try {
			Course dept = getCourse(role.getCurId());
			dept.setCurName(role.getCurName());
			
		
			
			entityManager.flush();
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			logger.error("Exception in updateDepartment", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;	
}
}
