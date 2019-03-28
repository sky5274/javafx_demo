package com.fx.boot.stage;

import java.awt.Toolkit;

import com.fx.boot.load.BootView;
import com.fx.data.bundle.DataResourceBundle;
import com.fx.url.UrlManager;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class FlowStage extends Stage{
	private double width=Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.8;
	private double heigth=Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.8;
	
	public FlowStage() {}
	public FlowStage(Stage stage) {
		super(stage.getStyle());
	}
	/**
	 * 导航（不是新开页面），无参数
	 * <p>Title: navgicateTo</p>
	 * <p>Description: </p>
	 * @param urlcode
	 * @author 王帆
	 */
	public <T> T navgicateTo(UrlManager urlcode) {
		return navgicateTo(urlcode,null);
	}
	
	/**
	 * 携带参数 导航页面 （不是新开页面）
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
	 * 改变场景（导航2）
	 * <p>Title: nagvicateTo</p>
	 * <p>Description: </p>
	 * @param sc
	 * @param title
	 * * @author 王帆
	 */
	public void nagvicateTo(Scene sc,String title) {
		setTitle(title);
		setScene(sc);
	}
}
