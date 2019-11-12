package com.wego.web.adm;

import java.util.HashMap;
import java.util.Map;



public interface AdminMapper {

	

	Admin deleteAdmin(Admin param);

	Admin updateAdmin(Admin param);

	Admin selectAdmin(HashMap<String, Object> map);


}
