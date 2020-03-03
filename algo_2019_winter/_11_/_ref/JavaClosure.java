package _ref;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

class JavaClosure {
    // public static void main(String[] args) {
    //     int answer = 14;
    //     Thread t = new Thread(
    //         () -> System.out.println(answer)
    //     );
    //     t.start();
    // }

    // public static void main(String[] args) {
    //     Thread t = new Thread(
    //         new Runnable(){
    //             int answer = 144;
    //             @Override
    //             public void run() {
    //                System.out.println(answer); 
    //             }
    //         }
    //     );
    //     t.start();
    // }

    public interface Provider {
        int provide();
    }

    public static Map<String, Provider> createCounter(int initValue) {
       int count = initValue; 
    //    Map<String, Provider> map = new HashMap<>();
    //    map.put("val", new Provider(){ public int provide() { return count; }});
    //    map.put("inc", new Provider(){ public int provide() { return count; }});
       Map<String, Provider> map = new HashMap<>();
       map.put("val", () -> { return count; });
       map.put("inc", () -> { return count; });
       return map;
    }
    

    public static void main(String[] args) {
        Map<String, Provider> map = createCounter(42);
        System.out.println(map.get("val").provide());
        System.out.println(map.get("inc").provide());

        closureTypeDemo3();
    }

    public interface NumToTextConverter {
        String convert(int x);
    }
    static void closureTypeDemo1() {
        String[] weeks = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
        NumToTextConverter textOfWeek = new NumToTextConverter() {
            @Override
            public String convert(int num) {
                return (num > 0 && num <= weeks.length) ? weeks[num - 1] : null;
            }
        };
        System.out.println(textOfWeek.convert(1));
    }
    static void closureTypeDemo2() {
        String[] weeks = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
        NumToTextConverter textOfWeek = (num) -> {
            return (num > 0 && num <= weeks.length) ? weeks[num - 1] : null;
        };
        System.out.println(textOfWeek.convert(1));

    }
    static void closureTypeDemo3() {
        String[] weeks = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
        Function<Integer, String> textOfWeek = (num) -> {
            return (num > 0 && num <= weeks.length) ? weeks[num - 1] : null;
        };
        System.out.println(textOfWeek.apply(1));
    }

    static void closureTypeDemo4() {
        textOfWeek().apply(1);
    }

    static Function<Integer, String> textOfWeek () {
        String[] weeks = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
        return num -> (num > 0 && num <= weeks.length) ? weeks[num - 1] : null;
    };

    static Function<Integer, String> getTextOfWeekDay(String[] weeks) {
        return num -> (num > 0 && num <= weeks.length) ? weeks[num - 1] : null;
    }
    static void closureTypeDemo5() {
        Function<Integer, String> getArabTextOfWeek = getTextOfWeekDay(
            new String[] { "Fri", "Sat", "Sun", "Mon", "Tue", "Wed", "Thu" }
        );
        Function<Integer, String> getIndianTextOfWeek = getTextOfWeekDay(
            new String[] { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" }
        );
        System.out.println(getArabTextOfWeek.apply(1));
        System.out.println(getIndianTextOfWeek.apply(1));
    }
    
}