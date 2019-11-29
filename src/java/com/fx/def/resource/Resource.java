package com.fx.def.resource;

import java.io.InputStream;
import java.net.URL;

/**
 * 统一资源定位方法
 *<p>Title: Resource.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 * @author sky
 * @date 2019年3月28日
 */
public class Resource {
	
	public static URL getResource(String url) {
		if(url.startsWith("/")) {
			url=url.substring(1);
		}
		return Resource.class.getClassLoader().getResource(url);
	}
	public static InputStream getInputStream(String url) {
		return Resource.class.getResourceAsStream(url);
	}
	
}
