package com.zhiyou100.entity;

import java.io.Serializable;
import java.sql.Date;

public class FileDO implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -5712677731402338910L;

	private Integer id;
	private String path;
	private Integer size;
	private Integer type;
	private String md5;
	private Date gmtCreate;

	private Date gmtmodified;

	
	public FileDO(String path, Integer size, Integer type) {
		super();
		this.path = path;
		this.size = size;
		this.type = type;
	}

	public FileDO(Integer id, String path, Integer size, Integer type, String md5) {
		super();
		this.id = id;
		this.path = path;
		this.size = size;
		this.type = type;
		this.md5 = md5;
	}

	public FileDO() {
		super();
	}

	@Override
	public String toString() {
		return "FileDO [id=" + id + ", path=" + path + ", size=" + size + ", type=" + type + ", md5=" + md5
				+ ", gmtCreate=" + gmtCreate + ", gmtmodified=" + gmtmodified + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}



	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
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
