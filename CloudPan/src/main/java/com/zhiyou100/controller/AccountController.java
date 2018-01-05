package com.zhiyou100.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou100.entity.AccountDO;
import com.zhiyou100.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService service;
	@RequestMapping(value ="/login",method=RequestMethod.POST)
	public String myMethod(HttpServletRequest request,
	            HttpServletResponse response, 
	       String username,String password,ModelMap modelMap) throws Exception {
	        username = new String(username.getBytes("iso8859-1"),"UTF-8");
	        System.out.println(username+":"+password);
	        List<AccountDO> listAccountByEmail = service.listAccountByEmail(username);
	       String getEmail=null;
	       String getPassword =null;
	       int getId = 0;
	       for (AccountDO accountDO : listAccountByEmail) {
	    	   getEmail =accountDO.getEmail();
	    	   getPassword = accountDO.getPassword();
	    	   getId=accountDO.getId();
	       }
	       System.out.println(getId+"****"+username+"******"+getEmail);
	       request.setAttribute("getId", getId);
	       if (!username.equals(getEmail)) {
				System.out.println("账户名不存在");
				return "forward:/login.jsp";
			}
		  if (!password.equals(getPassword)){
				System.out.println("密码错误");
				return "forward:/login.jsp";
			 }
				return "forward:/WEB-INF/jsp/home.jsp";
	    }
	
}
