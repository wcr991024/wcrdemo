package com.dt.xd.service;

import java.util.List;

import model.User.Expence;


public interface ExpenceService {
	long countByExample();

	public long getCount();

	int price1();

	public int getCount(String name,int time);

	String price(int time);

	List<Expence> selectByExample(int pageStart, int pageSize, String name);

	List<Expence> timetwoByExample(int pageStart, int pageSize, String name);

	List<Expence> timeByExample(int pageStart, int pageSize, String name);

	List<Expence> timethreeByExample(int pageStart, int pageSize, String name);

	// List<Expence> sumPrice(int price);
}
