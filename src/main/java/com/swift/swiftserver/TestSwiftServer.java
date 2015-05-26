package com.swift.swiftserver;

import java.io.File;
import java.util.ArrayList;
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
		System.out.println("Account");
		AccountConfig config = new AccountConfig();
		config.setTenantName("admin");
		config.setUsername("admin");
		config.setPassword("qwer1234");
		config.setAuthUrl("http://192.168.0.14:5000/v2.0/tokens");
		Account account = new AccountFactory(config).createAccount();

		// container list
		// Collection<Container> containers = account.list();
		// for (Container currentContainer : containers) {
		// System.out.println(currentContainer.getName());
		// }

		Container container = account.getContainer("photo");

		// Collection<StoredObject> list = container.list();
		// Iterator<StoredObject> itList = list.iterator();
		// for(int i = 0; i < list.size() ; i++){
		// StoredObject so = itList.next();
		// System.out.println(so.getName());
		// System.out.println(so.getContentLength());
		// System.out.println(so.getMetadata().toString());
		// System.out.println(so.getLastModified());
		// }

		System.out.println("파일 업로드");
		StoredObject object = container.getObject("images.png");
		object.uploadObject(new File("C:\\Users\\kim\\Pictures\\images.png"));
		System.out.println("Public URL: " + object.getPublicURL());

		// StoredObject object = container.getObject("dog.png");
		// object.uploadObject(new File("/dog.png"));
		// System.out.println("Public URL: "+object.getPublicURL());
	}
}