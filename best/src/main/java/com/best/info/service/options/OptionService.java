package com.best.info.service.options;
import java.util.List;

import com.best.info.model.options.OptionModel;
import com.best.info.model.role.RoleModel;
import com.best.info.response.Response;

public interface OptionService {



	public Response addOption(OptionModel roleModel)throws Exception;

	public List<OptionModel> getOption()throws Exception;

	public OptionModel getOptionById(String optId)throws Exception;

	public Response deleteOption(String roleId)throws Exception;

	public Response updateOption(OptionModel rolemodel)throws Exception;

}
