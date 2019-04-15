package com.ycsf.persys.modalur.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.dao.SysUserMapper;
import com.ycsf.persys.modalur.sys.dao.SysUserRoleMapper;
import com.ycsf.persys.modalur.sys.entity.SysUser;
import com.ycsf.persys.modalur.sys.service.SysUserService;
import com.ycsf.persys.modalur.sys.vo.UserRoleVO;

@Component
public class SysUserServiceImpl implements SysUserService{
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Override
	public SysUser findByName(String name) {
		// TODO Auto-generated method stub
		return sysUserMapper.findByName(name);
	}
	@Transactional
	@Override
	public void addSysUser(UserRoleVO vo) {
		sysUserMapper.insert(vo.getUser());
		if(vo.getRoleIds()!=null) {
			for(int roleId:vo.getRoleIds()) {
				sysUserRoleMapper.insertCascadeInfo(new UserRoleVO(vo.getUser(),roleId,null));
			}
		}
		
		
		
	}
	@Transactional
	@Override
	public void deleteSysUser(int id) {
		sysUserMapper.delete(id);
		SysUser user = new SysUser();
		user.setUserId(id);
		sysUserRoleMapper.deleteCascadeInfo(new UserRoleVO(user,-1,null));
		
	}
	@Transactional
	@Override
	public void updateSysUser(UserRoleVO vo) {
		sysUserMapper.update(vo.getUser());
		
		sysUserRoleMapper.deleteCascadeInfo(new UserRoleVO(vo.getUser(),-1,null));
		if(vo.getRoleIds() != null) {
			for(int roleId:vo.getRoleIds()) {
				sysUserRoleMapper.insertCascadeInfo(new UserRoleVO(vo.getUser(),roleId,null));
			}
		}
		
	}
	@Override
	public SysUser getSysUserInfo(int id) {
		SysUser sysUser = sysUserMapper.findById(id);
		sysUser.getSysRoles();
		return sysUser;
	}
	@Override
	public List<SysUser> getAllSysUserInfo(PageInfo page) {
		// TODO Auto-generated method stub
		return sysUserMapper.findAll(page);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return sysUserMapper.count();
	}

}
