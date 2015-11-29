package com.townscript.hero.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ServerFactory {

	private static Properties properties;

	private static ServerFactory serverFactory;

	public ServerFactory() {
		super();
		try {
			properties = new Properties();
			String path =System.getenv("CATALINA_HOME");
			properties.load(new FileInputStream(path+"/conf/root.properties"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}

	public static String getApiServerAddress() {
		if(serverFactory == null) {
			serverFactory = new ServerFactory();
			System.out.println("Cerating server factory first time:::"+getAddress());
		}
		return getAddress();
	}
	
	private static String getAddress() {
		return properties.getProperty("apiServerAddress");
	}
	
	public static int getServerIndex() {
		if(serverFactory == null) {
			serverFactory = new ServerFactory();
		}
		return Integer.parseInt(properties.getProperty("serverIndex"));
	}

}
