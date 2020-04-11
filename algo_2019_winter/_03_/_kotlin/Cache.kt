import java.util.*
import java.util.stream.Collectors

fun main(args: Array<String>) {
    caching(3, arrayOf("Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"))
}

fun caching(cacheSize: Int, cities: Array<String>): Int {
    /* java-style/
    println("cities: ${Arrays.stream(cities).collect(Collectors.toList())}")
     */
    println("cities: ${cities.toList()}")
    println("cacheSize = $cacheSize + \n")
    var n: Int = cities.size
    var t: Int = 0
    val cache: ArrayList<String> = ArrayList<String>()
    /* java-style/
    val citiArr : List<String> = Arrays.stream(cities).collect(Collectors.toList())
    val citiArr: ArrayList<String> = cities.toCollection(ArrayList())
    */
    val citiArr: List<String> = cities.toList()
    val i: Iterator<String> = citiArr.iterator()
    var city: String
    while (i.hasNext()) {
        println("n = $n")
        city = i.next()
        println("before: $cache")
        if (!cache.contains(city)) {
            println("\t* $city cache miss +5")
            t += 5
            if (cache.size == cacheSize) {
                cache.removeAt(0)
            }
            cache.add(city)
            println("after: $cache")
            println("\t* execution: $t\n")
            n--
            continue
        }
        city = city.toLowerCase()
        if (cache.contains((city))) {
            println("\t* $city cache hit +1")
            t += 1
            cache.remove(city)
            cache.add(city)
            println("after: $cache")
            println("\t* execution: $t\n")
            n--
        }
        /* remove last called element: not available in kotlin */
    }
    return t
}