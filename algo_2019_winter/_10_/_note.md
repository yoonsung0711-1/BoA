## 가장 긴 팰린드롬

https://programmers.co.kr/learn/courses/30/lessons/12904

#### 문제 설명

앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.

예를들면, 문자열 s가 "abcdcba"이면 7을 return하고 "abacde"이면 3을 return합니다.

#### 제한사항

* 문자열 `s`의 길이 : 2,500 이하의 자연수
* 문자열 `s`는 알파벳 소문자로만 구성

#### 입출력 예

| s | answer |
| :--- | ---: |
| "abcdcba" | 7 |
| "abacde" | 3 |
| "abcde" | 1 |
| "abcd" | 1 |
| "abba" | 4 |
| "a" | 1 |
| "abcdefghijklmnopqrstuvwxyz" | 1 |
| "aba" | 3 |
| "aaa" | 3 |
| "aab" | 3 |
| "baa" | 3 |
| "abaabaaba" | 9 |

#### 입출력 예 설명

##### 입출력 예 #1

4번째자리 'd'를 기준으로 문자열 s 전체가 팰린드롬이 되므로 7을 return 합니다.

##### 입출력 예 #2

2번째자리 'b'를 기준으로 aba가 팰린드롬이 되므로 3을 return 합니다.

## 풀이

1. 주어진 **문자열 전체가 팰린드롬**인 경우를 체크한다.

    ![](https://i.imgur.com/b1AdX4r.png)

2. 성능을 위하여 가장 긴 문자열 조합부터 체크하며, 팰린드롬인 경우 그 이후의 짧아지는 문자열은 체크할 필요가 없다.

    ![](https://i.imgur.com/2hoXdil.png)

<!-- # [팰린드롬](https://programmers.co.kr/learn/courses/30/lessons/12904) 
> 

### 코드 및 실행결과

* [성공](palindrome_tail_recursion.ts.bak) : javascript(tail recursion)으로 작성한 코드 
  ![결과](palindrome_tail_recursion.png)

* [성공](palindrome_recursive_loop.ts) : javascript(recursive loop)으로 작성한 코드
  ![결과](palindrome_recursive_loop.png)

### 참고자료

* [자바스크립트 제너레이터를 사용하도록 바꾼 코드(generator)](palindrome_generator.ts)

* [자바로 변환한 코드(tail recursion)](PalindromeTailRecursion.java)

* [자바 버전(recursive loop)](PalindromeRecursiveLoop.java)
  ![결과](PalindromeRecursiveLoop_java.png)
 -->
