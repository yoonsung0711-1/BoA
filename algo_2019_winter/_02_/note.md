# 큰 수 만들기

[https://programmers.co.kr/learn/courses/30/lessons/42883](https://programmers.co.kr/learn/courses/30/lessons/42883)


### 풀이


##### 예제 1

```ts

n = 2
192|4
range: [1,9,2]
max = 9
picked: [9]

n = 1
24
range: [2,4]
max = 4
picked: [9,2]

```

##### 예제 2
```ts

n = 4
1231|234
range: [1,2,3,1]
max = 3
picked: [3]

n = 3
12|34
range: [1,2]
max = 2
picked: [3,2]

n = 2
34
range: [3,4]
picked: [3,2,3,4]

```

##### 예제 3
```ts

n = 6
41772|52841
range: [4,1,7,7,2]
max: 7
picked: [7]

n = 5
725|2841
range: [7,2,5]
max: 7
picked: [7,7]

n = 4
252|841
range: [2,5,2]
max: 5
picked: [7,7,5]

n = 3
28|41
range: [2,8]
max: 8
picked: [7,7,5,8]

n = 2
41
range: [4,1]
picked: [7,7,5,8,4,1]
```

### 코드

* [python](./_python/create_a_large_number.py)
* [ts](./_ts/create_a_large_number.ts)
* [rust](./_rust/createALargeNumber.rs)
* [java](./_java/CreateLargeNumber.java)
* [kotlin](./_kotlin/createLargeNumber.kt)

### 보충자료

* [반드시 알아하는 알고리즘 top8 - 6. 탐욕 알고리즘](https://gomguard.tistory.com/119)
* [파이썬 메모리 사용량 계산 모듈(memory-profiler)](https://pypi.org/project/memory-profiler/)
* [파이썬 수행시간 측정 모듈(timeit)](https://docs.python.org/ko/3/library/timeit.html)
* [자바스크립트 메모리 사용량 계산 방법](https://www.valentinog.com/blog/memory-usage-node-js/)
* [자바스크립트 수행시간 측정 방법](https://stackoverflow.com/questions/313893/how-to-measure-time-taken-by-a-function-to-execute)