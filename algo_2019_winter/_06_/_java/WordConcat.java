import java.util.Arrays;
import java.util.Iterator;

public class WordConcat {
//    public static void main(String[] args) {
//        String[][] wordsets = {
//            {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"},
//            {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"},
//            {"hello", "one", "even", "never", "now", "world", "draw"}};
//        int nums[] = {3, 5, 2};
//        new Main().solution(nums[2], wordsets[2]);
//
//    }
    public void solution(int num, String[] words) {
        Iterator<String> iter = Arrays.asList(words).iterator();
        int n = 1;
        StringBuilder padding = new StringBuilder();
        String item = "";

        label:
        while (iter.hasNext()) {
            if (item == "") {
                item = iter.next();
            } else {
                if ((item.charAt(item.length() - 1) != (item = iter.next()).charAt(0))) {
                    /* System.out.println(item + "(x)"); */
                    break label;
                } else {
                    if (Arrays.asList(words).subList(0, n - 1).contains(item)) {
                        /* System.out.println(item + "(x)"); */
                        break label;
                    }
                }
            }
            /* log /
            if (n % num != 0) {
                padding.append(" ".repeat(item.length()-1));
            } else {
                padding.setLength(0);
            }
            System.out.print(item + "\n" + padding.toString());
             */
            n++;
        }
        System.out.println(n);
    }
}
