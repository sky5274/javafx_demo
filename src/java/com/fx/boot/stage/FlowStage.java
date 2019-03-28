package com.fx.boot.stage;

import java.awt.Toolkit;

import com.fx.boot.load.BootView;
import com.fx.data.bundle.DataResourceBundle;
import com.fx.url.UrlManager;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FlowStage extends Stage{
	private double width=Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.8;
	private double heigth=Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.8;
	
	public FlowStage() {}
	public FlowStage(Stage stage) {
		super(stage.getStyle());
	}
	/**
	 * 页面跳转
	* <p>Title: navgicateTo</p>
	* <p>Description: </p>
	* @param urlcode
	* @return
	 */
	public <T> T navgicateTo(UrlManager urlcode) {
		return navgicateTo(urlcode,null);
	}
	
	/**
	 * 携带信息的页面跳转
	* <p>Title: navgicateTo</p>
	* <p>Description: </p>
	* @param urlcode
	* @param resource
	 */
	public <T> T navgicateTo(UrlManager urlcode,DataResourceBundle<?> resource) {
		return navgicateTo(urlcode,null,resource);
	}
	public <T> T navgicateTo(UrlManager urlcode,String cssUrl,DataResourceBundle<?> resource) {
		return navgicateTo(urlcode, cssUrl, resource, width, heigth);
	}
	public<T> T navgicateTo(UrlManager urlcode,String cssUrl,DataResourceBundle<?> resource,double width,double heigth) {
		return BootView.get(this, urlcode,resource, cssUrl, width, heigth, true);
	}

	/**
	 * 场景转换
	 * <p>Title: nagvicateTo</p>
	 * <p>Description: </p>
	 * @param sc
	 * @param title
	 * * @author ����
	 */
	public void nagvicateTo(Scene sc,String title) {
		setTitle(title);
		setScene(sc);
	}
}
