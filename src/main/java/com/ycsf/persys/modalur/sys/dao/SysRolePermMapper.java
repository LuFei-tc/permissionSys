package com.ycsf.persys.modalur.sys.dao;

import com.ycsf.persys.modalur.sys.vo.RolePermVO;

public interface SysRolePermMapper {
	
	void deleteCascadeInfo(RolePermVO rolePermVO);

	void insertCascadeInfo(RolePermVO rolePermVO);
	
	 
}
