package com.ycsf.persys.config.shiro;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ycsf.persys.common.filter.PSFormAuthenticationFilter;
import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.dao.SysPermMapper;
import com.ycsf.persys.modalur.sys.entity.SysPerm;

//shiro的配置文件
@Configuration
public class ShiroConfig {
   
	@Autowired
	SysPermMapper sysPermMapper;

	//配置shiro的SecurityManager
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
		securityManager.setRealm(permSysRealm());
//		securityManager.setCacheManager(cacheManager());
//		securityManager.setSessionManager(sessionManager());
		return securityManager;
	}
	
	//配置shiro的过滤器
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		
		//修改过滤器的实现
		Map<String,Filter> filters = new LinkedHashMap<>();
		filters.put("authc", new PSFormAuthenticationFilter());
		shiroFilterFactoryBean.setFilters(filters);
		
//		Map<String,String> map = new LinkedHashMap<String,String>();
		//过滤器由上向下查找，一旦某个过滤器执行了，下面的过滤器将不再过滤
		//anon这个过滤器是表明任何用户(包括非认证用户)可访问资源
//		map.put("/static/**","anon");
		//authc这是一个过滤器，这个过滤器会拦截所有请求(/**)
		//authc表示用户必须认证(登录)了才可以访问资源
		
		
		Map<String,String> map = new LinkedHashMap<>();
		map.put("/webjars/**","anon");
		map.put("/images/*", "anon");
		map.put("/js/*", "anon");
		//从数据库中获取所有的权限信息
		int count = sysPermMapper.count();
		PageInfo page = new PageInfo();
		page.setSize(count);
		page.setStart(0);
		System.out.println(count);
		List<SysPerm> perms = sysPermMapper.findAll(page);
		System.out.println(perms);
		//将权限信息添加到filterChainDefinitionMap中
		for(SysPerm perm:perms) {
			map.put(perm.getUrl(), "perms["+perm.getPerms()+"]");
		}
		map.put("/logout", "logout");
		map.put("/**", "authc");
		
		System.out.println(map);
		//声明登录界面
		shiroFilterFactoryBean.setLoginUrl("/login");//向/login发请求，一定是有人登录了
		//声明登录成功
		shiroFilterFactoryBean.setSuccessUrl("/index");
		//声明没有权限界面
//		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		return shiroFilterFactoryBean;
	}
	
	//配置realm,以便实现认证和授权(实现login方法)
	@Bean
	public PermSysRealm permSysRealm() {
		return new PermSysRealm();
	}
	
	//配置支持shiro注解
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		System.out.println("advisor-------");
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
	
	
	//cacheManager
	@Bean
	public RedisManager redisManager() {
		RedisManager redisManager = new RedisManager();
		redisManager.setHost("127.0.0.1:6379");
		return redisManager;
	}
	
	@Bean
	public CacheManager cacheManager() {
		RedisCacheManager redisCacheManager = new RedisCacheManager();
		redisCacheManager.setRedisManager(redisManager());
		redisCacheManager.setExpire(60*60*24*7);
		return redisCacheManager;
	}
	
	//sessionManager
	@Bean
	public RedisSessionDAO redisSessionDao() {
		RedisSessionDAO redisSessionDao = new RedisSessionDAO();
		redisSessionDao.setRedisManager(redisManager());
		return redisSessionDao;
	}
	
	@Bean
	public SessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setSessionDAO(redisSessionDao());
		return sessionManager;
	}
}









