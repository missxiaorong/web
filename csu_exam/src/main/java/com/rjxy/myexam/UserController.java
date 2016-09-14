package com.rjxy.myexam;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rjxy.dao.UserDao;
import com.rjxy.entity.User;
import com.rjxy.util.MybatisUtil;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static SqlSession session;
	private static UserDao userDao;
	static{
		session=MybatisUtil.openSession();
		userDao=session.getMapper(UserDao.class);
	}
	/*
	 *	用户登录
	 * */
	@RequestMapping(value="/login.home",method=RequestMethod.POST)
	public String userLogin(@RequestParam("login") String login,@RequestParam("pw") String pw,Model model,HttpSession session){
//		SqlSession session = MybatisUtil.openSession();
//		UserDao userDao = session.getMapper(UserDao.class);
		User u = userDao.findUserByLogin(login);
		System.out.println(u);
		if(u!=null){
			String hint = "";
			if(u.getPasswd().equals(pw)){
				switch(u.getType()){
				case 1:
					hint = "欢迎你,用户管理员!";
					break;
				case 2:
					hint = "欢迎你,题库管理员!";
					break;
				case 3:
					hint = "欢迎你,题库使用者!";
					break;
				default:
					hint = "欢迎你!";
					break;
				}
				model.addAttribute("hint", hint);
				session.setAttribute("user", u.getLogin());
				return "ok";
			}
			else{
				//错误提示
				model.addAttribute("hint", "用户密码错误");
				return "error";
			}
		}
		//错误提示
		model.addAttribute("hint", "没有此用户");
		return "error";
	}

	/*
	 * 	用户注册
	 * */
	@RequestMapping(value="/register.home",method=RequestMethod.POST)
	public String userRegister(@RequestParam("login") String login,@RequestParam("name") String name,@RequestParam("pw") String passwd,Model model){
		User u = userDao.findUserByLogin(login);
		if(u!=null){//如果已经被注册
			//错误提示
			model.addAttribute("hint", "该用户已被注册");
			return "error";
		}
		User user = new User();
		user.setLogin(login);
		user.setName(name);
		user.setPasswd(passwd);
		int i = 0;
		try{
			i = userDao.addUser(user);
			session.commit();
		}
		catch(Exception e){
			model.addAttribute("hint", "注册失败1");
			return "error";
		}
		if(i>0){
			model.addAttribute("hint", "注册成功");
			return "ok";
		}
		else{
			model.addAttribute("hint", "注册失败2");
			return "error";
		}
	}

	/*
	 * 	异步检查改用户是否被注册
	 * */
	@RequestMapping(value="registerCheckAjax.do",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> test(HttpServletRequest request,HttpServletResponse response){
		String userRegister = request.getParameter("userRegister");
		Map<String,Object> m = new HashMap();
		User u = userDao.findUserByLogin(userRegister);
		if(u==null){//如果该用户名没有被注册
			m.put("msg", "1");
		}
		else{
			m.put("msg", "0");
		}
		return m;
	}
}
