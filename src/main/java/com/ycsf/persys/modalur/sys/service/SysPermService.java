package com.ycsf.persys.modalur.sys.service;

import java.util.List;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.entity.SysPerm;

public interface SysPermService {

	void addSysPerm(SysPerm perm);

	void deleteSysPerm(int id);

	void updateSysPerm(SysPerm perm);

	SysPerm getSysPermInfo(int id);

	List<SysPerm> getAllSysPermInfo(PageInfo page);

	int count();
}
