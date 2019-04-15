package com.ycsf.persys.modalur.sys.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class SysRole {
	private int roleId;
	private String roleName;
	private String remark;
	private SysUser createUser;
	private Date createTime;
	private List<SysPerm> sysPerms;
	private List<SysUser> sysUsers;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public SysUser getCreateUser() {
		return createUser;
	}
	public void setCreateUser(SysUser createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<SysPerm> getSysPerms() {
		return sysPerms;
	}
	public void setSysPerms(List<SysPerm> sysPerms) {
		this.sysPerms = sysPerms;
	}
	public List<SysUser> getSysUsers() {
		return sysUsers;
	}
	public void setSysUsers(List<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}
	@Override 
	public String toString() {
		return "SysRole [roleId=" + roleId + ", roleName=" + roleName + ", remark=" + remark + ", createUser="
				+ createUser + ", createTime=" + createTime + ", sysPerms=" + sysPerms + ", sysUsers=" + sysUsers + "]";
	}
	
	
}
