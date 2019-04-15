package com.ycsf.persys.modalur.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.entity.SysRole;
import com.ycsf.persys.modalur.sys.service.SysRoleService;
import com.ycsf.persys.modalur.sys.vo.RolePermVO;

@Controller
public class SysRoleController {
	
	@Resource
	private SysRoleService sysRoleService;
	
	@RequestMapping("/addSysRole")
	public String addSysRole(RolePermVO vo) {
		sysRoleService.addSysRole(vo);
		return "redirect:sysRoleList";
	}
	
	@RequestMapping("/deleteSysRole")
	public String deleteSysRole(int id) {
		sysRoleService.deleteSysRole(id);
		return "redirect:sysRoleList";
	}
	
	@RequestMapping("/updateSysRole")
	public String updateSysRole(RolePermVO vo) {
		sysRoleService.updateSysRole(vo);
		return "redirect:sysRoleList";
	}
	
	@RequestMapping("/sysRoleInfo")
	public @ResponseBody SysRole getSysRoleInfo(int id) {
		SysRole sysRole = sysRoleService.getSysRoleInfo(id);
		return sysRole;
	}
	
	@RequestMapping("/sysRoleJson")
	public @ResponseBody List<SysRole> getAllSysRoleJson(PageInfo page){
		if(page.getCurrentPage() == 0) {
			page.setCurrentPage(1);
		}
		page.setSize(10);
		page.setTotalResult(sysRoleService.count());
		List<SysRole> sysRoleList = sysRoleService.getAllSysRoleInfo(page);
		return sysRoleList;
	}
	
	@RequestMapping("/sysRoleList")
	public String getAllSysRoleInfo(PageInfo page,Model model) {
		if(page.getCurrentPage() == 0) {
			page.setCurrentPage(1);
		}
		page.setSize(10);
		page.setTotalResult(sysRoleService.count());
		List<SysRole> sysRoleList = sysRoleService.getAllSysRoleInfo(page);
		model.addAttribute("sysRoleList", sysRoleList);
		return "/sys/sysRoleList";
	}
}
