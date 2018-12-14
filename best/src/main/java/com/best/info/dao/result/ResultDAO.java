package com.best.info.dao.result;


import com.best.info.response.Response;
import com.best.info.domain.result.Result;
import com.best.info.domain.role.Role;

import java.util.List;

public interface ResultDAO {


	public Response addResult(Result role)throws Exception;

	public List<Result> getResult()throws Exception;

	public Response deleteResult(String roleId)throws Exception;

	public Response updateResult(Result role)throws Exception;

	public Result getResult(String roleId)throws Exception;
		



}
