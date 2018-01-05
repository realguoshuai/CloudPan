package com.zhiyou100.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou100.entity.AccountDO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class AccountDaoTest {
	@Autowired
	private AccountDao dao;
	@Test
	public void testListAccount() {
	// 	TestCase.assertEquals(1, dao.listAccount().size());
		List<AccountDO> listAccount = dao.listAccount();
		System.out.println(listAccount);
	}

	@Test
	public void testUpdateAccount() {
		
		AccountDO accountDO =new AccountDO(1,"LISI@QQ.COM", "123456", 1);
		System.out.println(accountDO);
		dao.updateAccount(accountDO);
		
	
	}

	@Test
	public void testAddAccount() {
		AccountDO accountDO =new AccountDO("zhangsan@qq.com", "123456", 1);
		dao.addAccount(accountDO);
	}

	@Test
	public void testDeleteAccount() {
		dao.deleteAccount(3);
	}
	@Test
	public void listAccountByEmail() {
		List<AccountDO> listAccountByEmail = dao.listAccountByEmail("zhangsan@qq.com");
		System.out.println(listAccountByEmail);
	}

}
