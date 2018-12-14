package com.best.info.service.result;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.info.controller.role.RoleController;
import com.best.info.dao.result.ResultDAO;
import com.best.info.dao.role.RoleDAO;
import com.best.info.domain.result.Result;
import com.best.info.domain.role.Role;
import com.best.info.mapper.result.ResultMapper;
import com.best.info.mapper.role.RoleMapper;
import com.best.info.model.result.ResultModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;
import com.best.info.utils.CommonUtils;
import com.best.info.utils.DateUtility;



@Service("reservice")
public class Resultserviceimpl implements ResultService{
	
	

	@Autowired
	ResultDAO resDAO;

	@Autowired
	ResultMapper resMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(Resultserviceimpl.class);
	@Override
	public Response addResult(ResultModel roleModel) throws Exception {

		try {
			Result role = new Result();
			BeanUtils.copyProperties(roleModel, role);

			Response response = resDAO.addResult(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}
	@Override
	public List<ResultModel> getResult() throws Exception {
try {
	List<Result> role =resDAO.getResult();
	return resMapper.entityList(role);
	}
catch (Exception e) {
	logger.info("Exception getDepartments:", e.getMessage());
	return null;
}


}
	@Override
	public ResultModel getResultById(String resId) throws Exception {

		try {
			Result role = resDAO.getResult(resId);
			ResultModel rol = new ResultModel();
			if (role == null)
				return null;
			BeanUtils.copyProperties(role, rol);
			return rol;
		} catch (Exception e) {
			logger.info("Exception getUser:", e.getMessage());
			return null;
		}
}
	@Override
	public Response deleteResult(String roleId) throws Exception {
		try {
			return resDAO.deleteResult(roleId);
		} catch (Exception e) {
			logger.info("Exception deleteUser:", e.getMessage());

			return null;
		}
		}
	@Override
	public Response updateResult(ResultModel rolemodel) throws Exception {
		try {
			Result role = new Result();
			BeanUtils.copyProperties(rolemodel, role);
		
			Response response = resDAO.updateResult(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;

	}
	


}
