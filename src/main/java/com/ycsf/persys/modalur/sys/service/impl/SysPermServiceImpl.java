package com.ycsf.persys.modalur.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.dao.SysPermMapper;
import com.ycsf.persys.modalur.sys.dao.SysRolePermMapper;
import com.ycsf.persys.modalur.sys.entity.SysPerm;
import com.ycsf.persys.modalur.sys.entity.SysRole;
import com.ycsf.persys.modalur.sys.service.SysPermService;
import com.ycsf.persys.modalur.sys.vo.RolePermVO;

@Component
public class SysPermServiceImpl implements SysPermService{
    
	@Autowired
	private SysPermMapper sysPermMapper;
	@Autowired
	private SysRolePermMapper sysRolePermMapper;
	
	@Transactional
	@Override
	public void addSysPerm(SysPerm perm) {
		sysPermMapper.insert(perm);
	}
	
	@Transactional
	@Override
	public void deleteSysPerm(int id) {
		sysPermMapper.delete(id);
		SysRole role = new SysRole();
		role.setRoleId(-1);
		sysRolePermMapper.deleteCascadeInfo(new RolePermVO(role,id,null));
	}
	
	@Transactional
	@Override
	public void updateSysPerm(SysPerm perm) {
		sysPermMapper.update(perm);
	}

	@Override
	public SysPerm getSysPermInfo(int id) {
		return sysPermMapper.findById(id);
	}

	@Override
	public List<SysPerm> getAllSysPermInfo(PageInfo page) {
		return sysPermMapper.findAll(page);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return sysPermMapper.count();
	}

}
