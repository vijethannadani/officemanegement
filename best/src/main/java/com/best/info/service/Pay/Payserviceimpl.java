package com.best.info.service.Pay;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.info.controller.role.RoleController;
import com.best.info.dao.Pay.PayDAO;
import com.best.info.dao.role.RoleDAO;
import com.best.info.domain.Pay.Pay;
import com.best.info.domain.role.Role;
import com.best.info.mapper.Pay.PayMapper;
import com.best.info.mapper.role.RoleMapper;
import com.best.info.model.Pay.PayModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;
import com.best.info.utils.CommonUtils;
import com.best.info.utils.DateUtility;



@Service("payservice")
public class Payserviceimpl implements PayService{
	
	

	@Autowired
	PayDAO roleDAO;

	@Autowired
	PayMapper roleMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(Payserviceimpl.class);
	@Override
	public Response addPay(PayModel roleModel) {

		try {
			Pay role = new Pay();
			BeanUtils.copyProperties(roleModel, role);

			Response response = roleDAO.addPay(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}
	@Override
	public List<PayModel> getPay()  {
try {
	List<Pay> role =roleDAO.getPay();
	return roleMapper.entityList(role);
	}
catch (Exception e) {
	logger.info("Exception getDepartments:", e.getMessage());
	return null;
}


}
	@Override
	public PayModel getPayById(String roleId)  {

		try {
			Pay role = roleDAO.getPay(roleId);
			PayModel rolemodel = new PayModel();
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
	public Response deletePay(String roleId) {
		try {
			return roleDAO.deletePay(roleId);
		} catch (Exception e) {
			logger.info("Exception deleteUser:", e.getMessage());

			return null;
		}
		}
	@Override
	public Response updatePay(PayModel rolemodel) {
		try {
			Pay role = new Pay();
			BeanUtils.copyProperties(rolemodel, role);
		
			Response response = roleDAO.updatePay(role);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;

	}
	


}
