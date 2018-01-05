package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.entity.AccountDO;

public interface AccountDao {
	List<AccountDO> listAccount();

	void updateAccount(AccountDO accountDO);

	void addAccount(AccountDO accountDO);

	void deleteAccount(int id);
	
	List<AccountDO> listAccountByEmail(String email);
}
