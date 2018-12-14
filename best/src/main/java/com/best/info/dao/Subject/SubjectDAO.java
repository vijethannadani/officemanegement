package com.best.info.dao.Subject;


import com.best.info.response.Response;
import com.best.info.domain.Subject.Subject;
import com.best.info.domain.role.Role;

import java.util.List;

public interface SubjectDAO {


	public Response updateSubject(Subject role)throws Exception;

	public Response deleteSubject(String roleId)throws Exception;

	public Subject getSubject(String roleId)throws Exception;

	public List<Subject> getSubject()throws Exception;

	public Response addSubject(Subject role)throws Exception;
		



}
