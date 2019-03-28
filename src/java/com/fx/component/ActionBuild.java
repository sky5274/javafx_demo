package com.fx.component;

import java.util.function.Consumer;

import javafx.scene.control.ButtonType;

/**
 * 提示\警告信息建筑器
 *<p>Title: ActionBuild.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 * @author sky
 * @date 2019年3月28日
 * @param <T>
 */
@SuppressWarnings("restriction")
public class ActionBuild <T>{
	private String title;
	private T content;
	private ActionFunctionn fail;
	private ActionFunctionn before;
	private ActionFunctionn complete;
	
	private Consumer<ButtonType> success;
	public ActionFunctionn getFail() {
		return fail;
	}
	public ActionFunctionn getBefore() {
		return before;
	}
	public ActionFunctionn getComplete() {
		return complete;
	}
	public Consumer<ButtonType> getSuccess() {
		return success;
	}

	public ActionBuild<T> title(String title){
		this.title=title;
		return this;
	}
	public ActionBuild<T> content(T content){
		this.content=content;
		return this;
	}

	public ActionBuild<T> success(Consumer<ButtonType> success) {
		this.success=success;
		return this;
	}
	public ActionBuild<T> complete(ActionFunctionn complete) {
		this.complete=complete;
		return this;
	}
	public ActionBuild<T> fail(ActionFunctionn fail) {
		this.fail=fail;
		return this;
	}
	public ActionBuild<T> before(ActionFunctionn before) {
		this.before=before;
		return this;
	}
	public AlertObjecAction<T> build(){
		return new AlertObjecAction<T>(this.title, this.content, fail, before, complete, success);
	}

}
