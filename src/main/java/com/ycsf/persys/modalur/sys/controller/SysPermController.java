package com.ycsf.persys.modalur.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.entity.SysPerm;
import com.ycsf.persys.modalur.sys.service.ShiroService;
import com.ycsf.persys.modalur.sys.service.SysPermService;

@Controller
public class SysPermController {
	
	@Resource
	private SysPermService sysPermService;
	@Resource
	private ShiroService shiroService;
	
	@RequestMapping("/addSysPerm")
	public String addSysPerm(SysPerm perm) {
		sysPermService.addSysPerm(perm);
		shiroService.updatePermissions();
		return "redirect:sysPermList";
	}
	
	@RequestMapping("/deleteSysPerm")
	public String deleteSysPerm(int id) {
		sysPermService.deleteSysPerm(id);
		shiroService.updatePermissions();
		return "redirect:sysPermList";
	}
	
	@RequestMapping("/updateSysPerm")
	public String updateSysPerm(SysPerm perm) {
		sysPermService.updateSysPerm(perm);
		shiroService.updatePermissions();
		return "redirect:sysPermList";
	}
	
	@RequestMapping("/sysPermInfo")
	public @ResponseBody SysPerm getSysPermInfo(int id) {
		SysPerm sysPerm = sysPermService.getSysPermInfo(id);
		return sysPerm;
	}
	
	@RequestMapping("/sysPermJson")
	public @ResponseBody  List<SysPerm> getAllSysPermInfo(PageInfo page) {
		if(page.getCurrentPage() == 0) {
			page.setCurrentPage(1);
		}
		page.setSize(30);
		page.setTotalResult(sysPermService.count());
		List<SysPerm> sysPermList = sysPermService.getAllSysPermInfo(page);

		return sysPermList;
	}
	
	@RequestMapping("/sysPermList")
	public String getAllSysPermInfo(PageInfo page,Model model) {
		if(page.getCurrentPage() == 0) {
			page.setCurrentPage(1);
		}
		page.setSize(10);
		page.setTotalResult(sysPermService.count());
		List<SysPerm> sysPermList = sysPermService.getAllSysPermInfo(page);
		model.addAttribute("sysPermList", sysPermList);
		return "/sys/sysPermList";
	}
}
