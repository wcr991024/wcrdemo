package com.dt.cn.service.lmpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.cn.dao.mapper.ExpenceMapper;
import com.dt.cn.model.sysUser.Expence;
import com.dt.cn.model.sysUser.ExpenceExample;
import com.dt.cn.service.ExpenceService;
@Service
public class ExpenceServiceImpl implements ExpenceService{
@Resource
ExpenceMapper expenceMapper;
	@Override
	public long countByExample() {
		ExpenceExample expenceExample = new ExpenceExample();
		return expenceMapper.countByExample(expenceExample);
	}

	@Override
	public long getCount() {
		ExpenceExample expenceExample = new ExpenceExample();
		return expenceMapper.countByExample(expenceExample);
	}

	@Override
	public int getCount(String name) {
		// TODO Auto-generated method stub
		return expenceMapper.getCount(name);
	}

	@Override
	public List<Expence> selectByExample(int pageStart, int pageSize, String name) {
		ExpenceExample expenceExample = new ExpenceExample();
		expenceExample.setPageSize(pageSize);
		expenceExample.setPageStart(pageStart);
		expenceExample.setName(name); 
		return expenceMapper.selectByExample(expenceExample);
	}

}
