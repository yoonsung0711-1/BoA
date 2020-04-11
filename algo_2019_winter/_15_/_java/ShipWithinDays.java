import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ShipWithinDays {
    public static void main(String[] args) {
        int[] weights =
//                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                {3,2,2,4,1,4};

//        int day = 5;
        int day = 3;
        System.out.println(shipWithinDays(weights, day));
    }

    public static int shipWithinDays(int[] weights, int day) {
        int avg = Arrays.stream(weights).sum() / day;
        Queue<Integer> que = (Queue<Integer>) Arrays.stream(weights).boxed().collect(Collectors.toCollection(LinkedList::new));

        Queue<Integer> clone = que;
        Supplier<LinkedList<Integer>> queProvider = () -> new LinkedList<Integer>((Collection<? extends Integer>) clone);

        int n;
        int capacity;
        do {
            que = (Queue<Integer>) queProvider.get();
            n = day;
            capacity = avg;
            /* log
             */
            System.out.println("--------- capacity : " + (capacity) + "-----------");
            while (n != 0) {
                --n;
                /* log
                 */
                System.out.println("\t▷ day : " + (day - n));
                while (true) {
                    /* log
                     */
                    System.out.println("\t- capacity: " + capacity + ", que: " + que);
                    if (que.size() == 0 || capacity - que.peek() < 0) break;
                    capacity = capacity - que.poll();
                    /* log
                     */
                    System.out.println("\t- capacity: " + capacity + ", que: " + que);
                }
                capacity = avg;
                /* log
                 */
                System.out.println();
            }
            avg += 1;
        } while (que.size() > 0);

        /* log
         */
        System.out.println("➤ min capacity: " + capacity);
        return capacity;
    }
}
