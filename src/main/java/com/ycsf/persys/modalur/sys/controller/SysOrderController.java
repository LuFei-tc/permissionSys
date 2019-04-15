package com.ycsf.persys.modalur.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycsf.persys.modalur.sys.entity.SysGood;
import com.ycsf.persys.modalur.sys.entity.SysOrder;
import com.ycsf.persys.modalur.sys.entity.SysUser;
import com.ycsf.persys.modalur.sys.service.SysGoodService;
import com.ycsf.persys.modalur.sys.service.SysOrderService;
import com.ycsf.persys.modalur.sys.service.SysUserService;

@Controller
public class SysOrderController {
	@Resource
	private SysOrderService sysOrderService;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysGoodService sysGoodService;

	
	
	@RequestMapping("/addSysOrder")
	public String addSysGood(SysOrder order ,Model model) {
		System.out.println("contrller:添加订单："+order);
		SysUser sysUser = sysUserService.getSysUserInfo(order.getUid());
		SysGood sysGood = sysGoodService.getSysGoodInfo(order.getGid());
		order.setUname(sysUser.getUsername());
		order.setGname(sysGood.getGoodTitle());
		order.setPrice(sysGood.getGoodPrice());
		order.setTotalPrice((order.getNum()*sysGood.getGoodPrice()));
		sysOrderService.addSysOrder(order);
		model.addAttribute("order",order);
		System.out.println("订单："+order);
		return "redirect:sysOrderList";
	}
	
	@RequestMapping("/deleteSysOrder")
	public String deleteSysOrder(int id) {
		sysOrderService.deleteSysOrder(id);
		return "redirect:sysOrderList";
	}
	
	@RequestMapping("/findSysOrderById")
	public @ResponseBody SysOrder findSysOrderById(int id,Model model) {
		SysOrder sysOrder = sysOrderService.findSysOrderById(id);
		System.out.println("根据idh找的订单："+sysOrder);
		model.addAttribute("sysOrder",sysOrder);
		return sysOrder;
	}
	
	//查询@RequestParam("uname") String uname
	@RequestMapping("/searchSysOrder")
	public @ResponseBody List<SysOrder> searchSysOrder(@RequestParam("uname") String uname) {
		System.out.println("查询的买家昵称："+uname);
		List<SysOrder> sysOrderList = sysOrderService.findAllByUname(uname);
		//model.addAttribute("sysOrderList", sysOrderList);
		return sysOrderList;
	}
	
	@RequestMapping("/sysOrderList")
	public String getAllSysOrderInfo(Model model) {
		List<SysOrder> sysOrderList = sysOrderService.findAllSysOrder();
		model.addAttribute("sysOrderList", sysOrderList);
		
		return "/sys/sysOrderList";
	}
}
