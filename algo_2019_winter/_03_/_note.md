## 문자열 압축

https://programmers.co.kr/learn/courses/30/lessons/60057

#### 문제 설명

데이터 처리 전문가가 되고 싶은 어피치는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다. 최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데, 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부하고 있습니다.

간단한 예로 aabbaccc의 경우 2a2ba3c(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)와 같이 표현할 수 있는데, 이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다. 예를 들면, abcabcdede와 같은 문자열은 전혀 압축되지 않습니다. 어피치는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.

예를 들어, ababcdcdababcdcd의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만, 2개 단위로 잘라서 압축한다면 2ab2cd2ab2cd로 표현할 수 있습니다. 다른 방법으로 8개 단위로 잘라서 압축한다면 2ababcdcd로 표현할 수 있으며, 이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.

다른 예로, abcabcdede와 같은 경우, 문자를 2개 단위로 잘라서 압축하면 abcabc2de가 되지만, 3개 단위로 자른다면 2abcdede가 되어 3개 단위가 가장 짧은 압축 방법이 됩니다. 이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.

압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.

#### 제한사항

* `s`의 길이는 1 이상 1,000 이하입니다.
* `s`는 알파벳 소문자로만 이루어져 있습니다.

####  입출력 예
| s | result |
| :--- | :--- |
| aabbaccc | 7 |
| ababcdcdababcdcd | 9 |
| abcabcdede | 8 |
| abcabcabcabcdededededede | 14 |
| xababcdcdababcdcd | 17 |

#### 입출력 예에 대한 설명

##### 입출력 예 #1

문자열을 1개 단위로 잘라 압축했을 때 가장 짧습니다.

##### 입출력 예 #2

문자열을 8개 단위로 잘라 압축했을 때 가장 짧습니다.

##### 입출력 예 #3

문자열을 3개 단위로 잘라 압축했을 때 가장 짧습니다.

##### 입출력 예 #4

문자열을 2개 단위로 자르면 abcabcabcabc6de 가 됩니다.<br/>
문자열을 3개 단위로 자르면 4abcdededededede 가 됩니다.<br/>
문자열을 4개 단위로 자르면 abcabcabcabc3dede 가 됩니다.<br/>
문자열을 6개 단위로 자를 경우 2abcabc2dedede가 되며, 이때의 길이가 14로 가장 짧습니다.<br/>

##### 입출력 예 #5

문자열은 제일 앞부터 정해진 길이만큼 잘라야 합니다.<br/>
따라서 주어진 문자열을 x / ababcdcd / ababcdcd 로 자르는 것은 불가능 합니다.<br/>
이 경우 어떻게 문자열을 잘라도 압축되지 않으므로 가장 짧은 길이는 17이 됩니다.

## 풀이

모든 경우의 수를 구해 가장 작은 길이를 찾는다.

##### 입출력 예 #1

```
s = aabbaccc (8)

w = [a, a, b, b, a, c, c, c]
r = 2a2ba3c (7)
```

##### 입출력 예 #2

```
s = ababcdcdababcdcd (16)

w = [a, b, a, b, c, d, c, d, a, b, a, b, c, d, c, d]
r = ababcdcdababcdcd (16)
```

##### 입출력 예 #3

```
s = abcabcdede (10)

w = [a, b, c, a, b, c, d, e, d, e]
r = abcabcdede (10)
```

##### 입출력 예 #4

```
s = abcabcabcabcdededededede (24)

w = [a, b, c, a, b, c, a, b, c, a, b, c, d, e, d, e, d, e, d, e, d, e, d, e]
r = abcabcabcabcdededededede (24)
```

##### 입출력 예 #5

```
s = xababcdcdababcdcd (17)

w = [x, a, b, a, b, c, d, c, d, a, b, a, b, c, d, c, d]
r = xababcdcdababcdcd (17)
```

<!-- # [문자열 압축](https://programmers.co.kr/learn/courses/30/lessons/60057) 
> 시작점에서 단위 길이로만 잘라서 압축할 것인가, 압축이 안되는 구간은 건너뛰며 최대로 압축할 것이냐에 따라 난이도가 크게 달라짐  
> 마지막 예시("xababcdcdababcdcd"의 압축율은 0%)까지 읽어야 불필요한 시간 낭비 없이 문제를 풀 수 있음  

### 코드 및 실행결과
* [성공](string_compression_python.py) : 파이썬으로 작성한 코드  
  ![결과](string_compression_result_python.JPG)

* [성공](StringCompression.java) : 자바로 작성한 코드  
  ![결과](string_compression_result_java.JPG)

# [캐시](https://programmers.co.kr/learn/courses/30/lessons/17680) (?)
> LRU(Least Recently Used)의 구현을 요구하는 문제  
> 자료구조가 갖추어야 할 요건은 참조되거나 추가된 기록을 순서대로 보존할 수 있어야 한다는 것임(ordered)   

### 코드 및 실행결과
* [성공](cache.py) : 파이썬으로 작성한 코드  
  ![결과](cache_result_python.JPG)

* [성공](Cache.java) : 자바로 작성한 코드  
  ![결과](cache_result_java.JPG)

### 보충자료
* [페이지 교체 알고리즘](https://jhpop.tistory.com/34)
* [가상메모리-02-페이지 교체 알고리즘](https://eunhyejung.github.io/os/2018/07/24/operatingsystem-study15.html) -->
