package Misc;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Ashutosh
 */
public class WeekConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {
    private Map<K,Long> timeMap = new ConcurrentHashMap<K, Long>();
    private long expiredTime = 1000L;
    
    public WeekConcurrentHashMap() {
        initialize();
    }
    public WeekConcurrentHashMap(long expiredTime) {
        this.expiredTime = expiredTime;
        initialize();
    }
    private void initialize(){
        new ClearCache().start();
    }
    private void cleanup(){
        long currentTime = System.currentTimeMillis();
        for(K key : timeMap.keySet()){
             if (currentTime > (timeMap.get(key) + expiredTime)) {
                 System.out.println("Removing : "+ timeMap.remove(key));
            }
        }
    }
    public V put(K key , V value){
        timeMap.put(key, new Date().getTime());
        V retrunVal = super.put(key, value);
        return retrunVal;
    }
    private class ClearCache extends Thread{
        @Override
            public void run() {
                cleanup();
                try{
                while(true){
                    Thread.sleep(expiredTime/2);
                }
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
            }
    }
}

class WeekConcurrentHashMapTest {
   public static void main(String[] args) throws InterruptedException {
       WeekConcurrentHashMap weekMap = new WeekConcurrentHashMap();
       HashMap map = new HashMap();
       weekMap.put("eBay", "eBay");
       weekMap.put("Paypal", "Paypal");
       weekMap.put("Google", "Google");
//       weekMap.put(map, 1);
        System.out.println("Current Map ::"+weekMap);
        Thread.sleep(10000);
        System.out.println("After Sometime ::"+weekMap);
    } 
}
