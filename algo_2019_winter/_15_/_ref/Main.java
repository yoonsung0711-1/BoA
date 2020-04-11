import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
//    public interface Generator<T> { T next(); }
//
//    public class WeightQueGenerator implements Generator<WeightQueue>, Iterable<WeightQueue> {
//        class WeightQueueIterator implements Iterator<WeightQueue> {
//            public boolean hasNext() { return false; }
//            public WeightQueue next() { return null; }
//            public void remove() { }
//            public void forEachRemaining(Consumer<? super WeightQueue> action) { }
//        }
//        public WeightQueue next() { return null; }
//        @NotNull
//        public Iterator<WeightQueue> iterator() { return null; }
//        public void forEach(Consumer<? super WeightQueue> action) { }
//        public Spliterator<WeightQueue> spliterator() { return null; }
//    }
//
//    public class WeightQueue extends LinkedList<Integer>{ }

    public static void main(String[] args) {
        int[] weights =
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int day = 5;
        System.out.println(shipWithinDays(weights, day));
}

    public static int shipWithinDays(int[] weights, int day) {
//        Queue<Integer> que = new LinkedList<>();
//        Arrays.stream(weights).forEach(x -> que.add(x));
//        int avg = que.stream().reduce((acc, curr) -> acc + curr).get() / day;

        int avg = Arrays.stream(weights).sum() / day;
        Queue<Integer> que = Arrays.stream(weights).boxed().collect(Collectors.toCollection(LinkedList::new));

        Queue clone = que;
        Supplier queProvider = () -> new LinkedList<Integer>(clone);

//        Supplier queProvider = () -> Arrays.stream(weights).boxed().collect(Collectors.toCollection(LinkedList::new));

        int n;
        int capacity;
        do {
            que = (Queue<Integer>) queProvider.get();
            n = day;
            capacity = avg;
//            System.out.println("--------- capacity : " + (capacity) + "-----------");
            while (n != 0) {
                --n;
//                System.out.println("\t▷ day : " + (day - n));
                while (true) {
//                    System.out.println("\t- capacity: " + capacity + ", que: " + que);
                    if (que.size() == 0 || capacity - que.peek() < 0) break;
                    capacity = capacity - que.poll();
//                    System.out.println("\t- capacity: " + capacity + ", que: " + que);
                }
                capacity = avg;
//                System.out.println();
            }
            avg += 1;
        } while (que.size() > 0);

//        System.out.println("➤ min capacity: " + capacity);
        return capacity;
    }
}
