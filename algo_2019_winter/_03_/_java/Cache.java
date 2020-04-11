import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cache {
    public static void main(String[] args){
        int[] cacheSizes = {3, 3, 2, 5, 2, 0};
        String[][] citiesArr = { 
            {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"},
            {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"},
            {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"},
            {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"},
            {"Jeju", "Pangyo", "NewYork", "newyork"},
            {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"} 
        };
        int[] execTime = {50, 21, 60, 52, 16, 25};
        
        for (int i = 0; i < 1; i++) {
            if (execTime[i] == caching(cacheSizes[i], citiesArr[i])){
//                System.out.println("test " + (i + 1) + " passed");
            } else {
//                System.out.println("test " + (i + 1) + " failed");
            }
        }
    }

    public static int caching(int cacheSize, String[] cities){
        System.out.println("cities:" + Arrays.stream(cities).collect(Collectors.toList()));
        System.out.println("cacheSize = " + cacheSize + "\n");
        int n = cities.length;
        int t = 0;
        ArrayList<String> cache = new ArrayList<>();
        List<String> citiArr = Arrays.stream(cities).collect(Collectors.toList());
//        ArrayList<String> citiArr = Arrays.stream(cities).collect(Collectors.toCollection(ArrayList::new));
        Iterator<String> i = citiArr.iterator();
        String city;
        while (i.hasNext()) {
            System.out.println("n = " + n);
            city = i.next();
            System.out.println(String.format("before: ") + cache);
            if (!cache.contains(city)) {
                System.out.println(String.format("\t* %s cache miss +5", city));
                t += 5;
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                }
                cache.add(city);
                System.out.println(String.format("after: %s", cache));
                System.out.println(String.format("\t* execution: %s\n", t));
                n--;
                continue;
            }
            city = city.toLowerCase();
            if (cache.contains((city))) {
                System.out.println(String.format("\t* %s cache hit +1", city));
                t += 1;
                cache.remove(city);
                cache.add(city);
                System.out.println(String.format("after: %s", cache));
                System.out.println(String.format("\t* execution: %s\n", t));
                n--;
            }
            /* remove last called element: available in java/
            i.remove();
            */
        }
        return t;
    }
}