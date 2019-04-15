package com.ycsf.persys.modalur.sys.entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class SysUser implements Serializable{
	private static final long serialVersionUID = 1L;
	private int userId;
	@Length(min=2,max=10,message="")
	private String username;
	private String password;
	private String salt;
	private String email;
	private String mobile;
	private int status;
	private SysUser createUser;
	private String createTime;
	private List<SysRole> sysRoles;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public SysUser getCreateUser() {
		return createUser;
	}
	public void setCreateUser(SysUser createUser) {
		this.createUser = createUser;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public List<SysRole> getSysRoles() {
		return sysRoles;
	}
	public void setSysRoles(List<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}
	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", email=" + email + ", mobile=" + mobile + ", status=" + status + ", createUser=" + createUser
				+ ", createTime=" + createTime + ", sysRoles=" + sysRoles + "]";
	}
	
	
}
