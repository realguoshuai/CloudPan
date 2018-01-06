package com.zhiyou100.entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DirectoryDO implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -9111181049066440469L;

	private Integer id;
	private String name;
	private Integer isFile;
	private Integer accountId;
	private Integer parentId;
	private Integer fileId;

	private AccountDO accountDO;
	private FileDO fileDO;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date gmtCreate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date gmtModified;

	private Integer size;
	
	public DirectoryDO(Integer id, String name, Integer isFile, Integer accountId, Integer parentId, Integer fileId) {
		super();
		this.id = id;
		this.name = name;
		this.isFile = isFile;
		this.accountId = accountId;
		this.parentId = parentId;
		this.fileId = fileId;
	}

	public DirectoryDO(String name, Integer isFile, Integer accountId, Integer parentId, Integer fileId) {
		super();
		this.name = name;
		this.isFile = isFile;
		this.accountId = accountId;
		this.parentId = parentId;
		this.fileId = fileId;
	}

	public DirectoryDO() {
		super();
	}

	@Override
	public String toString() {
		return "DirectoryDO [id=" + id + ", name=" + name + ", isFile=" + isFile + ", accountId=" + accountId
				+ ", parentId=" + parentId + ", fileId=" + fileId + ", accountDO=" + accountDO + ", fileDO=" + fileDO
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIsFile() {
		return isFile;
	}

	public void setIsFile(Integer isFile) {
		this.isFile = isFile;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public AccountDO getAccountDO() {
		return accountDO;
	}

	public void setAccountDO(AccountDO accountDO) {
		this.accountDO = accountDO;
	}

	public FileDO getFileDO() {
		return fileDO;
	}

	public void setFileDO(FileDO fileDO) {
		this.fileDO = fileDO;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
	
	

}
