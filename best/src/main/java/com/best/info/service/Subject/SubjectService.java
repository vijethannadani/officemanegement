package com.best.info.service.Subject;
import java.util.List;

import com.best.info.model.Subject.SubjectModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;

public interface SubjectService {

	Response addSubject(SubjectModel roleModel) throws Exception;

	List<SubjectModel> getSubject() throws Exception;

	SubjectModel getSubjectById(String roleId)throws Exception;

	Response deleteSubject(String roleId)throws Exception;

	Response updateSubject(SubjectModel rolemodel)throws Exception;
	

}
