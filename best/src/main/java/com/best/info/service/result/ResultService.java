package com.best.info.service.result;
import java.util.List;

import com.best.info.model.result.ResultModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;

public interface ResultService {

	public Response updateResult(ResultModel rolemodel)throws Exception;

	public Response deleteResult(String roleId)throws Exception;

	public ResultModel getResultById(String roleId)throws Exception;

	public List<ResultModel> getResult()throws Exception;

	public Response addResult(ResultModel roleModel)throws Exception;

}
