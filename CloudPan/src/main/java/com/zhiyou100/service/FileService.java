package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.entity.FileDO;

public interface FileService {
	
	List<FileDO> listFile();
	
	void updateFile(FileDO fileDO);
	
	void  addFile(FileDO fileDO);
	
	void deleteFile(int id);
	//下载文件
		void  downFile(int id);
}
