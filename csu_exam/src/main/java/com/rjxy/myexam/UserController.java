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
	 *	�û���¼
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
					hint = "��ӭ��,�û�����Ա!";
					break;
				case 2:
					hint = "��ӭ��,������Ա!";
					break;
				case 3:
					hint = "��ӭ��,���ʹ����!";
					break;
				default:
					hint = "��ӭ��!";
					break;
				}
				model.addAttribute("hint", hint);
				session.setAttribute("user", u.getLogin());
				return "ok";
			}
			else{
				//������ʾ
				model.addAttribute("hint", "�û��������");
				return "error";
			}
		}
		//������ʾ
		model.addAttribute("hint", "û�д��û�");
		return "error";
	}

	/*
	 * 	�û�ע��
	 * */
	@RequestMapping(value="/register.home",method=RequestMethod.POST)
	public String userRegister(@RequestParam("login") String login,@RequestParam("name") String name,@RequestParam("pw") String passwd,Model model){
		User u = userDao.findUserByLogin(login);
		if(u!=null){//����Ѿ���ע��
			//������ʾ
			model.addAttribute("hint", "���û��ѱ�ע��");
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
			model.addAttribute("hint", "ע��ʧ��1");
			return "error";
		}
		if(i>0){
			model.addAttribute("hint", "ע��ɹ�");
			return "ok";
		}
		else{
			model.addAttribute("hint", "ע��ʧ��2");
			return "error";
		}
	}

	/*
	 * 	�첽�����û��Ƿ�ע��
	 * */
	@RequestMapping(value="registerCheckAjax.do",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> test(HttpServletRequest request,HttpServletResponse response){
		String userRegister = request.getParameter("userRegister");
		Map<String,Object> m = new HashMap();
		User u = userDao.findUserByLogin(userRegister);
		if(u==null){//������û���û�б�ע��
			m.put("msg", "1");
		}
		else{
			m.put("msg", "0");
		}
		return m;
	}
}
