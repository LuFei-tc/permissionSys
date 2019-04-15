package com.ycsf.persys.modalur.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.entity.SysPerm;

public interface SysPermMapper {
	List<SysPerm> findByRoleId(int id);

	void insert(SysPerm perm);

	void delete(int id);

	void update(SysPerm perm);

	SysPerm findById(int id);
	
	List<SysPerm> findAll(PageInfo page);

	int count();
}
