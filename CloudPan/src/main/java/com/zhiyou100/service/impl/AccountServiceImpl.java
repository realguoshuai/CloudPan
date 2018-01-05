package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.AccountDao;
import com.zhiyou100.entity.AccountDO;
import com.zhiyou100.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao dao;
	public List<AccountDO> listAccount() {
		List<AccountDO> listAccount = dao.listAccount();
		return listAccount;
	}

	public void updateAccount(AccountDO accountDO) {
		dao.updateAccount(accountDO);

	}

	public void addAccount(AccountDO accountDO) {
		dao.addAccount(accountDO);

	}

	public void deleteAccount(int id) {
		dao.deleteAccount(id);

	}

	public List<AccountDO> listAccountByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.listAccountByEmail(email);
	}

}
