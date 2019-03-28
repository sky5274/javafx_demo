package com.fx.component;

import java.util.function.Consumer;

import javafx.scene.control.ButtonType;

public class AlertObjecAction<T> extends AlertAction<T>{
	private ActionFunctionn fail;
	private ActionFunctionn before;
	private ActionFunctionn complete;
	private Consumer<ButtonType> success;
	
	public AlertObjecAction(String title,T con,ActionFunctionn fail,ActionFunctionn before,ActionFunctionn complete,Consumer<ButtonType> success){
		super();
		super.setTitle(title);
		super.setContent(con);
		this.before=before;
		this.complete=complete;
		this.fail=fail;
		this.success=success;
	}
	
	public AlertObjecAction<T> content(T con) {
		this.setContent(con);
		return this;
	}
	
	@Override
	public void success(ButtonType btnType) {
		if(this.success!=null) {
			this.success.accept(btnType);
		}
	}

	@Override
	public void complete() {
		if(this.complete!=null) {
			this.complete.action();
		}
	}

	@Override
	public void fail() {
		if(this.fail!=null) {
			this.fail.action();
		}
	}

	@Override
	public void before() {
		if(this.before!=null) {
			this.before.action();
		}
	}
}
