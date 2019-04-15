package com.ycsf.persys.modalur.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.entity.SysGood;

public interface SysGoodMapper {

	
	List<SysGood> findAll(PageInfo page);
	
	int count();
	
	List<SysGood> searchSysGood(@Param("goodName")String goodName, @Param("maxPrice")int maxPrice, @Param("minPrice")int minPrice);
	
	void insert(SysGood good);
	
	void delete(int id);
	
	SysGood getSysGoodById(int id);
	
	void update(SysGood good);
}
