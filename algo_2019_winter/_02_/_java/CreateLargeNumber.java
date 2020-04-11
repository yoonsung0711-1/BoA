import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateLargeNumber {
    public static void main(String[] args) {
//        System.out.println(new CreateLargeNumber().solution("1924", 2));
//        System.out.println(new CreateLargeNumber().solution("1231234", 3));
    }
    public String solution(String number, int k) {
        // n 개의 자리수를 채워야 함
        int n = number.length() - k;
        int max = -1;
        int cursor = 0;
        /* alternative
        List<Character> picked = new ArrayList<>();
        */

        char[] picked = new char[number.length() - k];
        /* log */ List<Character> range = new ArrayList<>();

        while(n != 0) {
            System.out.println(String.format("n = %d", n));
            System.out.println(number.substring(cursor, number.length() - (n - 1)) + "|" + number.substring(number.length() - (n - 1), number.length()));
            if (n == (number.length() - cursor)) {
                for (int i = cursor; i < n; i++) {
                    /* alternative
                    picked.add(number.charAt(cursor));
                    */
                    picked[k - n] = number.charAt(cursor);
                }
            }
            for (int i = cursor; i < number.length() - (n - 1); i++) {
                /* log */ range.add(number.charAt(i));
                if ((number.charAt(i) - '0') > max) {
                    max = number.charAt(cursor = i) - '0';
                }
            }
            System.out.println("range: " + range);
            range.clear();
            /* alternative
            picked.add(number.charAt(cursor));
            */
            picked[number.length() - k - n] = number.charAt(cursor);
            System.out.println("max: " + max);
            System.out.println("picked: " + IntStream.range(0, picked.length)
                    .mapToObj(x -> { if (picked[x] == '\u0000') return null; else return picked[x]; })
                    .filter(x -> x != null)
                    .collect(Collectors.toList()) + "\n");
            max = -1;
            cursor++;
            n--;
        }
        /* alternative
        return picked.stream().map(x -> x.toString()).collect(Collectors.joining(""));
         */
        return new String(picked);
    }
}
