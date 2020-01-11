// val tArr = [
//     [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]],
//     [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]],
//     [["ICN", "SFO"], ["SFO", "ICN"], ["ICN", "ATL"]]
// ]

// rArr = [
//     ["ICN", "JFK", "HND", "IAD"],
//     ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"],
//     ["ICN", "SFO", "ICN", "ATL"]
// ]

val tickets: List<List<List<String>>> = listOf(
    listOf( listOf("ICN", "JFK"), listOf("JFK", "HND"), listOf("JFK", "HND") ),
    listOf( listOf("ICN", "SFO"), listOf("ICN", "ATL"), listOf("SFO", "ATL"), listOf("ATL", "ICN"), listOf("ATL","SFO") ),
    listOf( listOf("ICN", "JFK"), listOf("JFK", "HND"), listOf("JFK", "HND") )
)

// val returns: List<List<List<String>>> = listOf(
//     listOf( listOf("ICN", "JFK"), listOf("JFK", "HND"), listOf("JFK", "HND") ),
//     listOf( listOf("ICN", "SFO"), listOf("ICN", "ATL"), listOf("SFO", "ATL"), listOf("ATL", "ICN"), listOf("ATL","SFO") ),
//     listOf( listOf("ICN", "JFK"), listOf("JFK", "HND"), listOf("JFK", "HND") )
// )

// fun traverse(arr: List<String>){
    // arr.flatten()

// }
    
fun main(){
    val alist = tickets[0].flatten().sorted()
    println(alist)
    val encode = mapOf<String, Int>()
    val decode = mapOf<Int, String>()
    var num : Int = 0
    for (airport:String in alist){
        if encode
    }
}