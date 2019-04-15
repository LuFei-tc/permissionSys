package com.ycsf.persys.modalur.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.entity.SysRole;

public interface SysRoleMapper {
	List<SysRole> findByUserId(int id);

	void delete(int id);

	void insert(SysRole role);

	void update(SysRole role);

	SysRole findById(int id);

	List<SysRole> findAll(PageInfo page);

	int count();
}
