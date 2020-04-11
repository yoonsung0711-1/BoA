## 캐시

https://programmers.co.kr/learn/courses/30/lessons/17680


### 풀이

##### 예제 1

```ts
cities:[Jeju, Pangyo, Seoul, NewYork, LA, Jeju, Pangyo, Seoul, NewYork, LA]
cacheSize = 3

n = 10
before: []
    * Jeju cache miss +5
after: [Jeju]
    * execution: 5

n = 9
before: [Jeju]
    * Pangyo cache miss +5
after: [Jeju, Pangyo]
    * execution: 10

n = 8
before: [Jeju, Pangyo]
    * Seoul cache miss +5
after: [Jeju, Pangyo, Seoul]
    * execution: 15

n = 7
before: [Jeju, Pangyo, Seoul]
    * NewYork cache miss +5
after: [Pangyo, Seoul, NewYork]
    * execution: 20

n = 6
before: [Pangyo, Seoul, NewYork]
    * LA cache miss +5
after: [Seoul, NewYork, LA]
    * execution: 25

n = 5
before: [Seoul, NewYork, LA]
    * Jeju cache miss +5
after: [NewYork, LA, Jeju]
    * execution: 30

n = 4
before: [NewYork, LA, Jeju]
    * Pangyo cache miss +5
after: [LA, Jeju, Pangyo]
    * execution: 35

n = 3
before: [LA, Jeju, Pangyo]
    * Seoul cache miss +5
after: [Jeju, Pangyo, Seoul]
    * execution: 40

n = 2
before: [Jeju, Pangyo, Seoul]
    * NewYork cache miss +5
after: [Pangyo, Seoul, NewYork]
    * execution: 45

n = 1
before: [Pangyo, Seoul, NewYork]
    * LA cache miss +5
after: [Seoul, NewYork, LA]
    * execution: 50
```

<!-- ##### 예제 2 -->

<!-- ##### 예제 3 -->

### 코드

* [python](./_python/cache.py)
<!-- * [ts](./_ts/) -->
<!-- * [rust](./_rust/) -->
* [java](./_java/Cache.java)

* [kotlin](./_kotlin/Cache.kt)

### 보충자료

* [페이지 교체 알고리즘](https://jhpop.tistory.com/34)

* [가상메모리-02-페이지 교체 알고리즘](https://eunhyejung.github.io/os/2018/07/24/operatingsystem-study15.html) -->
