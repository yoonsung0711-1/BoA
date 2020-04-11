fun main(args: Array<String>) {
//    solution("1924", 2)
//    solution("1231234", 3)
}

public fun solution(number: String, k: Int): Unit {
    var n = number.length - k
    var max = -1
    var cursor = 0
    /* alternative
    var picked: List<Char> = ArrayList<Char>();
    */
    var picked: CharArray = CharArray(5)
    /* */ var range: ArrayList<Char> = ArrayList<Char>()

    while (n != 0) {
        println("n = $n")
        println(number.substring(cursor, number.length - (n - 1)) + "|" + number.substring(number.length - (n - 1), number.length));
        if (n == (number.length - cursor)) {
            for (i in cursor..n) {
                /* alternative
                picked = picked.plus(number[cursor])
                */
                picked[k - n] = number[cursor]
            }
        }
        for (i in cursor until number.length - (n - 1)) {
            /* log */ range.add(number[i])
            if ((number[i] - '0') > max) {
                cursor = i
                max = number[cursor] - '0'
            }
        }
        println("range: $range")
        range.clear()

        /* alternative
        picked = picked.plus(number[cursor])
        */

        picked[number.length - k - n] = number[cursor]
        println("max: $max")
        println("picked: ${picked.filter { it -> it != '\u0000' } }\n")
        //println("picked: ${picked.joinToString (separator = ""){ it -> (if (it == '\u0000') ""; else "$it").toString();  }}")
        max = -1
        cursor++
        n--
    }
    /* alternative
    return picked.stream().map(x -> x.toString()).collect(Collectors.joining(""));
     */

}
