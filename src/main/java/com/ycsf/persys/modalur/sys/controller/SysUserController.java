package com.ycsf.persys.modalur.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.entity.SysUser;
import com.ycsf.persys.modalur.sys.service.SysUserService;
import com.ycsf.persys.modalur.sys.vo.RolePermVO;
import com.ycsf.persys.modalur.sys.vo.UserRoleVO;

@Controller
public class SysUserController {
	
	@Resource
	private SysUserService sysUserService;
	
	@RequestMapping("/addSysUser")
	public String addSysUser(@Validated UserRoleVO vo) {
		sysUserService.addSysUser(vo);
		return "redirect:sysUserList";
	}
	
	@RequestMapping("/deleteSysUser")
	public String deleteSysUser(int id) {
		sysUserService.deleteSysUser(id);
		return "redirect:sysUserList";
	}
	
	@RequestMapping("/updateSysUser")
	public String updateSysUser(UserRoleVO vo) {
		sysUserService.updateSysUser(vo);
		return "redirect:sysUserList";
	}
	
	@RequestMapping("/sysUserInfo")
	public @ResponseBody SysUser getSysUserInfo(int id) {
		SysUser sysUser = sysUserService.getSysUserInfo(id);
		return sysUser;
	}
	
	@RequestMapping("/sysUserList")
	public String getAllSysUserInfo(PageInfo page,Model model) {
		 
		if(page.getCurrentPage() == 0) {
			page.setCurrentPage(1);
		}
		page.setSize(5);
		page.setTotalResult(sysUserService.count());
		List<SysUser> sysUserList = sysUserService.getAllSysUserInfo(page);
		model.addAttribute("sysUserList", sysUserList);
		model.addAttribute("page", page);
		return "/sys/sysUserList";
	}
}
