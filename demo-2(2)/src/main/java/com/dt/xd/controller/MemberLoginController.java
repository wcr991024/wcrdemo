package com.dt.xd.controller;

import com.dt.xd.service.CartService1;
import com.dt.xd.service.MemberService1;
import com.dt.xd.util.ImgCodeUtil;
import com.dt.xd.util.MD5Util;
import com.dt.xd.util.UniqueId;
import model.User.Member1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller // 声明控制器
public class MemberLoginController {
	@Resource
	CartService1 cartService;
	@Resource
	MemberService1 memberService;

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
		return new ModelAndView("redirect:/selectprovince");
	}

	@RequestMapping("/verification_code")
	public void verification_code(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 调用工具类生成的验证码和验证码图片
		Map<String, Object> codeMap = ImgCodeUtil.generateCodeAndPic();
		// System.out.println("codeMap==" + codeMap);
		// 将四位数字的验证码保存到Session中
		HttpSession session = req.getSession();
		session.setAttribute("verificationcode", codeMap.get("code").toString());
		// System.out.println(codeMap.get("code").toString());
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
	public Map<String, Object> userLoginIn(HttpServletRequest request) {
		// 获得session对象
		HttpSession session = request.getSession();
		String verificationcode = (String) session.getAttribute("verificationcode");
		String code = request.getParameter("code");
		Map<String, Object> memberMap = new HashMap<String, Object>();
		memberMap.put("cellphone", request.getParameter("cellphone"));
		memberMap.put("password", MD5Util.getMD5(request.getParameter("password")));
		Member1 member = memberService.memberLogin(memberMap);
		Map<String, Object> map = new HashMap<String, Object>();
		if (member == null) {
			map.put("message", "手机号或密码错误");
			map.put("sendcode", 0);
		} else if (member != null && !verificationcode.equalsIgnoreCase(code)) {
			map.put("message", "验证码错误");
			map.put("sendcode", 0);
		} else {
			session.setAttribute("username", member.getName());
			session.setAttribute("memberId", member.getId());
			session.setAttribute("cartnum", cartService.countByMemberIdService(member.getId()));
			session.setAttribute("member", memberService.selectMemberById(member.getId()));
			map.put("sendcode", 1);
		}
		return map;
	}


	@ResponseBody
	@RequestMapping(value = "/memberRegister", method = RequestMethod.POST)
	public Map<String, Object> regist(HttpServletRequest request) {
		String code = request.getParameter("code");
		String membername = request.getParameter("membername");
		String cellphone = request.getParameter("cellphone");
		String password = request.getParameter("password");
		String region = request.getParameter("region");
		String verificationcode = (String) request.getSession().getAttribute("verificationcode");
		//System.out.println(code + cellphone + password + region + verificationcode);
		int sendcode = -1;
		Member1 insertMember = new Member1();
		insertMember.setId(UniqueId.getUniqueId());
		insertMember.setCellphone(cellphone);
		insertMember.setName(membername);
		insertMember.setPassword(MD5Util.getMD5(password));
		insertMember.setRegion(region);
		insertMember.setStatus(1);
		insertMember.setRegisterTime(new Date());
		Map<String, Object> map = new HashMap<String, Object>();
		if (cellphone.length() != 11) {
			sendcode = 2;
			map.put("sendcode", sendcode);
		} else {
			if (memberService.selectByCellPhone(cellphone) != null) {
				sendcode = 3;
				map.put("sendcode", sendcode);
			} else {
				if (verificationcode.toUpperCase().equals(code.toUpperCase())) {
					sendcode = memberService.insertSelective(insertMember);
					map.put("sendcode", sendcode);
				} else {
					sendcode = 4;
					map.put("sendcode", sendcode);
				}
			}
		}
		return map;
	}
	
	@RequestMapping("/findMemberPassword")
	@ResponseBody
	public Map<String, Object> changMemberPassword(HttpServletRequest request,String cellphone,String  newpassword1,String code) {
		//System.out.println(id);
		Map<String, Object> map = new HashMap<String, Object>();
		int sendcode = 0;
	
		Member1 member = memberService.selectByCellPhone(cellphone);
		String verificationcode = (String) request.getSession().getAttribute("verificationcode");
		if(verificationcode.toUpperCase().equals(code.toUpperCase())) {
			if(member != null) {
				member.setPassword(MD5Util.getMD5(newpassword1));
				sendcode = memberService.updateMemberByExample(member);
			}else {
				sendcode = 2;	//用户不存在
			}
		}else {
			sendcode = 3;	//验证码错误
		}
		
		System.out.println(sendcode);
		map.put("sendcode", sendcode);
		return map;
	}
}
