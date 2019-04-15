package com.ycsf.persys.modalur.sys.service;

import java.util.List;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.entity.SysUser;
import com.ycsf.persys.modalur.sys.vo.UserRoleVO;

public interface SysUserService {
	public SysUser findByName(String name);

	public void addSysUser(UserRoleVO vo);

	public void deleteSysUser(int id);

	public void updateSysUser(UserRoleVO vo);

	public SysUser getSysUserInfo(int id);

	public List<SysUser> getAllSysUserInfo(PageInfo page);

	int count();
}
