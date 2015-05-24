package com.swift.swiftserver;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.javaswift.joss.client.factory.AccountConfig;
import org.javaswift.joss.client.factory.AccountFactory;
import org.javaswift.joss.client.factory.AuthenticationMethod;
import org.javaswift.joss.headers.Header;
import org.javaswift.joss.model.Account;
import org.javaswift.joss.model.Container;
import org.javaswift.joss.model.Directory;
import org.javaswift.joss.model.DirectoryOrObject;
import org.javaswift.joss.model.FormPost;
import org.javaswift.joss.model.PaginationMap;
import org.javaswift.joss.model.StoredObject;

public class TestSwiftServer {
	public static void main(String[] args) {
		 AccountConfig config = new AccountConfig();
		 config.setTenantName("kunwoo");
		 config.setUsername("kunwoo");
         config.setPassword("qwer1234");
         config.setAuthUrl("http://192.168.0.14:5000/v2.0/tokens");
		 Account account = new AccountFactory(config).createAccount();
		 
		 //container list
	    Collection<Container> containers = account.list();
	    for (Container currentContainer : containers) {
	        System.out.println(currentContainer.getName());
	    }
	    
	    Container container = account.getContainer("Kunwoo");
	    
	    Collection<StoredObject> list = container.list();
	    Iterator<StoredObject> itList = list.iterator();
	    for(int i = 0; i < list.size() ; i++){
	    	StoredObject so = itList.next();
	    	System.out.println(so.getMetadata());
	    }
	    
//	    StoredObject object = container.getObject("dog.png");
//	    object.uploadObject(new File("/dog.png"));
//	    System.out.println("Public URL: "+object.getPublicURL());
	}
}