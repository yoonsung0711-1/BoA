import java.util.function.Supplier

fun main(args: Array<String>) {
    val weights: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    val day = 5;

    println(shipWithinDaysKt(weights, day));
}

interface IQueue<T> {
    fun enqueue(item: T)
    fun poll(): T?
    fun size(): Int
    fun peek(): T?
    fun isEmpty(): Boolean
}

fun shipWithinDaysKt(weights: Array<Int>, day: Int): Int {
    var avg = weights.sum() / day

    class QueueImpl : IQueue<Int> {
        val list = mutableListOf<Int>()

        constructor(arr: Array<Int>) {
            for (i in arr) {
                list.add(i);
            }
        }

        override fun enqueue(item: Int) {
            list.add(item)
        }

        override fun poll(): Int? {
            if (!isEmpty()) {
                return list.removeAt(0)
            }; return null
        }

        override fun size(): Int {
            return list.size
        }

        override fun peek(): Int? {
            if (!list.isEmpty()) {
                return list[0]
            }; return null
        }

        override fun isEmpty(): Boolean {
            return list.size == 0
        }

        override fun toString(): String {
            return list.toString()
        }
    }

    var que: QueueImpl

    val queProvider = object : Supplier<IQueue<Int>> {
        override fun get(): IQueue<Int> {
            return QueueImpl(weights)
        }
    }

    var n: Int
    var capacity: Int
    do {
        que = queProvider.get() as QueueImpl
        n = day;
        capacity = avg;
        /* log/
         */
        println("--------- capacity :  $capacity -----------")
        while (n != 0) {
            --n;
            /* log/
             */
            println("\t▷ day : ${day - n}");
            while (true) {
                /* log /
                */
                println("\t- capacity: $capacity, que: $que");
                if (que.size() == 0 || capacity - que.peek()!! < 0) break;
                capacity -= que.poll()!!;
                /* log/
                */
                println("\t- capacity: $capacity , que: $que");
            }
            capacity = avg;
            /* log
            */
            println();
        }
        avg += 1;
    } while (que.size() > 0);

    /* log
    */
    println("➤ min capacity: $capacity");
    return capacity;
}
