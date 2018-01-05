package com.zhiyou100.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.dto.BaseDTO;
import com.zhiyou100.entity.DirectoryDO;
import com.zhiyou100.service.DirectoryService;
import com.zhiyou100.service.FileService;
import com.zhiyou100.vo.QueryVO;
import com.zhiyou100.vo.ResponseVO;

@Controller
public class DirectoryController {
	@Autowired
	private DirectoryService directoryService;
	@Autowired
	private FileService fileService;
	



/*	@RequestMapping(path = { "/directory/list" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseVO<DirectoryDO> listDirectoryByQuery() {
		System.out.println("-----");
		List<DirectoryDO> listDirectory = directoryService.listDirectory();

		return new ResponseVO<DirectoryDO>(0, "", listDirectory);
	}
	*/
	/* 展示全部*/
	@RequestMapping(path = { "/directory/list" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseVO<BaseDTO<DirectoryDO>> listVideoByQuery(QueryVO vo) {

		 List<DirectoryDO> listDirectory = directoryService.listDirectory();
		BaseDTO<DirectoryDO> dto =new BaseDTO<DirectoryDO>(0, listDirectory);

		return new ResponseVO<BaseDTO<DirectoryDO>>(0, " ", dto);
	}
	
	
	
	
/*
	@RequestMapping(path = { "/video/get/{id}" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseVO<VideoDO> getVideo(@PathVariable("id") int id) {

		VideoDO video = videoService.getObject(id);

		return new ResponseVO<VideoDO>(0, "", video);
	}

	@RequestMapping(path = { "/video/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseVO<String> addVideo(@RequestBody VideoDO video) {
		videoService.addObject(video);
		return new ResponseVO<String>(0, "", "添加成功");

	}

	@RequestMapping(path = { "/video/update/{id}" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseVO<String> updateVideo(@PathVariable("id") int id, @RequestBody VideoDO video) {

		video.setId(id);

		videoService.updateObject(video);

		return new ResponseVO<String>(0, "", "修改成功");
	}

	@RequestMapping(path = { "/video/{id}" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseVO<String> removeVideo(@PathVariable("id") String id) {

		String[] idArray = id.split(",");

		videoService.removeObject(idArray);

		return new ResponseVO<String>(0, "", "删除成功");
	}*/
}
