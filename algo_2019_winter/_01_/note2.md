# 탑

[https://programmers.co.kr/learn/courses/30/lessons/42588](https://programmers.co.kr/learn/courses/30/lessons/42588)


### 풀이

* stack과 queue는 array-based 이거나 linked-based이며 array 또는 linked list보다 제한된 기능을 가진 자료구조임

* 따라서 stack과 queue로 할 수 있는 연산은 array나 linked list로도 할 수 있음

##### 예제 1

![tower.png](./img/tower.png)

```ts
sender -> heights[4]: 4
receiver -> heights[3]: 7
answer: [0, 0, 0, 0, 4]


sender -> heights[3]: 7
receiver -> heights[1]: 9
answer: [0, 0, 0, 2, 4]


sender -> heights[2]: 5
receiver -> heights[1]: 9
answer: [0, 0, 2, 2, 4]


sender -> heights[1]: 9
answer: [0, 0, 2, 2, 4]


sender -> heights[0]: 6
answer: [0, 0, 2, 2, 4]

# solution: [0, 0, 2, 2, 4]

```
### 코드

* [python](./_python/an_unfulfilled_player_hash.py)
* [rust](./_rust/an_unfulfilled_player.rs)

### 보충자료
- [Hash, Hashing, Hash Table(해시, 해싱 해시테이블) 자료구조의 이해](https://velog.io/@cyranocoding/Hash-Hashing-Hash-Table%ED%95%B4%EC%8B%9C-%ED%95%B4%EC%8B%B1-%ED%95%B4%EC%8B%9C%ED%85%8C%EC%9D%B4%EB%B8%94-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0%EC%9D%98-%EC%9D%B4%ED%95%B4-6ijyonph6o)
