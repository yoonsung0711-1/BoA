# 완주하지 못한 선수

[https://programmers.co.kr/learn/courses/30/lessons/42576](https://programmers.co.kr/learn/courses/30/lessons/42576)


### 풀이

해시 테이블은 검색 성능이 매우 좋기 때문에 연관 배열, 데이터베이스 인덱싱, 캐시, set(ADT) 등 컴퓨터 과학의 여러 분야에 폭넓게 사용됨

##### 예제 1

```ts
# participants
        {"mislav": 2, "ana": 1, "stanko": 1}

# completors
        {"mislav": 1, "ana": 0, "stanko": 0}

# unfulfilled
        {"mislav": 1}

mislav
```

##### 예제 2
```ts
# participants
        {"marina": 1, "josipa": 1, "nikola": 1, "vinko": 1, "filipa": 1}

# completors
        {"marina": 0, "josipa": 0, "nikola": 0, "vinko": 1, "filipa": 0}

# unfulfilled
        {"vinko": 1}

vinko
```

##### 예제 3
```ts
# participants
        {"ana": 1, "stanko": 1, "mislav": 2}

# completors
        {"ana": 0, "stanko": 0, "mislav": 1}

# unfulfilled
        {"mislav": 1}

mislav
```

### 코드

* [python](./_python/an_unfulfilled_player_hash.py)
* [rust](./_rust/an_unfulfilled_player.rs)

### 보충자료
- [Hash, Hashing, Hash Table(해시, 해싱 해시테이블) 자료구조의 이해](https://velog.io/@cyranocoding/Hash-Hashing-Hash-Table%ED%95%B4%EC%8B%9C-%ED%95%B4%EC%8B%B1-%ED%95%B4%EC%8B%9C%ED%85%8C%EC%9D%B4%EB%B8%94-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0%EC%9D%98-%EC%9D%B4%ED%95%B4-6ijyonph6o)