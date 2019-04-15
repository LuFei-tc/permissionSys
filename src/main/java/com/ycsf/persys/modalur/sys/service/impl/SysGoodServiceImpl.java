package com.ycsf.persys.modalur.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.dao.SysGoodMapper;
import com.ycsf.persys.modalur.sys.entity.SysGood;
import com.ycsf.persys.modalur.sys.service.SysGoodService;

@Component
public class SysGoodServiceImpl implements SysGoodService{
	@Autowired
	private SysGoodMapper sysGoodMapper;
	
	
	@Override
	public List<SysGood> getAllSysGoodInfo(PageInfo page ){
		return sysGoodMapper.findAll(page);
	}
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return sysGoodMapper.count();
	}

	@Override
	public List<SysGood> searchSysGood(String goodName, int maxPrice, int minPrice) {
		// TODO Auto-generated method stub
		return sysGoodMapper.searchSysGood(goodName, maxPrice, minPrice);
	}

	@Override
	public void addSysGood(SysGood good) {
		// TODO Auto-generated method stub
		 sysGoodMapper.insert(good);
	}

	@Override
	public void deleteSysGood(int id) {
		// TODO Auto-generated method stub
		sysGoodMapper.delete(id);
		
	}

	@Override
	public SysGood getSysGoodInfo(int id) {
		// TODO Auto-generated method stub
		return sysGoodMapper.getSysGoodById(id);
	}

	@Override
	public void updateSysGood(SysGood good) {
		// TODO Auto-generated method stub
		sysGoodMapper.update(good);
	}
}
