package com.best.info.service.Course;
import java.util.List;

import com.best.info.model.Course.CourseModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;

public interface CourseService {




	public List<CourseModel> getCourse();

	public Response addCourse(CourseModel roleModel);

	public CourseModel getCourseById(String roleId);



	public Response deleteCourse(String roleId);

	public Response updateCourse(CourseModel rolemodel);


}
