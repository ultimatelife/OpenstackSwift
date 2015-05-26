package com.swift.swiftserver;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.javaswift.joss.client.factory.AccountConfig;
import org.javaswift.joss.client.factory.AccountFactory;
import org.javaswift.joss.instructions.DownloadInstructions;
import org.javaswift.joss.model.Account;
import org.javaswift.joss.model.Container;
import org.javaswift.joss.model.StoredObject;

import com.swift.json.Obj;

public class SwiftCommunication {
	
	public Account account;
	public Container container;
	
	public SwiftCommunication() {
	}
	
	public SwiftCommunication(String tenantName, String userName, String passWord, String authUrl, String containerName){
		setAccount(tenantName, userName, passWord, authUrl);
		setContainer(this.account, containerName);
	}
	
	//Account 
	public void setAccount(String tenantName, String userName, String passWord, String authUrl){
		AccountConfig config = new AccountConfig();
		config.setTenantName(tenantName);
		config.setUsername(userName);
		config.setPassword(passWord);
		config.setAuthUrl(authUrl);
		this.account = new AccountFactory(config).createAccount();
	}
	
	
	//Container 
	public Container setContainer(Account account, String containerName){
		this.container = account.getContainer(containerName);
		return container;
	}
	
	public Container getContainer(){
		return container;
	}
	
	
	//Object List 
	public ArrayList<Obj> objectList(){
		Collection<StoredObject> list = container.list();
		Iterator<StoredObject> itList = list.iterator();
		ArrayList<Obj> strList = new ArrayList<Obj>();
		
		
		for(int i = 0; i < list.size() ; i++){
			StoredObject so = itList.next();
			Obj temp = new Obj(so.getMetadata().toString(), so.getContentLength(), so.getLastModified());
	    	strList.add(temp);
		}
		return strList;
	}
	
	//Container 
	public void createContainer(String containerName){
		Container container = account.getContainer(containerName);
		container.create();
		container.makePublic();
	}
	
	//Object Upload 
	public void upload(File file){
		try {
			StoredObject object = container.getObject(file.getName());
			object.uploadObject(file);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	//Object Download 
	public void download(File file){
		try {
			StoredObject object = container.getObject(file.getName());
			object.downloadObject(file);
		} catch (Exception e) {
		}
	}
	
	public void download(String fileName){
		try {
			DownloadInstructions di = new DownloadInstructions();
			StoredObject object = container.getObject(fileName);
//			object.dow
//			object.downloadObject();
		} catch (Exception e) {
			System.out.println("Download Error");
		}
	}
	
	//Object Delete
	public void delete(File file){
		StoredObject newObject = container.getObject(file.getName());
	    newObject.delete();
	}
}
