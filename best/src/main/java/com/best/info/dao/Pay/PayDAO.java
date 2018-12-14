package com.best.info.dao.Pay;


import com.best.info.response.Response;
import com.best.info.domain.Pay.Pay;
import com.best.info.domain.role.Role;

import java.util.List;

public interface PayDAO {



	public Response addPay(Pay role) throws Exception;

	

	public List<Pay> getPay()throws Exception;



	public Pay getPay(String roleId)throws Exception;



	public Response deletePay(String roleId)throws Exception;



	public Response updatePay(Pay role)throws Exception;
		



}
