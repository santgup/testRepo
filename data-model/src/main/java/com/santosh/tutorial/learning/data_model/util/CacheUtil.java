package com.santosh.tutorial.learning.data_model.util;

import java.util.Properties;

import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;

public class CacheUtil {
	
	
	
	public static ClientCache createClientCache(String geodecluster,String geodeUserName,String geodePass) {
		ClientCache clientCache=null;
		
		
			
			Properties properties=new Properties();
			properties.setProperty("security-username", geodeUserName);
			properties.setProperty("security-password", geodePass);
			properties.setProperty("security-client-auth-init", "com.santosh.tutorial.learning.data_model.geodeSecurity.UserPasswordAuthInit");
			ClientCacheFactory  clientCacheFactory=new ClientCacheFactory(properties);
			String [] gelocator=geodecluster.split(",");
			
			for(String locator:gelocator) {
				
				String [] locatorConfig=locator.split(":");
				
				clientCacheFactory.addPoolLocator(locatorConfig[0], Integer.parseInt(locatorConfig[1]));
				
				
			}
			
			  clientCache=clientCacheFactory.setPoolSubscriptionEnabled(true).create();
			
			//return clientCache;
		//}
		
		return clientCache;

		
		
	}

}
