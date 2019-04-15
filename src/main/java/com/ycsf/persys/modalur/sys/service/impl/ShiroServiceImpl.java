package com.ycsf.persys.modalur.sys.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.dao.SysPermMapper;
import com.ycsf.persys.modalur.sys.entity.SysPerm;
import com.ycsf.persys.modalur.sys.service.ShiroService;

@Component
public class ShiroServiceImpl implements ShiroService {

	@Autowired
	private SysPermMapper sysPermMapper;
	@Autowired
	private ShiroFilterFactoryBean shiroFilterFactoryBean;
	
	@Override
	public Map<String, String> loadFilterChainDefinitionMap() {
		Map<String,String> map = new LinkedHashMap<>();
		map.put("/webjars/**","anon");
		map.put("/images/*", "anon");
		map.put("/js/*", "anon");
		//从数据库中获取所有的权限信息
		int count = sysPermMapper.count();
		PageInfo page = new PageInfo();
		page.setSize(count);
		page.setStart(0);
		 
		
		List<SysPerm> perms = sysPermMapper.findAll(page);
		
		//将权限信息添加到filterChainDefinitionMap中
		for(SysPerm perm:perms) {
			map.put(perm.getUrl(), "perms["+perm.getPerms()+"]");
		}
		map.put("/logout", "logout");
		map.put("/**", "authc");
		return map;
	}

	@Override
	public void updatePermissions() {
		synchronized (shiroFilterFactoryBean) {
			//获取filterChainManager
			AbstractShiroFilter shiroFilter = null;
			try {
				shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PathMatchingFilterChainResolver resolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
		    DefaultFilterChainManager manager =  (DefaultFilterChainManager) resolver.getFilterChainManager();
		    
		    //将原链上的过滤器清除
		    manager.getFilterChains().clear();
		    shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
		    
		    //将数据库中权限数据添加到filterChain上
		    Map<String,String> map = loadFilterChainDefinitionMap();
		    shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		    
		    Set<Map.Entry<String,String>> entrys = map.entrySet();
		    for(Map.Entry<String, String> entry:entrys) {
		    	String chain = entry.getKey();
		    	String chainDefinition = entry.getValue();
		    	manager.createChain(chain, chainDefinition);
		    }
		}
		
	    
	   
	}

}
