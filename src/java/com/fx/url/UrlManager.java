package com.fx.url;

/**
 * ϵͳurl����ö��
 *<p>Title: UrlManager.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 * @author sky
 * @date 2019��3��26��
 */
public enum UrlManager {
	LOGIN("/face/login.fxml","��¼"),
	MAIN("/face/main.fxml","��ҳ"), 
	Notify("/face/notify.fxml","notification");
	private String url;
	private String title;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	UrlManager(String url,String title){
		this.url=url;
		this.title=title;
	}
}