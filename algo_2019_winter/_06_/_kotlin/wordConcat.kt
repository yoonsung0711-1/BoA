fun main(args: Array<String>) {
    val wordsets: Array<Array<String>> = arrayOf(
            arrayOf("tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"),
            arrayOf("hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"),
            arrayOf("hello", "one", "even", "never", "now", "world", "draw"))
    val nums = arrayOf(3, 5, 2)
    solution(nums[2], wordsets[2])
}

fun solution(num: Int, words: Array<String>): Int {
    val iter: Iterator<String> = words.iterator()
    var n = 1
    val padding = StringBuilder()
    var item = ""

    out@ while (iter.hasNext()) {
        if (item == "") {
            item = iter.next();
        } else {
            if (item.get(item.length - 1) != iter.next().let { it -> item = it; it.get(0) }) {
                /* log / println("$item (x)") */
                break@out
            } else {
                if (words.toList().subList(0, n - 1).contains(item)) {
                    /* log / println("$item (x)") */
                    break@out
                }
            }
            /* log /
            if (n % num != 0) {
                padding.append(" ".repeat(item.length-1));
            } else {
                padding.setLength(0);
            }
            print(item + "\n" + padding.toString());
             */
            n++;
        }
    }
    println(n)
    return n
}

