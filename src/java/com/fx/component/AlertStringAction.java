package com.fx.component;

/**
 * 提示字符串的执行行为
 *<p>Title: AlertStringAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 * @author sky
 * @date 2019年3月28日
 */
public abstract class AlertStringAction extends AlertAction <String>{
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public AlertStringAction(String con) {
		this.content=con;
	}

	@Override
	public void complete() {
		
	}

	@Override
	public void fail() {
		
	}

	@Override
	public void before() {
		
	}

}
