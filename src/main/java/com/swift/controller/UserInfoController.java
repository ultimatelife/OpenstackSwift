package com.swift.controller;

import java.io.File;
import java.lang.reflect.Member;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.ibatis.session.SqlSession;
import org.javaswift.joss.model.StoredObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swift.dao.UserInfoDao;
import com.swift.dto.UserInfoDto;
import com.swift.json.Obj;
import com.swift.json.OpenstackSwiftUserInfo;
import com.swift.swiftserver.SwiftCommunication;

@Controller
public class UserInfoController {
	
	@Autowired
	private SqlSession sqlSession;
	 
	@RequestMapping(value = "/objectlist", method=RequestMethod.POST)
	public String objectList(@RequestParam("container") String container, Model model){
		SwiftCommunication swiftCommunication = new SwiftCommunication("admin", "admin", "qwer1234", "http://192.168.0.14:5000/v2.0/tokens",container);
		ArrayList<Obj> arrObj = swiftCommunication.objectList();
		
		for(int i = 0 ; i < arrObj.size() ;i++){
			System.out.println(i);
			System.out.println(arrObj.get(i));
		}
		
		model.addAttribute("list", arrObj);
		return "objectlist";
	}
	
	@RequestMapping(value = "/fileDelete", method=RequestMethod.POST)
	public String fileDelete(@RequestParam("file") String fileName){
		SwiftCommunication swiftCommunication = new SwiftCommunication("admin", "admin", "qwer1234", "http://192.168.0.14:5000/v2.0/tokens","samsung");
		StoredObject object= swiftCommunication.container.getObject(fileName);
		object.delete();
		System.out.println("File Delete Success");
		return "Success";
	}
	
	@RequestMapping(value = "/fileDownload", method=RequestMethod.POST)
	public String fileDownload(@RequestParam("file") String fileName){
		SwiftCommunication swiftCommunication = new SwiftCommunication("admin", "admin", "qwer1234", "http://192.168.0.14:5000/v2.0/tokens","samsung");
		swiftCommunication.download(new File(fileName));
		System.out.println("File Download Success");
		return "Success";
	}
	
	
	@RequestMapping(value = "/fileUpload", method=RequestMethod.POST)
	public String fileUpload(@RequestParam("file") String fileName){
		SwiftCommunication swiftCommunication = new SwiftCommunication("admin", "admin", "qwer1234", "http://192.168.0.14:5000/v2.0/tokens","samsung");
		swiftCommunication.upload(new File(fileName));
		System.out.println("File Upload Success");
		return "Success";
	}
	
	
	@RequestMapping(value = "/selectWhere", method = RequestMethod.POST)
	public @ResponseBody ArrayList<OpenstackSwiftUserInfo>userInfoDtoJsonList(@RequestParam("id") String id, @RequestParam("pw") String pw) {
		UserInfoDao dao = sqlSession.getMapper(UserInfoDao.class);
		UserInfoDto dto = null;
		ArrayList<OpenstackSwiftUserInfo> arrOpenstackSwiftUserInfo = new ArrayList<OpenstackSwiftUserInfo>();
		OpenstackSwiftUserInfo openstackSwiftUserInfo = new OpenstackSwiftUserInfo();
		
		try {
			dto = dao.userInfoSelectWhere(id, pw);
			openstackSwiftUserInfo.setContainer(dto.getContainer());
			arrOpenstackSwiftUserInfo.add(openstackSwiftUserInfo);
		} catch (Exception e) {
			openstackSwiftUserInfo.setContainer("error");
		}finally{
			return arrOpenstackSwiftUserInfo;
		}
	}

	@RequestMapping(value = "/insert")
	public @ResponseBody String userInfoInsert(UserInfoDto dto){
		UserInfoDao dao = sqlSession.getMapper(UserInfoDao.class);
		dao.userInfoInsert(dto.getId(), dto.getPw(), dto.getName(), dto.getEmail(), dto.getContainer());
		System.out.println("DB Successs");
		
		SwiftCommunication swiftCommunication = new SwiftCommunication("admin", "admin", "qwer1234", "http://192.168.0.14:5000/v2.0/tokens","music");
		swiftCommunication.createContainer(dto.getContainer());
		System.out.println("Container Successs");
		
		return "Success";
	}
	
	@RequestMapping(value = "/delete")
	public @ResponseBody String userInfoDtoJsonDelete(@RequestParam("id") String id) {
		UserInfoDao dao = sqlSession.getMapper(UserInfoDao.class);
		dao.userInfoDelete(id);
		return "Success";
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody String userInfoDtoUpdate(UserInfoDto dto) {
		UserInfoDao dao = sqlSession.getMapper(UserInfoDao.class);
		dao.userInfoUpdate(dto.getId(), dto.getPw(), dto.getName(), dto.getEmail(), dto.getContainer());
		return "Success";
	}
}
