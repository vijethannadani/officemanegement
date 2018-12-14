package com.best.info.service.Pay;
import java.util.List;

import com.best.info.model.Pay.PayModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;

public interface PayService {




	public List<PayModel> getPay();

	public Response addPay(PayModel roleModel);



	public PayModel getPayById(String roleId);



	public Response deletePay(String roleId);

	Response updatePay(PayModel rolemodel);

}
