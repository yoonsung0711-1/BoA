## 가장 긴 팰린드롬

https://programmers.co.kr/learn/courses/30/lessons/12904

#### 풀이

##### 예제 1
```ts
abcdcba, 7

len: 7
abc/d/cba
```

##### 예제 2
```ts
abacde, 6

* len: 6
shift: 0, aba//cde

* len: 5
shift: 0, ab/a/cd
shift: 1,  ba/c/de

* len: 4
shift: 0, ab//ac
shift: 1, ba//cd
shift: 2, ac//de

* len: 3
shift: 0, a/b/a
```

##### 예제 3
```ts
abcde, 5

* len: 5
shift: 0, ab/c/de

* len: 4
shift: 0, ab//cd
shift: 1, bc//de

* len: 3
shift: 0, a/b/c
shift: 1, b/c/d
shift: 2, c/d/e

* len: 2
shift: 0, a/b
shift: 1, b/c
shift: 2, c/d
shift: 3, d/e

* len: 1
```

##### 예제 4
```ts
abaabaaba, 9

* len: 9
shift: 0, abaa/b/aaba

```

### 코드 및 실행결과

* [java](./_java/PalindromeJavaClosure.java)

* [java](./_java/PalindromeRecursiveLoop.java)

* [java](./_java/PalindromeTailRecursion.java)

* [java](./_java/PalindromeTailRecursionClass.java)

* [typescript]()

### 참고자료

* [자바스크립트 제너레이터를 사용하도록 바꾼 코드(generator)](palindrome_generator.ts)

* [자바로 변환한 코드(tail recursion)](PalindromeTailRecursion.java)

* [자바 버전(recursive loop)](PalindromeRecursiveLoop.java)
  ![결과](PalindromeRecursiveLoop_java.png)
 -->
