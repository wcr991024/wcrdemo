package com.dt.cn.model.sysUser;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component//注解，不是注释
public class SysUser {
    private Integer id;

    private String username;

    private String password;

    private Date ts;

    private byte[] img;
    
    
    public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }
}