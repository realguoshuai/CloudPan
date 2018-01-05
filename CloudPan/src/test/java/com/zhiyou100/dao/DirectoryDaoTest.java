package com.zhiyou100.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou100.entity.DirectoryDO;

import junit.framework.TestCase;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class DirectoryDaoTest {
	@Autowired
	private DirectoryDao dao;
	@Test
	public void testListDirectory() {
	
		
		TestCase.assertEquals(4, dao.listDirectory().size());
	}

	@Test
	public void testUpdateDirectory() {
		DirectoryDO directoryDO =new DirectoryDO(1,"afda", 1, 1,1, 2);
		dao.updateDirectory(directoryDO);
	}

	@Test
	public void testAddDirectory() {
		DirectoryDO directoryDO =new DirectoryDO();
		directoryDO.setName("yoyo");
		directoryDO.setIsFile(1);
		directoryDO.setAccountId(1);
		directoryDO.setParentId(0);
		
		dao.addDirectory(directoryDO);
	}

	@Test
	public void testDeleteDirectory() {
		//dao.deleteDirectory(1);
	}

	@Test
	public void testUpdateDirectoryName() {
		DirectoryDO directoryDO =new DirectoryDO();
		directoryDO.setName("测试文件夹");
		directoryDO.setId(3);
		dao.updateDirectory(directoryDO);
	}

	@Test
	public void testUpdateDirectoryLocation() {
		DirectoryDO directoryDO =new DirectoryDO();
		directoryDO.setParentId(0);
		directoryDO.setId(1);
		dao.updateDirectoryLocation(directoryDO);
	}

	@Test
	public void testListDirectoryBy() {
		DirectoryDO directoryDO =new DirectoryDO();
		directoryDO.setParentId(0);
		directoryDO.setAccountId(2);
		List<DirectoryDO> listDirectoryBy = dao.listDirectoryBy(directoryDO);
		System.out.println(listDirectoryBy);
	}

}
