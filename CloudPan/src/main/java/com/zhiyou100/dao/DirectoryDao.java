package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.entity.DirectoryDO;

public interface DirectoryDao {
	//获取根目录下的所有文件
	List<DirectoryDO> listDirectory();
	
	void updateDirectory(DirectoryDO directoryDO);
	//新建文件夹
	void  addDirectory(DirectoryDO directoryDO);
	//重命名
	void updateDirectoryName(DirectoryDO directoryDO);
	//移动文件夹
	void updateDirectoryLocation(DirectoryDO directoryDO);
	void deleteDirectory(int id);
	
	//获取某个文件夹下的文件
	List<DirectoryDO> listDirectoryBy(DirectoryDO directoryDO);
	
	//
}
