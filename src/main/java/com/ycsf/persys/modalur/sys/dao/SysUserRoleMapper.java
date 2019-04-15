package com.ycsf.persys.modalur.sys.dao;

import com.ycsf.persys.modalur.sys.vo.UserRoleVO;

public interface SysUserRoleMapper {

	void deleteCascadeInfo(UserRoleVO userRoleVO);

	void insertCascadeInfo(UserRoleVO userRoleVO);

}
