
## 여행경로

https://programmers.co.kr/learn/courses/30/lessons/43164

#### 문제 설명

주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 ICN 공항에서 출발합니다.

항공권 정보가 담긴 2차원 배열 `tickets`가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

#### 제한사항

* 모든 공항은 알파벳 대문자 3글자로 이루어집니다.
* 주어진 공항 수는 3개 이상 10,000개 이하입니다.
* `tickets`의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
* 주어진 항공권은 모두 사용해야 합니다.
* 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
* 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.

#### 입출력 예
| tickets | result |
| :--- | :--- |
| [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]] | ["ICN", "JFK", "HND", "IAD"] |
| [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]] | ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] |
| [["ICN", "BOO"], ["ICN", "COO"], ["COO", "ICN"]] | ["ICN", "COO", "ICN", "BOO"] |
| [["ICN", "COO"], ["ICN", "BOO"], ["COO", "ICN"], ["BOO", "DOO"]] | ["ICN", "COO", "ICN", "BOO", "DOO"] |

#### 입출력 예 설명

##### 예제 #1

["ICN", "JFK", "HND", "IAD"] 순으로 방문할 수 있습니다.

##### 예제 #2

["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] 순으로 방문할 수도 있지만 ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 가 알파벳 순으로 앞섭니다.


## 풀이

깊이 우선 탐색<sup>`DFS, Depth-First Search`</sup>

#### 예제 1

<!-- ![Imgur](https://i.imgur.com/CarNp9W.png) -->

```
ICN = [JFK]
JFK = [HND]
HND = [IAD]
```

#### 예제 2

<!-- ![Imgur](https://i.imgur.com/kdj9ZpC.png) -->


```
ICN = [ATL, SFO]
ATL = [ICN, SFO]
SFO = [ATL]
```

#### 예제 3

<!-- ![](https://i.imgur.com/Ss0Rbr2.png) -->

<!-- 여기서부터가 문제가 되는데... 

1. 주어진 항공권은 모두 사용해야 합니다.
2. 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
3. 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다. -->

<!-- 위 조건을 **모두** 만족해야 한다.

`ICN → BOO`가 아닌 `ICN → COO  → ICN → BOO`가 되어야 한다. `조건2`보다 `조건1`이 우선시 되었다.

그래서 `ICN → BOO`까지 이동 후 더이상 갈 곳이 없다면 **모든 도시를 방문했는지 판단**한 후 완성 되지 않았을 경우 `BOO`로 이동했던 것을 취소해야 했다.  -->

```
COO = [ICN]
ICN = [BOO, COO]

```

#### 예제 4

<!-- ![](https://i.imgur.com/QU2i5jX.png) -->

<!-- `ICN → BOO → DOO` 까지 이동 후 `BOO → DOO` 이동을 취소 후 `ICN → COO`로 이동해야 한다. -->

```
COO = [ICN]
BOO = [DOO]
ICN = [BOO, COO]

```

#### 예제 5

![](https://i.imgur.com/r7Ass0w.png)

```
COO = [DOO]
BOO = [COO]
EOO = [FOO]

```

#### 코드 및 실행결과
* [실패](travel_route_tail_recursion.py) : 파이썬으로 작성한 코드  
  ![결과](travel_route_result_tail_recursion_python.png)

* [성공](travel_route_head_recursion.py) : 파이썬으로 작성한 코드  
  ![결과](travel_route_result_head_recursion_python.png)

### 보충자료
* [알고리즘-공부4-한붓그리기(Eulerian-circuit)](https://sonsh0824.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B3%B5%EB%B6%804-%ED%95%9C%EB%B6%93%EA%B7%B8%EB%A6%AC%EA%B8%B0Eulerian-circuit)
