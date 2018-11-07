package com.literature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.literature.common.bean.Msg;
import com.literature.entity.Emp;
import com.literature.service.DeptService;
import com.literature.service.EmpService;

@Controller
@RequestMapping(value="/")
public class IndexController {

	@Autowired
	private EmpService empService;
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody Emp get(Long id) {
		Emp emp=empService.getById(id);
		return emp;
	}
	
	@RequestMapping(value="/getEmpByPage",method=RequestMethod.GET)
	public String getEmpByPage(@RequestParam(value="pageNum",defaultValue="1")int pageNum,@RequestParam(value="pageSize",defaultValue="1")int pageSize,Model model){
		//传入页码和页面大小
		IPage<Emp> page=new Page<>(pageNum, pageSize);
		IPage<Emp> pageInfo=empService.page(page, null);
		model.addAttribute("pageInfo",pageInfo);
		return "listEmp";
	}
	
	@RequestMapping(value="/getMsg",method=RequestMethod.GET)
	public @ResponseBody Msg getMsg(@RequestParam(value="pageNum",defaultValue="1")int pageNum,@RequestParam(value="pageSize",defaultValue="1")int pageSize) {

		IPage<Emp> page=new Page<>(pageNum, pageSize);
		IPage<Emp> pageInfo=empService.page(page, null);
		return Msg.success().add("pageInfo",pageInfo);
	}
	
	@RequestMapping(value="/manyTableSelect",method=RequestMethod.GET)
	public @ResponseBody Msg manyTableSelect(@RequestParam(value="pageNum",defaultValue="1")int pageNum,@RequestParam(value="pageSize",defaultValue="1")int pageSize) {
		Emp emp=empService.getWithDept((long)2);
		IPage<Emp> page=new Page<>(pageNum, pageSize);
		IPage<Emp> pageInfo=empService.getByDeptIdWithDept(page,(long)3);
		return Msg.success().add("emp",emp).add("pageInfo",pageInfo);
	}
	
	@RequestMapping(value="/conditionSelect",method=RequestMethod.GET)
	public @ResponseBody Msg conditionSelect(@RequestParam(value="pageNum",defaultValue="1")int pageNum,@RequestParam(value="pageSize",defaultValue="1")int pageSize) {
		IPage<Emp> page=new Page<>(pageNum, pageSize);
		IPage<Emp> pageInfo=empService.page(page, new QueryWrapper<Emp>().eq("dept_id", 3));
		return Msg.success().add("pageInfo",pageInfo);
	}
}
