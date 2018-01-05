package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.entity.AccountDO;

public interface AccountService {
	
//账户 增删改查  没有分页
	List<AccountDO> listAccount();
	
	void updateAccount(AccountDO accountDO);
	
	void  addAccount(AccountDO accountDO);
	
	void deleteAccount(int id);
	//根据账户查所有信息
	List<AccountDO> listAccountByEmail(String email);
	
}
