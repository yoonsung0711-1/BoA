val cArr: List<List<List<String>>> 
    = listOf(
        listOf(listOf("yellow_hat", "headgear"), listOf("blue_sunglasses", "eyewear"), listOf("green_turban", "headgear")),
        listOf(listOf("crow_mask", "face"), listOf("blue_sunglasses", "face"), listOf("smoky_makeup", "face"))
    )

fun solution(clothes: List<List<String>>):Int{
    val category = mutableMapOf<String, MutableList<String>>()
    val nums = mutableListOf<Int>()

    for (c in clothes) {
        val key = c[1]
        if (category.get(key) == null) {
            val l = mutableListOf<String>()
            l.add(c[0])
            category[key] = l 
        } else {
            val l: MutableList<String> = category.get(key)!!
            l.add(c[0])
        }
    }

    for (k in category.keys) {
        nums.add(category[k]!!.size)
    }

    if (nums.size == 1) {
        return nums[0]
    } else {
        return nums.fold(1) {x:Int, y:Int -> x * (y + 1)} - 1
    }
}

fun main(args: Array<String>) {
    println(solution(cArr[0]))
}