package com.best.info.service.test;
import java.util.List;


import com.best.info.model.role.RoleModel;
import com.best.info.model.test.TestModel;
import com.best.info.response.Response;

public interface TestService {
	


	public Response updateTest(TestModel rolemodel)throws Exception;

	public Response deleteTest(String testId)throws Exception;

	public TestModel getTestById(String testId)throws Exception;

	public List<TestModel> getTest()throws Exception;

	public Response addTest(TestModel roleModel)throws Exception;

}
