package com.fx.boot.cache;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 全局缓存
 *<p>Title: SysCacheManager.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 * @author sky
 * @date 2019年3月28日
 */
public class SysCacheManager {
	private static ConcurrentMap<String, CacheValue<?>> cacheMap=new ConcurrentHashMap<>();
	
	public static <T extends Object> void put(String key,T value) {
		put(key,value,null);
	}
	public static <T extends Object> void put(String key,T value,Long timeOut) {
		cacheMap.putIfAbsent(key, new CacheValue<T>(value,timeOut));
	}
	
	public static <T extends Object> T get(String key) {
		@SuppressWarnings("unchecked")
		CacheValue<T> cache = (CacheValue<T>) cacheMap.get(key);
		if(cache!=null && cache.isExprise()){
			return cache.getData();
		}
		if(cache !=null) {
			cacheMap.remove(key);
		}
		return null;
	}
	
	
	public static class CacheValue<T> implements Serializable{
		/****/
		private static final long serialVersionUID = 1L;
		private Long createTime;
		private T data;
		private Long timeOut;
		public CacheValue(T data) {
			this.setData(data);
			this.setCreateTime(System.currentTimeMillis());
		}
		public CacheValue(T data,Long timeOut) {
			this.setData(data);
			this.setCreateTime(System.currentTimeMillis());
			this.setTimeOut(timeOut);
		}
		public Long getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Long createTime) {
			this.createTime = createTime;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Long getTimeOut() {
			return timeOut;
		}
		public void setTimeOut(Long timeOut) {
			this.timeOut = timeOut;
		}
		
		public boolean isExprise() {
			if(this.timeOut==null) {
				return true;
			}else {
				return this.timeOut>System.currentTimeMillis()-this.createTime;
			}
		}
	}
}
