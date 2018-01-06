package com.zhiyou100.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
*/
	@RequestMapping(path = { "/directory/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseVO<String> addVideo(@RequestBody DirectoryDO directoryDO) {
		System.out.println("添加文件夹调用了");
		directoryService.addDirectoryName(directoryDO);
		return new ResponseVO<String>(0, "", "添加成功");

	}
	/*
	@RequestMapping(path = { "/video/update/{id}" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseVO<String> updateVideo(@PathVariable("id") int id, @RequestBody VideoDO video) {

		video.setId(id);

		videoService.updateObject(video);

		return new ResponseVO<String>(0, "", "修改成功");
	}
*/
	@RequestMapping(path = { "/directory/rename/{id}" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseVO<String> updateVideo(@PathVariable("id") int id, @RequestBody  DirectoryDO directoryDO) {

		directoryDO.setId(id);

		directoryService.updateDirectoryName(directoryDO);

		return new ResponseVO<String>(0, "", "修改成功");
	}
	@RequestMapping(path = { "/directory/{id}" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseVO<String> removeDirectory(@PathVariable("id") String id) {

		String[] idArray = id.split(",");

		directoryService.deleteDirectory(idArray);

		return new ResponseVO<String>(0, "", "删除成功");
	}
	
	/*下载文件*/
	@RequestMapping("/getPath")
	public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
	    File file = new File("E://123.jpg");
	    byte[] body = null;
	    InputStream is = new FileInputStream(file);
	    body = new byte[is.available()];
	    is.read(body);
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "attchement;filename=" + file.getName());
	    HttpStatus statusCode = HttpStatus.OK;
	    ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
	    return entity;
	}
}
