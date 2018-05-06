package Misc;

public class InmemoryCacheTest {

    public static void main(String[] args) {
        InmemoryCache<String, String> cache = new InmemoryCache<>(200, 500, 6);
        cache.put("eBay", "eBay");
        cache.put("Paypal", "Paypal");
        cache.put("Google", "Google");
        cache.put("Microsoft", "Microsoft");
        cache.put("IBM", "IBM");
        cache.put("Facebook", "Facebook");

        System.out.println("6 Cache Object Added.. cache.size(): " + cache.size());
        cache.remove("IBM");
        System.out.println("One object removed.. cache.size(): " + cache.size());

        cache.put("Twitter", "Twitter");
        cache.put("SAP", "SAP");
        System.out.println("Two objects Added but reached maxItems.. cache.size(): " + cache.size());
        cache.cleanup();

        /**
         * *
         * Testing cleanup time of cache Test with timeToLiveInSeconds = 100
         * seconds timerIntervalInSeconds = 100 seconds maxItems = 500000
         */
        int size = 500000;
        cache = new InmemoryCache<String, String>(100, 100, size);

        for (int i = 0; i < size; i++) {
            String value = Integer.toString(i);
            cache.put(value, value);
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long start = System.currentTimeMillis();
        cache.cleanup();
        double finish = (double) (System.currentTimeMillis() - start) / 1000.0;

        System.out.println("Cleanup times for " + size + " objects are " + finish + " s");

    }
}
