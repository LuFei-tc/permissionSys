package com.ycsf.persys.modalur.sys.service;

import java.util.List;

import com.ycsf.persys.modalur.sys.entity.SysOrder;

public interface SysOrderService {

	void addSysOrder(SysOrder order);

	List<SysOrder> findAllSysOrder();

	void deleteSysOrder(int id);
	
	SysOrder findSysOrderById(int id);
	
	List<SysOrder> findAllByUname(String uname);

}
