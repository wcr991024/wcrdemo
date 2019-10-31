package com.dt.cn.controller.sysUser;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dt.cn.model.sysUser.SysUser;
import com.dt.cn.service.SysUserService;

// 通过注解匹配路径
@Controller // 声明控制层
@RequestMapping("/sysuser")

public class SystemUserController {
	// 相当于new了一个类
	@Resource
	SysUserService sysUserService;

	/**
	 * 
	 * @param 显示用户信息
	 * @param sysid  查找
	 * @return
	 * 
	 *         map.put 函数 , 放入 userlist 表 ,读取数据 。
	 * 
	 */
	// 根据路径处理对应的信息
	@RequestMapping("/sysuserlist")
	public String getSystemUserByld(Map<String, Object> map,
			@RequestParam(value = "xid", defaultValue = "2", required = false) Integer sysid) {

		// 调用SysUserServiceImpl 内部的getSystemUserByld实现方法
		List<SysUser> sysUserList = sysUserService.getSystemUserById(sysid);
		map.put("sysUserList", sysUserList);
		// 返回重定向的页面
		return "userlist";
	}

	/**
	 * 插入
	 * 
	 * @return 成功：跳转 userlist 页面 ;失败：跳转 error 页面。
	 * 
	 */
	@RequestMapping("/insert")
	public String insert(Map<String, Object> map, SysUser sysUser) {
		int i = sysUserService.insert(sysUser);
		if (i == 1)

			return "userlist";
		else
			return "error";
	}

	/**
	 * 删除：ID
	 * 
	 * @return 成功：success;失败：delete.html
	 */
	@RequestMapping("/delete")
	public String deleteByPrimaryKey(@RequestParam(defaultValue = "0", required = false) Integer id) {
		int i = sysUserService.deleteByPrimaryKey(id);
		if (i == 1)
			return "success";
		else
			return "redirect:../delete.html";

	}

	@RequestMapping("/hello")
	public String hello(Map<String, Object> map, Integer sysid) {

		List<SysUser> sysUserList = sysUserService.getSystemUserById(sysid);
		map.put("sysUserList", sysUserList);
		return "userlist";
	}

	/**
	 * 更新：
	 * 
	 * @param sysUser
	 * @return 成功：updatesuccess ; 失败：update.html
	 * 
	 */

	@RequestMapping("/update")
	public String update(SysUser sysUser) {
		int i = sysUserService.updateByPrimaryKey(sysUser);

		if (i == 1)
			return "updatesuccess";
		else
			return "redirect:../update.html";
	}

	@ResponseBody
	@RequestMapping("/updateQ")
	public Map<String, Object> updateQ(Integer id) // Integer 封装数据类型 ; Int 基本数据类型
	{
		SysUser sysUser = sysUserService.selectByPrimaryKey(id);
		System.out.println("sysid=:" + sysUser.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sysUser", sysUser);
		return map;
	}

	/**
	 * 登录： ID，username，password.
	 * 
	 * @return 成功：loginsuccess;失败：index,error.
	 */
	@RequestMapping("/selectSysUser")
	public String selectSysUser(String username, String password) {
		Map<String, String> map = new HashMap<String, String>();
		// trim() 去掉字符串空格
		map.put("username", username.trim());
		map.put("password", password.trim());
		SysUser sysUser = sysUserService.selectSysUser(map);
		if (sysUser != null)
			return "loginsuccess";
		else
			return "index";
	}

	/**
	 * 
	 * 分页查询 map //想页面传参 pageStart 为limit函数，设初始值
	 * 
	 * @param pageCount
	 */
	@RequestMapping("/fenye")
	public String fenYe(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") int pageSize, @RequestParam(defaultValue = "") String username)
	// 参数要有初始值 =0 不然报错 ，有@RequestParam 不会报错
	{
		List<SysUser> sysUserList = sysUserService.selectByExample(pageStart, pageSize, username);
		// long count=sysUserService.getCount();

		long count = 0;

		map.put("sysUserList", sysUserList);
		map.put("pageStart", pageStart);
		map.put("count", count);
		map.put("pageSize", pageSize);
		map.put("username", username);
		return "userlist(1)";
	}

	// 接收页面信息传给业务层，并且把相应的参数传回
	@RequestMapping("/fenyelike")
	public String fenYeLike(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") int pageSize, @RequestParam(defaultValue = "") String username) {
		List<SysUser> sysUserList = sysUserService.selectByName(pageStart, pageSize, username);
		// long count=sysUserService.getCount();

		long pageCount = 0;
		if (username.trim().equals("") || username.trim() == null)
			pageCount = sysUserService.getCount();
		else
			pageCount = sysUserService.getCount(username);
		// 向页面传参
		map.put("pageCount", pageCount);
		map.put("sysUserList", sysUserList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("username", username);
		System.out.println(sysUserList);
		return "userlist(1)";
	}

	@RequestMapping("/loadimg")
	public String loadImg() {
		return "upfile";
	}

	@RequestMapping("/upfile")
	public String saveUserImg(MultipartFile file, @RequestParam(defaultValue = "5") Integer id) {
		System.out.println("id=:" + id);
		Map<Object, Object> result = new HashMap<Object, Object>();
		try {
			// 获取客户端传图图片的输入流
			InputStream ins = file.getInputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			// 字节输出流
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			while ((len = ins.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			bos.flush();
//toByteArray()把图片转成二进制
			byte data[] = bos.toByteArray();
			//
			SysUser user = new SysUser();
			user.setId(id);
			user.setImg(data);
			sysUserService.updateImg(user);

		} catch (Exception e) {
			// 引发异常，制定跳转页
			return "error";
		}

		return "index";

	}
	@RequestMapping(value = "/headImg", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg( Integer id) throws Exception{

		byte[] imageContent ;
		
		SysUser sysUser=sysUserService.selectByPrimaryKey(id);
        
		imageContent = sysUser.getImg();
			
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}

}
