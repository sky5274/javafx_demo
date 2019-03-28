package com.fx.component;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

/**
 * 自定义的携带提示的按钮
 *<p>Title: TButton.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 * @author sky
 * @date 2019年3月28日
 */
public class TButton extends Button{
	private String tips;
	
	public TButton() {
		super();
	}
	public TButton(String text) {
		super(text);
	}
	
	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
		this.setTooltip(new Tooltip(tips));
	}
	
}
