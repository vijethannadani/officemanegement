package com.best.info.dao.Course;


import com.best.info.response.Response;
import com.best.info.domain.Course.Course;
import com.best.info.domain.role.Role;

import java.util.List;

public interface CourseDAO {


	public Response addCourse(Course role) throws Exception;

	public Response deleteCourse(String roleId) throws Exception;

	public Response updateCourse(Course role) throws Exception;

	public Course getCourse(String roleId) throws Exception;

	public List<Course> getCourse() throws Exception;
		



}
