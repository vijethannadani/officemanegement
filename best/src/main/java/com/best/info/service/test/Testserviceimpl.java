package com.best.info.service.test;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.info.controller.role.RoleController;
import com.best.info.dao.role.RoleDAO;
import com.best.info.dao.test.TestDAO;
import com.best.info.domain.role.Role;
import com.best.info.domain.test.Test;
import com.best.info.mapper.role.RoleMapper;
import com.best.info.mapper.test.TestMapper;
import com.best.info.model.role.RoleModel;
import com.best.info.model.test.TestModel;
import com.best.info.response.Response;
import com.best.info.utils.CommonUtils;
import com.best.info.utils.DateUtility;



@Service("testservice")
public class Testserviceimpl implements TestService{
	
	

	@Autowired
	TestDAO testDAO;

	@Autowired
	TestMapper testMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(Testserviceimpl.class);
	@Override
	public Response addTest(TestModel roleModel) throws Exception {

		try {
			Test role = new Test();
			BeanUtils.copyProperties(roleModel, role);

			Response response = testDAO.addtest(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}
	@Override
	public List<TestModel> getTest() throws Exception {
try {
	List<Test> role =testDAO.getTest();
	return testMapper.entityList(role);
	}
catch (Exception e) {
	logger.info("Exception getDepartments:", e.getMessage());
	return null;
}


}
	@Override
	public TestModel getTestById(String roleId) throws Exception {

		try {
			Test role = testDAO.getTest(roleId);
			TestModel rolemodel = new TestModel();
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
	public Response deleteTest(String roleId) throws Exception {
		try {
			return testDAO.deletTest(roleId);
		} catch (Exception e) {
			logger.info("Exception deleteUser:", e.getMessage());

			return null;
		}
		}
	@Override
	public Response updateTest(TestModel rolemodel) throws Exception {
		try {
			Test role = new Test();
			BeanUtils.copyProperties(rolemodel, role);
		
			Response response = testDAO.updateTest(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;

	}
	


}
