package com.ycsf.persys.modalur.sys.dao;

import java.util.List;

import com.ycsf.persys.modalur.sys.entity.SysOrder;

public interface SysOrderMapper {
	void insert(SysOrder order);
	
	void  delete(int id);
	
	List<SysOrder> findAll();

	SysOrder findById(int id);
	
	List<SysOrder> findAllByUname(String uname);
}