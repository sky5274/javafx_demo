package com.fx.boot.load;

import java.awt.Toolkit;
import java.io.IOException;
import org.springframework.util.StringUtils;

import com.fx.boot.view.LoadingProgessView;
import com.fx.data.bundle.DataResourceBundle;
import com.fx.def.resource.Resource;
import com.fx.url.UrlManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class BootView{
	private static double def_width=Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.8;
	private static double def_heigth=Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.8;
	/**
	 * 在新场景中打开页面
	* <p>Title: open</p>
	* <p>Description: </p>
	* @param urlcode
	 * @return 
	 */
	public static <T> T open(UrlManager urlcode) {
		return get(new Stage(),urlcode,true);
	}
	
	/**
	 * 获取页面，
	* <p>Title: get</p>
	* <p>Description: </p>
	* @param urlcode
	* @param flag  是否显示标志
	* @return
	 */
	public static <T,K extends Stage> T get(K stage,UrlManager urlcode,boolean flag) {
		return get(stage,urlcode,null,def_width,def_heigth,flag);
	}
	public static <T,K extends Stage> T get(K stage,UrlManager urlcode,DataResourceBundle<?> resource,String cssUrl,Double width,Double heigth,boolean flag) {
		LoadingProgessView.load(stage);
		FXMLLoader view = getViewLoad(urlcode);
		try {
			if(resource==null) {
				resource=new DataResourceBundle<Object>();
			}
			resource.setStage(stage);
			view.setResources(resource);
			Parent root=(Parent)view.load();
			if(flag && stage !=null) {
				if(width<=0) {
					width=def_width;
				}
				if(heigth<=0) {
					width=def_heigth;
				}
				stage.setTitle(urlcode.getTitle());
				Scene scene = new Scene(root,width,heigth);
				if(!StringUtils.isEmpty(cssUrl)) {
					scene.getStylesheets().add(Resource.getResource(cssUrl).toExternalForm());
				}
				stage.setScene(scene);
				stage.show();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		LoadingProgessView.close(stage);
		return view.getController();
	}
	public static <T,K extends Stage> T get(K stage,UrlManager urlcode,String cssUrl,Double width,Double heigth,boolean flag) {
		return get(stage, urlcode, null, cssUrl, width, heigth, flag);
	}
	
	public static <T,K extends Stage> T get(UrlManager urlcode) {
		return get(null,urlcode, false);
	}
	
	public static FXMLLoader getViewLoad(UrlManager urcode) {
		return SpringFxmlLoader.getViewLoad(urcode.getUrl());
	}
	
	public static <T> T getNewViewController(UrlManager urlcode) {
		FXMLLoader load = getViewLoad(urlcode);
		try {
			load.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return load.getController();
	}
}
