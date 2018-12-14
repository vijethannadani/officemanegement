package com.best.info.dao.test;


import com.best.info.response.Response;
import com.best.info.domain.role.Role;
import com.best.info.domain.test.Test;

import java.util.List;

public interface TestDAO {



	public Response addtest(Test role)throws Exception;

	public List<Test> getTest()throws Exception;

	public Test getTest(String roleId)throws Exception;

	public Response deletTest(String roleId)throws Exception;

	public Response updateTest(Test role)throws Exception;

	
		



}
