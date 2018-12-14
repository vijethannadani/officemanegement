package com.best.info.service.options;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.info.controller.role.RoleController;
import com.best.info.dao.options.OptionDAO;
import com.best.info.dao.role.RoleDAO;
import com.best.info.domain.options.Option;
import com.best.info.domain.role.Role;
import com.best.info.mapper.options.OptionMapper;
import com.best.info.mapper.role.RoleMapper;
import com.best.info.model.options.OptionModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;
import com.best.info.utils.CommonUtils;
import com.best.info.utils.DateUtility;



@Service("Optionservice")
public class Optionserviceimpl implements OptionService{
	
	

	@Autowired
	OptionDAO optDAO;

	@Autowired
	OptionMapper optMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(Optionserviceimpl.class);
	@Override
	public Response addOption(OptionModel roleModel) throws Exception {

		try {
			Option role = new Option();
			BeanUtils.copyProperties(roleModel, role);

			Response response = optDAO.addOption(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}
	@Override
	public List<OptionModel> getOption() throws Exception {
try {
	List<Option> role =optDAO.getOption();
	return optMapper.entityList(role);
	}
catch (Exception e) {
	logger.info("Exception getDepartments:", e.getMessage());
	return null;
}


}
	@Override
	public OptionModel getOptionById(String roleId) throws Exception {

		try {
			Option role = optDAO.getOption(roleId);
			OptionModel rolemodel = new OptionModel();
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
	public Response deleteOption(String roleId) throws Exception {
		try {
			return optDAO.deleteOption(roleId);
		} catch (Exception e) {
			logger.info("Exception deleteUser:", e.getMessage());

			return null;
		}
		}
	@Override
	public Response updateOption(OptionModel rolemodel) throws Exception {
		try {
			Option role = new Option();
			BeanUtils.copyProperties(rolemodel, role);
		
			Response response = optDAO.updateOption(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;

	}
	


}
