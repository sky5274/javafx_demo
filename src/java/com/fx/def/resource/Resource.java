package com.fx.def.resource;

import java.net.URL;

/**
 * ϵͳͨ����Դ��λ
 *<p>Title: Resource.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 * @author sky
 * @date 2019��3��26��
 */
public class Resource {
	
	public static URL getResource(String url) {
		if(url.startsWith("/")) {
			url=url.substring(1);
		}
		return Resource.class.getClassLoader().getResource(url);
	}
	
}
