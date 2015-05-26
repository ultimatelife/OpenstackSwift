package com.swift.swiftserver;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

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

import com.swift.json.Obj;

public class TestSwiftServer {
	public static void main(String[] args) {
		
		SwiftCommunication swiftCommunication = new SwiftCommunication("admin", "admin", "qwer1234", "http://192.168.0.14:5000/v2.0/tokens","samsung");
		swiftCommunication.createContainer("what");		
		swiftCommunication.download(new File("C:\\Users\\kim\\monkey.png"));
		
		
		System.out.println("Account");
//		AccountConfig config = new AccountConfig();
//		config.setTenantName("admin");
//		config.setUsername("admin");
//		config.setPassword("qwer1234");
//		config.setAuthUrl("http://192.168.0.14:5000/v2.0/tokens");
//		Account account = new AccountFactory(config).createAccount();
		

//		ArrayList<Obj> arr = swiftCommunication.objectList();
//		for(int i = 0 ; i < arr.size() ; i++){
//			System.out.println();
//		}
//		swiftCommunication.upload(new File("C:\\Users\\kim\\Pictures\\images.png"));
//		swiftCommunication.download("images.png");
//		System.out.println("down success");

//		swiftCommunication.download(new File""));
//		ArrayList<Obj> arr = swiftCommunication.containerList();
//		
//		for(int i = 0 ; i < arr.size() ; i++){
//			System.out.println(arr.get(i).getFileMetaData());
//		}
		
//		for (int i = 0; i < list.size(); i++) {
//			StoredObject so = itList.next();
//			System.out.println(so.getName());
//			System.out.println(so.getContentLength());
//			TestSwiftServer sw = new TestSwiftServer();
//			System.out.println(so.getMetadata().toString().substring(15, so.getMetadata().toString().length()-1));
//			System.out.println(so.getLastModified());
//		}
		
		// container list
		// Collection<Container> containers = account.list();
		// for (Container currentContainer : containers) {
		// System.out.println(currentContainer.getName());
		// }

//		Container container = account.getContainer("hyunjae");
//
//		Collection<StoredObject> list = container.list();
//		Iterator<StoredObject> itList = list.iterator();
//		for (int i = 0; i < list.size(); i++) {
//			StoredObject so = itList.next();
//			System.out.println(so.getName());
//			System.out.println(so.getContentLength());
//			TestSwiftServer sw = new TestSwiftServer();
//			System.out.println(so.getMetadata().toString().substring(15, so.getMetadata().toString().length()-1));
//			System.out.println(so.getLastModified());
//		}

		// System.out.println("파일 업로드");
		// StoredObject object = container.getObject("images.png");
		// object.uploadObject(new
		// File("C:\\Users\\kim\\Pictures\\images.png"));
		// System.out.println("Public URL: " + object.getPublicURL());

		// StoredObject object = container.getObject("dog.png");
		// object.uploadObject(new File("/dog.png"));
		// System.out.println("Public URL: "+object.getPublicURL());
	}

	public String setName(String name) {
		StringTokenizer tokenizer = new StringTokenizer("");
		String str = tokenizer.nextToken();
		String str1 = str.substring(0, str.length() - 1);
		return str1;
	}

}