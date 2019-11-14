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
	private String status;
	private String pay_type;
	
	private String code;
	private String cellphone;
	private String region;
	private Date register_time;
	private int  buy_num;
	private int  price;
	
	private String service_name;
	private String region_name;
	private String service_info;
	
	private Date buy_time;
	private String bussiness_no;
	
	private String product_name;
	private String explain;
	private String sale_num;
	private String provider;
	
	
	
	
	public Date getBuy_time() {
		return buy_time;
	}

	public void setBuy_time(Date buy_time) {
		this.buy_time = buy_time;
	}

	public String getBussiness_no() {
		return bussiness_no;
	}

	public void setBussiness_no(String bussiness_no) {
		this.bussiness_no = bussiness_no;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getSale_num() {
		return sale_num;
	}

	public void setSale_num(String sale_num) {
		this.sale_num = sale_num;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public String getService_info() {
		return service_info;
	}

	public void setService_info(String service_info) {
		this.service_info = service_info;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Date getRegister_time() {
		return register_time;
	}

	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}

	public int getBuy_num() {
		return buy_num;
	}

	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	
}
