## 여행경로

https://programmers.co.kr/learn/courses/30/lessons/43164


### 풀이

##### 예제 1

```ts
----------------------------------------------
tickets <- [[ICN, JFK], [HND, IAD], [JFK, HND]]    
ordered -> [[HND, IAD], [ICN, JFK], [JFK, HND]]    
----------------------------------------------

# start from ICN
[ICN -> JFK]
tickets: [[HND, IAD], [JFK, HND]]
holding: [[ICN, JFK]]
pos: JFK

[JFK -> HND]
tickets: [[HND, IAD]]
hodling: [[ICN, JFK], [JFK, HND]]
pos: HND

[HND -> IAD]
tickets: [[]]
hodling: [[ICN, JFK], [JFK, HND]]
pos: IAD

* route: [ICN, JFK, HND, IAD]

```

##### 예제 2

```ts
----------------------------------------------
tickets <- [[ICN, SFO], [ICN, ATL], [SFO, ATL], [ATL, ICN], [ATL, SFO]]
ordered -> [[ATL, ICN], [ATL, SFO], [ICN, ATL], [ICN, SFO], [SFO, ATL]]
----------------------------------------------

# start from ICN
[ICN -> ATL]
tickets: [[ICN, SFO], [SFO, ATL], [ATL, ICN], [ATL, SFO]]
holding: [[ICN, ATL]]
pos: ATL

[ATL -> ICN]
tickets: [[ICN, SFO], [SFO, ATL], [ATL, SFO]]
holding: [[ICN, ATL], [ATL, ICN]]
pos: ICN

[ICN -> SFO]
tickets: [[SFO, ATL], [ATL, SFO]]
hodling: [[ICN, JFK], [JFK, HND], [ICN, SFO]]
pos: SFO

[SFO -> ATL]
tickets: [[ATL, SFO]]
hodling: [[ICN, JFK], [JFK, HND], [ICN, SFO], [SFO, ATL]]
pos: ATL

[ATL -> SFO]
tickets: []
hodling: [[ICN, JFK], [JFK, HND], [ICN, SFO], [SFO, ATL], [ATL, SFO]]
pos: SFO

* route: [ATL, ICN, SFO, ATL, SFO]

```

##### 예제 3

```ts
-------------------------------------------------
tickets <- [[ICN, BOO], [ICN, COO], [COO, ICN]]
ordered -> [[COO, ICN], [ICN, BOO], [ICN, COO]]
-------------------------------------------------

# start from ICN
[ICN -> BOO]
tickets <- [[ICN, COO], [COO, ICN]]
holding: [[ICN, BOO]]
pos: BOO

no route and 2 tickets left

# start from ICN
[ICN -> COO]
tickets: [[ICN, BOO], [COO, ICN]]
holding: [[ICN, COO]]
pos: COO

[COO -> ICN]
tickets: [[ICN, BOO]]
holding: [[ICN, COO], [COO, ICN]]
pos: ICN

[ICN -> BOO]
tickets: []
holding: [[ICN, COO], [COO, ICN], [ICN, BOO]]
pos: BOO

* route: [ICN, COO, ICN, BOO]

```

##### 예제 4

```ts
```

##### 예제 5

```ts
```

#### 코드 및 실행결과

* [성공](travel_route_head_recursion.py) : 파이썬으로 작성한 코드  
  ![결과](travel_route_result_head_recursion_python.png)

### 보충자료
* [알고리즘-공부4-한붓그리기(Eulerian-circuit)](https://sonsh0824.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B3%B5%EB%B6%804-%ED%95%9C%EB%B6%93%EA%B7%B8%EB%A6%AC%EA%B8%B0Eulerian-circuit)
