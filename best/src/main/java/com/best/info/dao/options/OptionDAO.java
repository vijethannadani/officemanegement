package com.best.info.dao.options;


import com.best.info.response.Response;
import com.best.info.domain.options.Option;
import com.best.info.domain.role.Role;

import java.util.List;

public interface OptionDAO {

	
	public Response addOption(Option role)throws Exception;

	public List<Option> getOption()throws Exception;

	public Option getOption(String roleId)throws Exception;

	public Response deleteOption(String roleId)throws Exception;

	public Response updateOption(Option role)throws Exception;
		



}
