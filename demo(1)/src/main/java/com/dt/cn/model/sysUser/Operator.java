package com.dt.cn.model.sysUser;

import java.sql.Date;

import org.springframework.stereotype.Component;
@Component
public class Operator {
	private String id;

	private String business_no;
	private String name;
	private String order_info;
	private Integer order_price;
	private Date create_time;
	private Integer status;
	private Integer pay_type;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBusiness_no() {
		return business_no;
	}

	public void setBusiness_no(String business_no) {
		this.business_no = business_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrder_info() {
		return order_info;
	}

	public void setOrder_info(String order_info) {
		this.order_info = order_info;
	}

	public Integer getOrder_price() {
		return order_price;
	}

	public void setOrder_price(Integer order_price) {
		this.order_price = order_price;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPay_type() {
		return pay_type;
	}

	public void setPay_type(Integer pay_type) {
		this.pay_type = pay_type;
	}
	
}
