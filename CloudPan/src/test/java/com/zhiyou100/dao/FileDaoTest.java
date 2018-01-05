package com.zhiyou100.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou100.entity.FileDO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class FileDaoTest {
@Autowired
private FileDao dao;
	@Test
	public void testListFile() {
		List<FileDO> listFile = dao.listFile();
		System.out.println(listFile);
	}

	@Test
	public void testUpdateFile() {
		FileDO fileDO =new FileDO("asdafs", 20, 2);
		dao.updateFile(fileDO);
	}

	@Test
	public void testAddFile() {
		FileDO fileDO =new FileDO("11111", 10, 1);
		dao.addFile(fileDO);
	}

	@Test
	public void testDeleteFile() {
		dao.deleteFile(1);
	}
	@Test
	public void downFile() {
		dao.downFile(2);
		
	}

}
