package com.best.info.service.Subject;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.info.controller.role.RoleController;
import com.best.info.dao.Subject.SubjectDAO;
import com.best.info.dao.role.RoleDAO;
import com.best.info.domain.Subject.Subject;
import com.best.info.domain.role.Role;
import com.best.info.mapper.Subject.SubjectMapper;
import com.best.info.mapper.role.RoleMapper;
import com.best.info.model.Subject.SubjectModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;
import com.best.info.utils.CommonUtils;
import com.best.info.utils.DateUtility;



@Service("subservice")
public class Subjectserviceimpl implements SubjectService{
	
	

	@Autowired
	SubjectDAO roleDAO;

	@Autowired
	SubjectMapper roleMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(Subjectserviceimpl.class);
	@Override
	public Response addSubject(SubjectModel roleModel) throws Exception {

		try {
			Subject role = new Subject();
			BeanUtils.copyProperties(roleModel, role);

			Response response = roleDAO.addSubject(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}
	@Override
	public List<SubjectModel> getSubject() throws Exception {
try {
	List<Subject> role =roleDAO.getSubject();
	return roleMapper.entityList(role);
	}
catch (Exception e) {
	logger.info("Exception getDepartments:", e.getMessage());
	return null;
}


}
	@Override
	public SubjectModel getSubjectById(String roleId) throws Exception {

		try {
			Subject role = roleDAO.getSubject(roleId);
			SubjectModel rolemodel = new SubjectModel();
			if (role == null)
				return null;
			BeanUtils.copyProperties(role, rolemodel);
			return rolemodel;
		} catch (Exception e) {
			logger.info("Exception getUser:", e.getMessage());
			return null;
		}
}
	@Override
	public Response deleteSubject(String roleId) throws Exception {
		try {
			return roleDAO.deleteSubject(roleId);
		} catch (Exception e) {
			logger.info("Exception deleteUser:", e.getMessage());

			return null;
		}
		}
	@Override
	public Response updateSubject(SubjectModel rolemodel) throws Exception {
		try {
			Subject role = new Subject();
			BeanUtils.copyProperties(rolemodel, role);
		
			Response response = roleDAO.updateSubject(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;

	}
	


}
