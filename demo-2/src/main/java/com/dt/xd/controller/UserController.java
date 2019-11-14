package com.dt.xd.controller;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller		//声明控制器
public class UserController {
	@Resource
	UserService userService;
	@Resource
	E_CommerceService eCommerceService;
	@Resource
	MemberService memberService;
	
	
	@RequestMapping("/operator_login")
	public String operatorLogin() {
		return "operator_login";
	}

	
	@RequestMapping("/service_login")
	public String serviceLogin() {
		return "service_login";
	}
	
	@RequestMapping("/e-commerce_login")
	public String eCommerceLogin() {
		return "e-commerce_login";
	}
	
	@RequestMapping("/e-commerce_findpassword")
	public String userFindPassword() {
		return "e-commerce_findpassword";
	}
	
	@RequestMapping("/e-commerce_register")
	public ModelAndView userRegister() {
		return new ModelAndView("redirect:/findprovince");
	}
	
	@RequestMapping("/verification_code")
	public void loginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// 调用工具类生成的验证码和验证码图片
		        Map<String, Object> codeMap = ImgCodeUtil.generateCodeAndPic();
		        //System.out.println("codeMap==" + codeMap);
		        // 将四位数字的验证码保存到Session中
		        HttpSession session = req.getSession();
		        session.setAttribute("verificationcode", codeMap.get("code").toString());
		        //System.out.println(codeMap.get("code").toString());
		        // 禁止图像缓存。
		        resp.setHeader("Pragma", "no-cache");
		        resp.setHeader("Cache-Control", "no	-cache");
		        resp.setDateHeader("Expires", -1);

		        resp.setContentType("image/jpeg");

		        // 将图像输出到Servlet输出流中。
		        ServletOutputStream sos;
		        try {
		            sos = resp.getOutputStream();
		            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos); 
		            sos.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		         
	}
	
	@ResponseBody
	@RequestMapping("/userLoginIn")
	public Map<String,Object> userLoginIn(HttpServletRequest request) {
		// 获得session对象
		HttpSession session = request.getSession();
		String verificationcode = (String)session.getAttribute("verificationcode");
		String code = request.getParameter("code");
		//System.out.println("verificationcode==" + verificationcode +"\tcode==" +code);
		
		Map<String,Object> userMap = new HashMap<String,Object>();
		userMap.put("cellphone", request.getParameter("cellphone"));
		userMap.put("password", request.getParameter("password"));
		User user = userService.userLoginService(userMap);
		System.out.println(user);
		Map<String,Object> map = new HashMap<String,Object>();
		//System.out.println(user.getCellphone() + "\t" + user.getPassword());
		if(user==null) {
			map.put("message", "手机号或密码错误");
			map.put("sendcode", 0);
			//return new ModelAndView("redirect:/error1");
		}else if(user!=null && !verificationcode.equalsIgnoreCase(code)) {
			map.put("message", "验证码错误");
			map.put("sendcode", 0);
			//return new ModelAndView("redirect:/error1");
		}else {
			//map.put("username", user.getUserName());
			session.setAttribute("username", user.getId());
			
			session.setAttribute("cartnum", eCommerceService.countByMemberIdService(user.getId()));
			request.getSession().setAttribute("member", memberService.selectMemberById(user.getId()));
			map.put("sendcode", 1);
			//System.out.println(user.getCellphone());
		}
		return map;
	}
}