package com.ycsf.persys.modalur.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.entity.SysUser;

public interface SysUserMapper {
	SysUser findByName(String name);

	void delete(int id);

	void insert(SysUser user);

	void update(SysUser user);

	SysUser findById(int id);

	List<SysUser> findAll(PageInfo page);

	int count();
}
