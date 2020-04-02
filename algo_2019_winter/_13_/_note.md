## Longest String Chain

https://leetcode.com/problems/longest-string-chain/

Given a list of words, each word consists of English lowercase letters.

Let's say `word1` is a predecessor of `word2` if and only if we can add exactly one letter anywhere in `word1` to make it equal to `word2`.  For example, `abc` is a predecessor of `abac`.

A word chain is a sequence of words `[word_1, word_2, ..., word_k]` with `k >= 1`, where `word_1` is a predecessor of `word_2`, `word_2` is a predecessor of `word_3`, and so on.

Return the longest possible length of a word chain with words chosen from the given list of `words`.

#### Example 1:

```
Input: ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: one of the longest word chain is "a","ba","bda","bdca".
```

#### Note:

1. `1 <= words.length <= 1000`
2. `1 <= words[i].length <= 16`
3. `words[i]` only consists of English lowercase letters.

#### Related Topics

`Hash Table` `Dynamic Programming`

#### Hint 1

Instead of adding a character, try deleting a character to form a chain in reverse.

#### Hint 2

For each word in order of length, for each word2 which is word with one character removed, length[word2] = max(length[word2], length[word] + 1).

## 풀이

DP<sup>`Dynamic Programming`</sup>를 이용하여 풀었다.

길이가 작은 문자열부터 **내 문자열보다 길이가 1작은 문자열**들과 비교하여 그 문자열의 체인의 길이 + 1

1. 처음 가작 작은 길이의 문자열들의 체인길이는 `1`이다.
2. 내 문자열보다 길이가 1 작은 문자열들만 찾아서 체인인지 검사한다.
   1. 체인이 맞으면 `비교했던 문자열의 체인길이 + 1`
   2. 체인인 문자열들이 없으면 나의 체인길이는 `1`
3. 체인인 문자열들이 여러개일 수 있으므로 문자열들 중 체인길이가 가장 긴 길이를 선택한다.
 
#### Example 1

```json
["a","b","ba","bca","bda","bdca"]
```

![](https://i.imgur.com/dEWkhx9.png)

#### Example 2

```json
["a", "b", "ba", "bac", "bad"]
```

![](https://i.imgur.com/Xco5GCw.png)

#### Example 3

```json
["ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"]
```

![](https://i.imgur.com/Cbyk3gD.png)

아래와 같이 **길이**와 **문자열들**을 먼저 정리 후 처리하는 방법도 좋을 것이다.

![](https://i.imgur.com/HtElzSy.png)
<!-- 
# [longest string chain](https://leetcode.com/problems/longest-string-chain/submissions/) 
>

### 코드 및 실행결과

* [성공](longest_string_chain.ts) : typescript(recursive loop)으로 작성한 코드  
  ![결과](longest_string_chain.png)

* [성공]() : typescript(recursive loop)으로 작성한 코드  
  [결과]()

### 참고자료

* [Sample of Unit Testing using Karma, Jasmine and Typescript.](https://github.com/joseluisq/karma-jasmine-typescript)
* [Configuration for karma jasmine ](https://github.com/devrafalko/webpack-karma-jasmine)
* [Sample of Unit Testing using Karma, Jasmine and Typescript.](https://github.com/joseluisq/karma-jasmine-typescript)
* [[Node.js] Nodemon이란?](https://wickies.tistory.com/116) -->
