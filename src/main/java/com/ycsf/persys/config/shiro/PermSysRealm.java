package com.ycsf.persys.config.shiro;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.ycsf.persys.modalur.sys.entity.SysPerm;
import com.ycsf.persys.modalur.sys.entity.SysRole;
import com.ycsf.persys.modalur.sys.entity.SysUser;
import com.ycsf.persys.modalur.sys.service.SysUserService;

public class PermSysRealm extends AuthorizingRealm{
    
	@Resource
	private SysUserService sysUserService;
	//实现授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		System.out.println("doGetAuthorizationInfo");
		SysUser sysUser = (SysUser)principals.getPrimaryPrincipal();
		List<SysRole> sysRoles = sysUser.getSysRoles();
		for(SysRole role:sysRoles) {
			info.addRole(role.getRoleName());
			List<SysPerm> sysPerms = role.getSysPerms();
			for(SysPerm perm:sysPerms) {
				info.addStringPermission(perm.getPerms());
			}
		}
		return info;
	}

	//实现认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("doGetAuthenticationInfo");
		//用户输入
		UsernamePasswordToken uptoken = (UsernamePasswordToken) token;
		//获取数据库中数据
		SysUser sysUser = sysUserService.findByName(uptoken.getUsername());
//		String principal = sysUser.getUsername();//数据库的名字
		String credentials = sysUser.getPassword();//数据库中密码
		String realmName = getName();
		//认证信息就是用户在数据库中的数据，参数中的token就是用户输入的信息，就是比较这个两个对象
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysUser, credentials, realmName);
		return info;
	}
}
