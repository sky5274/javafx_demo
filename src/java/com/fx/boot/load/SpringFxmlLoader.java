package com.fx.boot.load;

import java.io.IOException;
import java.util.ResourceBundle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.fx.def.resource.Resource;
import javafx.fxml.FXMLLoader;
import javafx.util.Callback;

public class SpringFxmlLoader {
	private static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
	private static  FXMLLoader loader;
	private static Log log=LogFactory.getLog(SpringFxmlLoader.class);
	static{
		loader=getViewLoad(null);
	}
	
	@SuppressWarnings("static-access")
	public static Object load(String url ) {
		try {
			return loader.load(Resource.getResource(url));
		} catch (IOException e) {
			log.warn(e.getMessage(), e);
			return null;
		}
	}
	@SuppressWarnings("static-access")
	public static Object load(String url,ResourceBundle resource) {
		try {
			return loader.load(Resource.getResource(url),resource);
		} catch (IOException e) {
			log.warn(e.getMessage(), e);
			return null;
		}
	}
	@SuppressWarnings({ "static-access", "unchecked" })
	public static <T> T loadView(String url,Class<T> clazz) {
		try {
			return (T)loader.load(Resource.getResource(url));
		} catch (IOException e) {
			log.warn(e.getMessage(), e);
			return null;
		}
	}
	@SuppressWarnings("static-access")
	public static <T> T loadView(String url,ResourceBundle resource) {
		try {
			return loader.load(Resource.getResource(url),resource);
		} catch (IOException e) {
			log.warn(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * 加载fmlload
	* <p>Title: getBean</p>
	* <p>Description: </p>
	* @param clazz
	* @return
	 */
	public static FXMLLoader getViewLoad(String view) {
		FXMLLoader load = view ==null? new FXMLLoader(): new FXMLLoader(Resource.getResource(view));
		load.setControllerFactory(new Callback<Class<?>, Object>() {
		    @Override
		    public Object call(Class<?> clazz) {
		     return applicationContext.getBean(clazz);
		    }
		   });
		return load;
	}
	
}
