package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.FileDao;
import com.zhiyou100.entity.AccountDO;
import com.zhiyou100.entity.FileDO;
import com.zhiyou100.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	private FileDao dao;

	public List<FileDO> listFile() {
		List<FileDO> listFile = dao.listFile();
		return listFile;
	}

	public void updateFile(FileDO fileDO) {
		dao.updateFile(fileDO);
		
	}

	public void addFile(FileDO fileDO) {
		
		dao.addFile(fileDO);
	}

	public void deleteFile(int id) {
		
		dao.deleteFile(id);
	}

	public void downFile(int id) {
		dao.downFile(id);
		
	}

}
