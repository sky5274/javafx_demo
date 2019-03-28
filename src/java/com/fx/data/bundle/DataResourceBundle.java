package com.fx.data.bundle;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Vector;

import com.fx.boot.stage.FlowStage;

import javafx.stage.Stage;

/**
 * 自定义页面数据请求数据携带
 *<p>Title: DataResourceBundle.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 * @author sky
 * @date 2019年3月28日
 * @param <T>
 */
public class DataResourceBundle<T> extends ResourceBundle{
	private Map<String, Object> map=new HashMap<>();
	private T controller;
	private Stage stage;
	public DataResourceBundle() {}
	public DataResourceBundle(FlowStage stage) {
		this.stage=stage;
	}
	public DataResourceBundle(FlowStage stage,T controller) {
		this.stage=stage;
		this.setController(controller);
	}
	public DataResourceBundle(FlowStage stage,Map<String, Object> map) {
		this.stage=stage;
		this.map=map;
	}
	public DataResourceBundle(FlowStage stage,Map<String, Object> map,T controller) {
		this.stage=stage;
		this.map=map;
		this.setController(controller);
	}
	
	
	public void setData(Map<String, Object> data) {
		this.map=data;
	}
	
	public Collection<Object> getValues() {
		return this.map.values();
	}
	
	public Object get(String key) {
		return this.map.get(key);
	}
	
	public DataResourceBundle<T> put(String key,Object value) {
		this.map.put(key, value);
		return this;
	}
	@Override
	protected Object handleGetObject(String key) {
		Object value = map.get(key);
		if(value ==null) {
			value=super.getObject(key);
		}
		return value;
	}
	@Override
	public Enumeration<String> getKeys() {
		Vector<String> keys=new Vector<String>();
		super.keySet().stream().forEach(it->keys.add(it));
		return keys.elements();
	}
	public T getController() {
		return controller;
	}
	public void setController(T controller) {
		this.controller = controller;
	}
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
