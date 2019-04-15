package com.ycsf.persys.modalur.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ycsf.persys.modalur.sys.dao.SysGoodMapper;
import com.ycsf.persys.modalur.sys.dao.SysOrderMapper;
import com.ycsf.persys.modalur.sys.entity.SysOrder;
import com.ycsf.persys.modalur.sys.service.SysOrderService;

@Component
public class SysOrderServiceImpl implements SysOrderService{

	@Autowired
	private SysOrderMapper sysOrderMapper;
	
	@Override
	public void addSysOrder(SysOrder order) {
		// TODO Auto-generated method stub
		sysOrderMapper.insert(order);
	}

	@Override
	public List<SysOrder> findAllSysOrder() {
		// TODO Auto-generated method stub
		return sysOrderMapper.findAll();
	}

	@Override
	public void deleteSysOrder(int id) {
		// TODO Auto-generated method stub
		sysOrderMapper.delete(id);
	}

	@Override
	public SysOrder findSysOrderById(int id) {
		// TODO Auto-generated method stub
		return sysOrderMapper.findById(id);
	}

	@Override
	public List<SysOrder> findAllByUname(String uname) {
		// TODO Auto-generated method stub
		return sysOrderMapper.findAllByUname(uname);
	}
	
}
