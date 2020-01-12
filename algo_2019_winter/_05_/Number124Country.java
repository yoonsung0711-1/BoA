package algo_2019_winter._05_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

class Number124Country {
    public static final HashMap<Integer, Integer> e = new HashMap<>() {
        private static final long serialVersionUID = 7603686693003980265L;
        {
            put(1, 1);
            put(2, 2);
            put(0, 4);
        }
    };

    public static ArrayList<Integer> get124_head(ArrayList<Integer> l, int num) {
        if (num == 0) {
            return l;
        }
        int q = num / 3;
        int r = num - 3 * q;
        if (r == 0) {
            q = q - 1;
        }
        l.add(0, Number124Country.e.get(r));
        return get124_head(l, q);
    }

    private static ArrayList<Integer> get124_tail(ArrayList<Integer> l, int num) {
        if (num == 0) {
            return l;
        }
        int q = num / 3;
        int r = num - 3 * q;
        if (r == 0) {
            q = q - 1;
        }
        l = get124_tail(l, q);
        l.add(Number124Country.e.get(r));
        return l;
    }

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        String result = get124_head(l, 11).stream().map(Object::toString).collect(Collectors.joining(""));
        System.out.println(result);
        l.clear();

        result = get124_tail(l, 11).stream().map(Object::toString).collect(Collectors.joining(""));
        System.out.println(result);
        l.clear();
    }

}