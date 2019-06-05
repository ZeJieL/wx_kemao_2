package org.lzjay.weixin.menu.controller;

import org.lzjay.weixin.menu.domain.SelfMenu;
import org.lzjay.weixin.menu.service.SelfMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/kemao_2/menu")
public class SelfMenuController {

	@Autowired
	private SelfMenuService menuService;

	@GetMapping
	public ModelAndView index() {
		return new ModelAndView("/WEB-INF/views/kemao_2/menu/index.jsp");
	}
	@GetMapping(produces = "application/json") 
	@ResponseBody
	public SelfMenu data() {
		return menuService.getMenu();
	}
	@PostMapping
	@ResponseBody
	public String save(@RequestBody SelfMenu selfMenu) {
		this.menuService.save(selfMenu);
		return "保存成功";
	}
}