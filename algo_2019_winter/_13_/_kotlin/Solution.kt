fun main(){
    var a = Solution();
    println( a.longestStrChain(arrayOf("ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru")));
}

data class Node(var value: String, var next: Node? = null)

class Solution() {
    fun longestStrChain(words: Array<String>): Int {
        var maxLen: Int = -1;
        words.sortWith(Comparator{ a, b  -> a.length - b.length });

        var node: Node?;
        var prev: Node?;
        var next: Node? = null;

        Node(words[0], null).let {
            node = it
            prev = it
        };

        for ( (index, word) in words.withIndex() ) {
            if (index == 0) continue
            var curr = Node(words[index], next) ;
            prev!!.next = curr;
            prev = curr;
        }


        var memo: MutableMap<String?, Int> = mutableMapOf<String?, Int>();
        var cursor: Node? = node;

        var max: Int = -1;
        memo[cursor!!.value] = 1;
        cursor = cursor!!.next;

        while(true) {
           if (cursor == null) break;
            max = -1;
            for (index in cursor.value.indices) {
                var wordMinusOneChr: String = cursor.value
                        .split("")
                        .mapIndexed { i, s ->  if (index + 1 == i)  ""  else  s; }
                        .joinToString("");
//                println("$index, ${cursor.value}, $wordMinusOneChr");
                var ret: Int = memo.getOrDefault(wordMinusOneChr, 0) + 1;
                if (ret > max) max = ret;
            }
            memo[cursor.value] = max;
            cursor = cursor.next;
        }

        memo.forEach { (_, v) -> if (v > maxLen) {maxLen = v; }}
        return maxLen;
    }
}



