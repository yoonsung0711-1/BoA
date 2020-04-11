
## Convert Sorted Array to Binary Search Tree

https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

### 풀이

##### 예제 1

```java

      0
     / \
   -3   9
   /   /
 -10  5

length: 5, array: [-10, -3, 0, 5, 9]
mid: 2, el: 0
Node(0)

length: 2, array: [-10, -3]
mid: 1, el: -3
Node(-3)

length: 1, array: [-10]
mid: 0, el: -10
Node(-10)

length: 2, array: [5, 9]
mid: 1, el: 9
Node(9)

length: 1, array: [5]
mid: 0, el: 5
Node(5)

```

##### 예제 2

##### 예제 3

### 코드

* [Java](./SortedArrToBst.java)

![SortedArrToBst](./SortedArrToBst.png)