package com.ycsf.persys.modalur.sys.service;

import java.util.Map;

public interface ShiroService {
	
	//从数据库中获取权限资源生产map对象
	public Map<String,String> loadFilterChainDefinitionMap();
	//更新系统权限的
	void updatePermissions();
}
