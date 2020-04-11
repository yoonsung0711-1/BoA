import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Combination {
    static String[][] data = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
            { "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
            { "600", "apeach", "music", "2" } };
    static ArrayList<ArrayList<String>> relation = new ArrayList<>();
    static {
        for (int i = 0; i < data.length; i++) {
            ArrayList<String> tuple = new ArrayList<>();
            for (int j = 0; j < data[0].length; j++) {
                tuple.add(j, data[i][j]);
            }
            relation.add(tuple);
        }
    }
    static int m = relation.size();
    static int n = relation.get(0).size();
    static boolean[] flags = new boolean[n];
    static ArrayList<ArrayList<String>> candidate_keys = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("--combination--");
        for (int i = 1; i <= n; i++) {
            backtrack(0, i);
        }

        System.out.println("\n--candidate_keys--");
        System.out.println(candidate_keys.toString());
    }

    static void backtrack(int s, int r) {
        if (r == 0) {
            SortedSet<String> attr_strs = new TreeSet<>();
            StringBuilder strbldr;
            for (int i = 0; i < m; i++) {
                strbldr = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (flags[j] == true) strbldr.append(relation.get(i).get(j) + "-");
                }
                attr_strs.add(strbldr.toString().substring(0, strbldr.length() - 1));
            }

            List<String> attr_subs = IntStream.range(0, n).mapToObj(i -> {
                if (flags[i]) return Integer.toString(i);
                else return null;
            })
            .collect(Collectors.toList()).stream()
            .filter(x -> x != null).collect(Collectors.toList());

            for (boolean f : flags) {
                System.out.print(f + " ");
            }
            System.out.println(attr_subs);
            // System.out.println(attr_strs);

            if (attr_strs.size() == m) {
                if (candidate_keys.size() == 0) {
                    candidate_keys.add(new ArrayList(attr_subs));
                }
                boolean isSubset = candidate_keys.stream().anyMatch(c-> c.stream().filter(x-> attr_subs.contains(x)).collect(Collectors.toList()).size() == c.size());
                if (!isSubset) {
                    candidate_keys.add(new ArrayList(attr_subs));
                }
            }
            return;
        } else {
            for (int i = s; i < n; i++) {
                flags[i] = true;
                backtrack(i + 1, r - 1);
                flags[i] = false;
            }
        }
    }

}
