package algo_2019_winter._03_;
import java.util.ArrayList;

public class Cache{
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
        
        for (int i = 0; i < 6; i++) {
            if (execTime[i] == caching(cacheSizes[i], citiesArr[i])){
                System.out.println("test " + (i + 1) + " passed");
            } else {
                System.out.println("test " + (i + 1) + " failed");
            }
        }
    }

    public static int caching(int cacheSize, String[] cities){
        int t = 0; 
        ArrayList<String> cache = new ArrayList<>();
        for (String city : cities){
            if (cacheSize == 0) {
                t += 5;
                continue;
            }
            city = city.toLowerCase();
            if (cache.contains(city)){
                t += 1;       
                cache.remove(city);
                cache.add(city);
            }
            if (!cache.contains(city)){
                t += 5;
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                }
                cache.add(city);
            }
        }
        return t;
    }
}