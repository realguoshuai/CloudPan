package com.zhiyou100.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.management.loading.PrivateClassLoader;

public class AccountDO implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 3138536836699795390L;

	private Integer id;
	private String email;
	private String password;
	private Integer active;
	private Date gmtCreate;

	private Date gmtmodified;
	

	public AccountDO(Integer id, String email, String password, Integer active) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.active = active;
	}
	

	public AccountDO(String email, String password, Integer active) {
		super();
		this.email = email;
		this.password = password;
		this.active = active;
	}


	public AccountDO() {
		super();
	}


	@Override
	public String toString() {
		return "AccountDO [id=" + id + ", email=" + email + ", password=" + password + ", active=" + active
				+ ", gmtCreate=" + gmtCreate + ", gmtmodified=" + gmtmodified + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtmodified() {
		return gmtmodified;
	}

	public void setGmtmodified(Date gmtmodified) {
		this.gmtmodified = gmtmodified;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
