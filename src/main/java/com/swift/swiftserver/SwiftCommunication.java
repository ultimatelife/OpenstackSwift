package com.swift.swiftserver;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.javaswift.joss.client.factory.AccountConfig;
import org.javaswift.joss.client.factory.AccountFactory;
import org.javaswift.joss.model.Account;
import org.javaswift.joss.model.Container;
import org.javaswift.joss.model.StoredObject;

import com.swift.json.SwiftCommunicationJson;

public class SwiftCommunication {
	
	//Account 구하기
	public Account getAccount(String tenantName, String userName, String passWord, String authUrl){
		AccountConfig config = new AccountConfig();
		config.setTenantName(tenantName);
		config.setUsername(userName);
		config.setPassword(passWord);
		config.setAuthUrl(authUrl);
		Account account = new AccountFactory(config).createAccount();
		return account;
	}
	
	//Container 생성하기
	public void createContainer(Account account, String containerName){
		 Container container = account.getContainer(containerName);
		 container.create();
		 container.makePublic();
	}
	
	//Container 구하기
	public Container getContainer(Account account, String containerName){
		Container container = account.getContainer(containerName);
		return container;
	}
	
	//Container List 구하기
	public ArrayList<SwiftCommunicationJson> containerList(Container container){
		Collection<StoredObject> list = container.list();
		Iterator<StoredObject> itList = list.iterator();
		ArrayList<SwiftCommunicationJson> strList = new ArrayList<SwiftCommunicationJson>();
		
		for(int i = 0; i < list.size() ; i++){
			StoredObject so = itList.next();
			SwiftCommunicationJson temp = new SwiftCommunicationJson(so.getMetadata().toString(), so.getContentLength(), so.getLastModified());
	    	strList.add(temp);
		}
		return strList;
	}
	
	//Object Upload 구하기
	public void upload(Container container, File file){
		StoredObject object = container.getObject(file.getName());
	    object.uploadObject(file);
	}
	
	//Object Download 구하기
	public void download(Container container, File file){
		StoredObject object = container.getObject(file.getName());
		object.downloadObject(file);
	}
	
	//Object Delete
	public void delete(Container container, File file){
		StoredObject newObject = container.getObject(file.getName());
	    newObject.delete();
	}
}
