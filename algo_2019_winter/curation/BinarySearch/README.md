## 이분 탐색

> 이분 탐색(Binary Search)은 `__정렬된 배열__` 내에서 특정한 값의 위치를 찾는 탐색 알고리즘을 말하며,  
> 근 또는 값을 찾아가는 방식이 수학에서의 이분법(Bisection Method)과 매우 유사함  
> 탐색 방식은 배열의 중간 위치에 있는 값을 목표값과 비교한 뒤, [1]목표값과 일치하면 해당 위치를 반환하고   
> [2]목표값이 작으면 반분한 구간 중 작은 구간에서, [3]목표값보다 크면 반분한 구간 중 큰 구간에서 탐색을   
> 반복함

#### 공간복잡도

* 먼저 하한, 상한, 중간값을 저장할 세 개의 pointer가 필요함 O(3)
* 그리고 N개의 요소를 담을 배열이 필요하기 때문에 O(N)의 공간복잡도가 요구됨

#### 시간복잡도

* N개의 크기를 가진 배열을 이진 탐색하면 N -> N/2 -> N/4 -> ... -> 1으로 개수가 줄어듦
* k번 이분할 한 결과로 1이 되었다고 하면 2^k = 1
* 즉 k = log(2)N로 이분 탐색의 시간 복잡도는 O(logN)임

#### 단점

* 이진 탐색을 위해 배열을 정렬함에 있어서 삽입과 정렬 연산이 필요한 경우 O(n) 시간이 소요되기 때문에 매우 비효율적임
* 트리는 이진 탐색 원리에 기반한 자료구조임 
    * 탐색시 이진 탐색과 유사한 알고리즘을 사용하여 평균 시간복잡도 O(logN)의 성능을 보임
    * 한편 삽입 및 삭제 연산시에는 이진 탐색보다 향상된 O(logN)의 시간 복잡도의 성능을 보임
    * 하지만 트리의 균형이 편중될 경우 탐색 성능이 악화될 수 있음

#### 관련 문제들

* __전형적인 문제__
    * [Binary Search](./binarySearch.md)

* __Easy__
    * [Heaters](./easy/heaters.md)
    * [Is Subsequence](./easy/isSubsequence.md)

* __Medium__
    * [Capacity To Ship Packages Within D-Days](./medium/capacityToShipPackagesWithinD_Days.md)
    * [Search 2D Matrix](./medium/search2DMatrix.md)

* __Hard__
    * [Maximum Profit in Job Scheduling](./hard/maximumProfitInJobScheduling.md)

#### 더 공부할 내용

* [이진 트리와의 비교](https://www.quora.com/Why-would-you-use-a-binary-tree-over-an-array-Is-it-mostly-language-dependent-In-what-cases-or-languages-would-you-always-use-a-tree-Lastly-is-it-all-about-memory-performance)




