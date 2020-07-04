package com.aaa.controller;
import java.io.File;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.aaa.service.IUserService;
import com.aaa.service.impl.UserService;
import com.aaa.vo.User;
import com.util.Constants;


@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;
	
//登陆
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "user/login";
	}
	@RequestMapping("/login")
	@ResponseBody
	public ModelAndView login(User user,HttpSession session){
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("user",user);
		User users = userService.selectByUsernameAndPwd(user);
		if(users!=null){
			
		}else{
			mv.setViewName("../user/toLogin");
		}
		mv.setViewName("front/header");
		session.setAttribute("user", user);
		return mv;
	}
//	@RequestMapping("/reg")
//	public String reg(User user,HttpServletRequest request,@RequestParam("mf")MultipartFile mf){
//		System.out.println("++++++++");
//		try {   
//			File file=new File(mf.getOriginalFilename());
//			FileUtils.copyInputStreamToFile(mf.getInputStream(),file);
//			System.out.println(file.getAbsolutePath().toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "user/login";
//	}
	//增加
	@RequestMapping("/toReg")
	public String toReg(){
		return "user/reg";
	}
	@RequestMapping("/register")
	public String register(){
		return "user/reg";
	}
	@RequestMapping("/insertReg")
	public String insertReg(User user){
		userService.insertUser(user);
		return "redirect:/user/toLogin";
	}
	@RequestMapping("/toZhuXiao")
	public String toZhuXiao(HttpSession session){
		session.invalidate();
		return "redirect:/user/toLogin";
	}
	@RequestMapping("/insertLogin")
	public String insertLogin(User user, Model model, HttpSession session){
		ModelAndView mv=new ModelAndView();
		mv.addObject("user",user);
		User users = userService.selectByUsernameAndPwd(user);
		if(users!=null){
			model.addAttribute("username",users);
		}else{
			return "redirect:/user/toLogin";
		}
		session.setAttribute("user2", user.getUsername());
		return "redirect:/front/header";
	}
	@RequestMapping("/reg2")
	public String reg2(User user){
		int result=-1;
		result=userService.insertUser(user);
		return "user/toLogin";
	}

	@RequestMapping("/search")
	public String searchAll(Model model){
		List<User>userList=userService.search();
		model.addAttribute("size",userList.size());
		model.addAttribute("userList",userList);
		return "user/userList";
	}
	@RequestMapping("/{uid}/deleteUser")
	public String deleteUser(@PathVariable int uid){
		int result=userService.deleteUser(uid);
		return "redirect:/user/search";
	}
	@RequestMapping("/{uid}/toUpdate")
	public String toUpdate(@PathVariable int uid,Model model){
		//我们可以利用service进行查询
		User user=userService.searchUser(uid);
		model.addAttribute("user",user);//利用model来传递数据		
		return "user/updateUser";//页面
	}
	@RequestMapping("/{uid}/updateUser")
	public String updateUser(@PathVariable int uid,User user){
		user.setUid(uid);
		int result=userService.updateUser(user);
		System.out.println(user.getUsername());
		System.out.println(result);
		return "redirect:/user/search";
	}
}