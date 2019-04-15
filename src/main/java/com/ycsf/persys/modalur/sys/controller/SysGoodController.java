package com.ycsf.persys.modalur.sys.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycsf.persys.common.utils.PageInfo;
import com.ycsf.persys.modalur.sys.entity.SysGood;
import com.ycsf.persys.modalur.sys.service.SysGoodService;
import com.ycsf.persys.modalur.sys.vo.UserRoleVO;


@Controller
public class SysGoodController {

	@Resource
	private SysGoodService sysGoodService;
	
	
	@RequestMapping("/addSysGood")
	public String addSysGood(SysGood good) {
		System.out.println("contrller:添加商品："+good);
		sysGoodService.addSysGood(good);
		return "redirect:sysGoodList";
	}
	
	@RequestMapping("/deleteSysGood")
	public String deleteSysGood(int id) {
		System.out.println("controller:删除商品的ID:"+id);
		sysGoodService.deleteSysGood(id);
		return "redirect:sysGoodList";
	}
	
	@RequestMapping("/sysGoodInfo")
	public @ResponseBody SysGood getSysGoodInfo(int id) {
		SysGood sysGood = sysGoodService.getSysGoodInfo(id);
		System.out.println("contrller:更新商品："+sysGood);
		return sysGood;
	}
	
	
	//查看详情
	@RequestMapping("/sysGoodAllInfo")
	public String getSysGoodAllInfo(int id,Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		SysGood sysGood = sysGoodService.getSysGoodInfo(id);
		HttpSession session = request.getSession();
		 session.setAttribute("sysGood",sysGood);
//		System.out.println("根据id查询出："+sysGood);
//		model.addAttribute("sysGood",sysGood);
//		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success");
//		requestDispatcher.forward(request,response);
//		return "/index";
		model.addAttribute("sysGood",sysGood);
		return "/sys/success";
	}
	

//	@RequestMapping("/success")
//	public String success(int id,HttpServletRequest httpRequest,Model model) {
//		return "success";
//	}
	
	
	@RequestMapping("/updateSysGood")
	public String updateSysUser(SysGood good) {
		sysGoodService.updateSysGood(good);
		return "redirect:sysGoodList";
	}
	
	@RequestMapping(value="/searchSysGood",method = RequestMethod.POST)
	public String searchGoodInfo(HttpServletRequest httpRequest,Model model) {
		String goodName = httpRequest.getParameter("goodName");
		int maxPrice = Integer.parseInt(httpRequest.getParameter("maxPrice"));
		int minPrice = Integer.parseInt(httpRequest.getParameter("minPrice"));
		System.out.println(goodName +","+ maxPrice +"," + minPrice);

		List<SysGood> sysGoodList = sysGoodService.searchSysGood(goodName,maxPrice,minPrice);
		for(SysGood sysGood : sysGoodList) {
			System.out.println(sysGood.getGoodTitle()+","+sysGood.getGoodPrice());
		}
		 HttpSession session = httpRequest.getSession();  
		 session.setAttribute("sysGoodList",sysGoodList);
		model.addAttribute("sysGoodList",sysGoodList);
		return "/sysSearchGoodList";
	}
	
	
	@RequestMapping("/sysGoodList")
	public String getAllSysGoodInfo(PageInfo page,Model model) {
		if(page.getCurrentPage() == 0) {
			page.setCurrentPage(1);
		}
		page.setSize(6);
		page.setTotalResult(sysGoodService.count());
		List<SysGood> sysGoodList = sysGoodService.getAllSysGoodInfo(page);
		model.addAttribute("sysGoodList",sysGoodList);
		model.addAttribute("page",page);
		return "/sys/sysGoodList";
		
	}
}
