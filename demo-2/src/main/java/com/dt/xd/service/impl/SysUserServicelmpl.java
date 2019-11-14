package com.dt.cn.service.lmpl;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.cn.dao.mapper.SysUserMapper;
import com.dt.cn.model.sysUser.SysUser;
import com.dt.cn.model.sysUser.SysUserExample;

import com.dt.cn.service.SysUserService;

@Service
 // 声明服务层
public class SysUserServicelmpl implements SysUserService {
	// 层与层用接口交互
	@Resource // 对象初始化 一般在业务层访问dao
	SysUserMapper sysUserMapper;

	public List<SysUser> getSystemUserById(Integer id) {
		// 通过数据库查询系统用户
		System.out.println("查询用户" + id);
		// 新建查询条件对象
		SysUserExample sysUserExample = new SysUserExample();
		// 创建具体的条件实例
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		// 设置具体的条件
		criteria.andIdEqualTo(id);
		// 执行查询并返回
		return sysUserMapper.selectByExample(sysUserExample, null);
	}

	@Override
	public int insert(SysUser record) {

		return sysUserMapper.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		List<SysUser> userList = getSystemUserById(id);
		int i = 0;
		if (userList.size() != 0) {
			i = sysUserMapper.deleteByPrimaryKey(id);
		}
		return i;
	}

	@Override
	public SysUser selectByPrimaryKey(Integer id) {

		return sysUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(SysUser record) {

		return sysUserMapper.updateByPrimaryKey(record);
	}

	@Override
	public SysUser selectSysUser(Map map) {

		return sysUserMapper.selectSysUser(map);
	}

	/**
	 * 分页查询
	 * 
	 */

	@Override
	public List<SysUser> selectByExample(int pageStart,int pageSize,String username) {
		// 对象初始化
		SysUserExample sysUserExample = new SysUserExample();
		// 去掉重复记录
		sysUserExample.setDistinct(true);
		// 设置起始位置
		sysUserExample.setPageStart(pageStart);
		// 设置页面大小
		sysUserExample.setPageSize(pageSize);
		return sysUserMapper.selectByExample(sysUserExample, null);
	}

	/**
	 * 获取总记录数
	 * 
	 */
	@Override
	public long getCount() {
		// countbyExample的参数是SysuserExample类型，鼻祖初始化一个SysUserExample的对象
		// 局部变量必须初始化
		SysUserExample sysUserExample = new SysUserExample();

		return sysUserMapper.countByExample(sysUserExample);
	}

	

	@Override
	public int getCount(String username) {

		return sysUserMapper.getCount(username);
	}

	//先把参数传到SysUserExample，再到映射器
	@Override
	public List<SysUser> selectByName(int pageStart, int pageSize, String username) {
		
		SysUserExample sysUserExample = new SysUserExample();
		sysUserExample.setPageSize(pageSize);
		sysUserExample.setPageStart(pageStart);
		sysUserExample.setUsername(username);
		return sysUserMapper.selectByname(sysUserExample);
	}

	@Override
	public int updateImg(SysUser sysUser) {
		
		return sysUserMapper.updateByPrimaryKey(sysUser);
	}

}














