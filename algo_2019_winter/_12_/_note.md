## 가장 큰 정사각형 찾기

https://programmers.co.kr/learn/courses/30/lessons/12906

#### 문제 설명

1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)

예를 들어

![](https://i.imgur.com/6JfPbGJ.png)

가 있다면 가장 큰 정사각형은

![](https://i.imgur.com/sA7PkMO.png)

가 되며 넓이는 9가 되므로 9를 반환해 주면 됩니다.

#### 제한사항

* 표(board)는 2차원 배열로 주어집니다.
* 표(board)의 행(row)의 크기 : 1,000 이하의 자연수
* 표(board)의 열(column)의 크기 : 1,000 이하의 자연수
* 표(board)의 값은 1또는 0으로만 이루어져 있습니다.

#### 입출력 예

| board | answer |
| :--- | ---: |
| [[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]] | 9 |
| [[0,0,1,1],[1,1,1,1]] | 4 |
| [[0,1,0,0],[0,0,0,0]] | 1 |
| [[0,0,0,0],[1,0,0,0]] | 1 |
| [[]] | 0 |
| [[0,0,0,0,0]] | 0 |
| [[0,0,0],[0,0,0],[0,0,0]] | 0 |

#### 입출력 예 설명

##### 입출력 예 #1

문제의 예시와 같습니다.

![](https://i.imgur.com/l9k4U36.png)

##### 입출력 예 #2

![](https://i.imgur.com/THQab3S.png)

로 가장 큰 정사각형의 넓이는 4가 되므로 4를 return 합니다.

## 풀이

효율성 테스트가 있다. DP<sup>`Dynamic Programming`</sup>을 이용한다.

보통 메모제이션<sup>`Memoization`</sup>을 다른 곳에 담아두는데 이 문제는 사각형 블럭 자체에 결과를 담아두는 특징이 있다.

한 칸씩 이동하면서 2x2 블럭의 작은 단위로 계산을 한다.

순회 순서는 아래와 같다. (한번만 돈다!)

![](https://i.imgur.com/dsm73Si.png)

첫번쨰 열과 행은 DP의 범위에 들어가지 않으므로 따로 계산해주고, 2열 2행부터 2x2 계산을 한다.

##### 입출력 예제 #1

![](https://i.imgur.com/FKBmWrF.png)

##### 입출력 예제 # 2

![](https://i.imgur.com/1aJTyeF.png)

<!-- # [가장 큰 정사각형 찾기](https://programmers.co.kr/learn/courses/30/lessons/12905) 
> 

### 코드 및 실행결과

* [성공](find_the_largest_square.ts) : typescript(tail recursion)로 작성한 코드  
  ![결과](find_the_largest_square.png)

* [성공](find_the_largest_square.ts) : typescript(recursive loop)으로 작성한 코드  
  ![결과](find_the_largest_square.png)

### 참고자료

* []() : java(tail recursion + lambda recursive)로 변환한 코드
  ![]()

* []()
* []()
* []()
* []() -->
