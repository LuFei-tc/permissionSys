package com.ycsf.persys.modalur.sys.service;

import java.util.List;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.entity.SysGood;

public interface SysGoodService {
	public List<SysGood> getAllSysGoodInfo(PageInfo page);

	int count();

	public List<SysGood> searchSysGood(String goodName, int maxPrice, int minPrice);

	public void addSysGood(SysGood good);

	public void deleteSysGood(int id);

	public SysGood getSysGoodInfo(int id);

	public void updateSysGood(SysGood good);

}
