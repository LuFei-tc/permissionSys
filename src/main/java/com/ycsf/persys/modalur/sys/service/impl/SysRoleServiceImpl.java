package com.ycsf.persys.modalur.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.dao.SysRoleMapper;
import com.ycsf.persys.modalur.sys.dao.SysRolePermMapper;
import com.ycsf.persys.modalur.sys.dao.SysUserRoleMapper;
import com.ycsf.persys.modalur.sys.entity.SysRole;
import com.ycsf.persys.modalur.sys.entity.SysUser;
import com.ycsf.persys.modalur.sys.service.SysRoleService;
import com.ycsf.persys.modalur.sys.vo.RolePermVO;
import com.ycsf.persys.modalur.sys.vo.UserRoleVO;

@Component
public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysRolePermMapper sysRolePermMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	//在添加role数据时会添加相应权限信息
	@Transactional
	@Override
	public void addSysRole(RolePermVO vo) {
		sysRoleMapper.insert(vo.getRole());
		for(int permId:vo.getPermIds()) {
			sysRolePermMapper.insertCascadeInfo(new RolePermVO(vo.getRole(),permId,null));
		}
	}

	@Transactional
	@Override
	public void deleteSysRole(int id) {
		SysRole role = new SysRole();
		role.setRoleId(id);
		sysRolePermMapper.deleteCascadeInfo(new RolePermVO(role,-1,null));
		SysUser user = new SysUser();
		user.setUserId(-1);
		sysUserRoleMapper.deleteCascadeInfo(new UserRoleVO(user,id,null));
		sysRoleMapper.delete(id);
		
	}

	//更新role数据时，可能更新对应的权限
	@Transactional
	@Override
	public void updateSysRole(RolePermVO vo) {
		sysRoleMapper.update(vo.getRole());
		//删除原有的所有权限
		sysRolePermMapper.deleteCascadeInfo(new RolePermVO(vo.getRole(),-1,null));
		//添加新的权限
		for(int permId:vo.getPermIds()) {
			sysRolePermMapper.insertCascadeInfo(new RolePermVO(vo.getRole(),permId,null));
		}
		
	}

	@Override
	public SysRole getSysRoleInfo(int id) {
		// TODO Auto-generated method stub
		return sysRoleMapper.findById(id);
	}

	@Override
	public List<SysRole> getAllSysRoleInfo(PageInfo page) {
		// TODO Auto-generated method stub
		return sysRoleMapper.findAll(page);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return sysRoleMapper.count();
	}

}
