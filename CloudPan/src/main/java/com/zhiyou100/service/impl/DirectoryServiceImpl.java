package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.DirectoryDao;
import com.zhiyou100.entity.AccountDO;
import com.zhiyou100.entity.DirectoryDO;
import com.zhiyou100.service.DirectoryService;

@Service
public class DirectoryServiceImpl implements DirectoryService {
	@Autowired
	private DirectoryDao dao;

	public List<DirectoryDO> listDirectory() {
		List<DirectoryDO> listDirectory = dao.listDirectory();
		return listDirectory;
	}

	public void updateDirectory(DirectoryDO directoryDO) {
		dao.updateDirectory(directoryDO);
		
	}

	public void addDirectory(DirectoryDO directoryDO) {
		dao.addDirectory(directoryDO);
		
	}

	public void deleteDirectory(int id) {
		dao.deleteDirectory(id);
		
	}

	public void updateDirectoryName(DirectoryDO directoryDO) {
		dao.updateDirectoryName(directoryDO);
		
	}

	public void updateDirectoryLocation(DirectoryDO directoryDO) {
		dao.updateDirectoryLocation(directoryDO);
		
	}

	public List<DirectoryDO> listDirectoryBy(DirectoryDO directoryDO) {
		List<DirectoryDO> listDirectoryBy = dao.listDirectoryBy(directoryDO);
		return listDirectoryBy;
	}

}
