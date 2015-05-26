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
public class TestController {
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/inputContainer")
	public String list() {
		return "inputContainer";
	}
	
	@RequestMapping(value = "/upload")
	public String upload() {
		return "upload";
	}
	
	@RequestMapping(value = "/download")
	public String download() {
		return "download";
	}
	
	@RequestMapping(value = "/deleteF")
	public String delete() {
		return "deleteF";
	}
}
