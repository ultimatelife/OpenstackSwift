package com.swift.controller;

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
import com.swift.json.OpenstackSwiftUserInfo;
import com.swift.swiftserver.SwiftCommunication;

@Controller
public class UserInfoController {
	
	@Autowired
	private SqlSession sqlSession;
	 
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
