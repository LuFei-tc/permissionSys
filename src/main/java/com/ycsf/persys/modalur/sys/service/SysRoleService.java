package com.ycsf.persys.modalur.sys.service;

import java.util.List;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.entity.SysRole;
import com.ycsf.persys.modalur.sys.vo.RolePermVO;

public interface SysRoleService {

	void addSysRole(RolePermVO vo);

	void deleteSysRole(int id);

	void updateSysRole(RolePermVO vo);

	SysRole getSysRoleInfo(int id);

	List<SysRole> getAllSysRoleInfo(PageInfo page);

	int count();
}
