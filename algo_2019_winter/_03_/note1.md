## 문자열 압축

https://programmers.co.kr/learn/courses/30/lessons/60057

### 풀이

"aabbaccc"    7
"ababcdcdababcdcd"    9
"abcabcdede"    8
"abcabcabcabcdededededede"    14
"xababcdcdababcdcd"    17

###### 예제 1

```ts
#data: aabbaccc
len = 4
    aabb!accc
len = 3
    aab!bac|cc
    a|aab!acc|c
    aa|aba!ccc
len = 2
    aa!bb!ac!cc
len = 1
    a=a|b=b|a|c=c=c
    * 2a2ba3c => 7
```

###### 예제 2

```ts
# data: ababcdcdababcdcd
len = 8
    ababcdcd=abababcdcd
    * 2ababcdcd => 9
```

###### 예제 3

```ts
# data: abcabcdede
len = 5
    abcab!cdede
len = 4
    abca!bcde|de
    a|bcab!cded|e
    ab|cabc!dede
len = 3
    abc=abc!ded|e
    a|bca!bcd!ede
    ab|cab!cde|de
    abc|abc!ded|e
    abca|bcd!ede
    * 2abcdede => 8
```

###### 예제 4

```ts
# data: abcabcabcabcdededededede 
len = 12
   abcabcabcabc!dededededede 
len = 11
   abcabcabcab!cdedededede|de 
len = 10
   abcabcabca!bcdededede|dede 
len = 9
   abcabcabc!abcdedede|dedede 
len = 8
   abcabcab!cabcdede!dededede 
len = 7
   abcabca!bcabcde!dededed!ede 
len = 6
   abcabc=abcabc|dedede=dedede 
   * 2abcabc2dedede, 14
```

###### 예제 4

```ts
# data: abcabcabcabcdededededede 
len = 12
   abcabcabcabc!dededededede 
len = 11
   abcabcabcab!cdedededede|de 
len = 10
   abcabcabca!bcdededede|dede 
len = 9
   abcabcabc!abcdedede|dedede 
len = 8
   abcabcab!cabcdede!dededede 
len = 7
   abcabca!bcabcde!dededed|ede 
len = 6
   abcabc=abcabc|dedede=dedede 
   * 2abcabc2dedede, 14
```

###### 예제 5

```ts
# data: xababcdcdababcdcd
len = 8
    xababcdc!dababcdc|d
len = 7
    xababcd!cdababc|dcd
len = 6
    xababc!dcdaba|bcdcd
len = 5
    xabab!cdcda!babcd|cd
len = 4
    xaba!bcdc!daba!bcdc|d
len = 3
    xab!abc!dcd!aba!bcd|cd
len = 2
    xa!ba!bc!dc!da!ba!bc!dc|d
len = 1
    x!a!b!a!b!c!d!c!d!a!b!a!b!c!d!c!d
```

### 코드

* [python](./_python/string_compression_python.py)
<!-- * [ts](./_ts/) -->
<!-- * [rust](./_rust/) -->
* [java](./_java/StringCompression.java)
<!-- * [kotlin](./_kotlin/Cache.kt) -->