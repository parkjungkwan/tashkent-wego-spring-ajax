package com.wego.web.adm;

import java.util.HashMap;
import java.util.Map;

import com.wego.web.pxy.Trunk;



public interface AdminMapper {

	

	Admin deleteAdmin(Admin param);

	Admin updateAdmin(Admin param);

	Admin selectAdmin(Trunk<? extends Admin> map);


}
