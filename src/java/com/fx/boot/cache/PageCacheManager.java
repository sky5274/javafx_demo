package com.fx.boot.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import com.fx.boot.cache.SysCacheManager.CacheValue;

/**
 * 页面缓存
 *<p>Title: PageCacheManager.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 * @author sky
 * @date 2019年3月28日
 */
public class PageCacheManager {
	private static ConcurrentMap<String, CacheValue<CacheValue<?>>> cacheMap=new ConcurrentHashMap<>();
	
	public static <T> void put(Class<?> clazz,String key,T value) {
		put(clazz, key, value, null);
	}
	public static <T> void put(Class<?> clazz,String key,T value,Long timeOut) {
		CacheValue<CacheValue<?>> pageCache = cacheMap.get(clazz.getName());
		if(pageCache==null) {
			pageCache=new CacheValue<CacheValue<?>>(null);
		}
		CacheValue<T> cache = new CacheValue<T>(value, timeOut);
		pageCache.setData(cache);
		pageCache.setCreateTime(System.currentTimeMillis());
		cacheMap.put(clazz.getName(), pageCache);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T get(Class<?> clazz,String key) {
		CacheValue<CacheValue<?>> cache = cacheMap.get(clazz.getName());
		if(cache!=null) {
			CacheValue<?> cacheData = cache.getData();
			if(cacheData!=null ) {
				if(cacheData.isExprise()) {
					return (T) cacheData.getData();
				}
				cache.setData(null);
			}
		}
		return null;
	}
}
