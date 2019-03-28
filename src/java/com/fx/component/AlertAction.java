package com.fx.component;

import javafx.scene.control.ButtonType;

/**
 * 抽象提示信息行为
 *<p>Title: AlertAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 * @author sky
 * @date 2019年3月28日
 * @param <K>
 */
@SuppressWarnings("restriction")
public abstract class AlertAction <K>{
	private String title;
	private K content;
	public abstract void success(ButtonType btnType);
	public abstract void complete();
	public abstract void fail();
	public abstract void before();
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public K getContent() {
		return content;
	}
	public void setContent(K content) {
		this.content = content;
	}
}
