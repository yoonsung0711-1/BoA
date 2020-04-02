## 큰 수 만들기

https://programmers.co.kr/learn/courses/30/lessons/42883

#### 문제 설명

어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

#### 제한 조건

* number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
* k는 1 이상 `number의 자릿수` 미만인 자연수입니다.

#### 입출력 예

| number | k | return |
| :--- | :--- | :--- |
| 1924 |2 | 94 |
| 1231234 | 3 | 3234 |
| 4177252841 |4 |775841 |

## 문제 풀이

<!-- ![Imgur](https://i.imgur.com/GT4lgXp.png)
# [큰 수 만들기](https://programmers.co.kr/learn/courses/30/lessons/42883?language=python3) (그리디)
> 같은 로직으로 자바스크립트, 파이썬 코드를 작성하였으나 수행시간, 메모리 사용량에서 큰 차이를 보임.  
> 수행시간은 자바스크립트 코드가 파이썬 코드를 크게 앞서고(20~30배), 메모리 사용량은 파이썬 코드가 자바스크립트 코드에 비해 상대적으로 높은 것으로(3배 이상) 나옴.

### 코드 및 실행결과
* [실패](create_a_large_number.ipynb) : 자바스크립트로 작성한 코드  
![결과](test_result_js.JPG)
* [실패](create_a_large_number.py) : 파이썬으로 작성한 코드  
![결과](test_result_python.JPG)

### 보충자료
* [반드시 알아하는 알고리즘 top8 - 6. 탐욕 알고리즘](https://gomguard.tistory.com/119)
* [파이썬 메모리 사용량 계산 모듈(memory-profiler)](https://pypi.org/project/memory-profiler/)
* [파이썬 수행시간 측정 모듈(timeit)](https://docs.python.org/ko/3/library/timeit.html)
* [자바스크립트 메모리 사용량 계산 방법](https://www.valentinog.com/blog/memory-usage-node-js/)
* [자바스크립트 수행시간 측정 방법](https://stackoverflow.com/questions/313893/how-to-measure-time-taken-by-a-function-to-execute)

### 코드비교
* []() -->

* [rust-Parsing a char to u32](https://stackoverflow.com/questions/41380367/parsing-a-char-to-u32)