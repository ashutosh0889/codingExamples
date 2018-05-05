package Misc;

import java.util.ArrayList;

import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.map.LRUMap;

public class InmemoryCache<K,T> {
	private long timeToLive;
	private LRUMap inmemoryCacheMap;
	
	private class CacheObject{
		long lastAccsessTime = System.currentTimeMillis();
		T value;
		CacheObject(T value){
			this.value = value;
		}
	}
	public InmemoryCache(long timeToLive,final long timeInterval,int maxItems){
		this.timeToLive = (timeToLive * 1000);
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(timeInterval * 1000);
				}catch(InterruptedException ie) {}
				cleanup();
			}
		});
		thread.setDaemon(true);
		thread.start();
	}
	
	public void put(K key,T value) {
		synchronized(inmemoryCacheMap) {
			inmemoryCacheMap.put(key, value);
		}
	}
	
	public T get(K key) {
		synchronized(inmemoryCacheMap) {
			CacheObject c = (CacheObject) inmemoryCacheMap.get(key);
			if(c == null)
				return null;
			return c.value;
		}
	}
	
	public void remove(K key) {
		synchronized(inmemoryCacheMap) {
			inmemoryCacheMap.remove(key);
		}
	}
	
	public void cleanup() {
		long now = System.currentTimeMillis();
		ArrayList deleteKeys = new ArrayList<K>();
		synchronized(inmemoryCacheMap) {
			MapIterator itr = inmemoryCacheMap.mapIterator();
			K key = null;
			CacheObject c = null;
			while(itr.hasNext()) {
				key = (K) itr.next();
				c = (CacheObject) itr.getValue();
				if(c!=null && now > (timeToLive + c.lastAccsessTime)) {
					deleteKeys.add(key);
				}
			}
		}	
			for(Object key : deleteKeys) {
				synchronized(inmemoryCacheMap) {
					inmemoryCacheMap.remove((K)key);
				}
			}
			Thread.yield();
	}
}
