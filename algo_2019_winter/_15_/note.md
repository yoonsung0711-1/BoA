## Capacity To Ship Packages Within D Days

https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

## 풀이


##### 예제 1

```ts
--------- capacity :  11 -----------
    ▷ day : 1
    - capacity: 11, que: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 10 , que: [2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 10, que: [2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 8 , que: [3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 8, que: [3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 5 , que: [4, 5, 6, 7, 8, 9, 10]
    - capacity: 5, que: [4, 5, 6, 7, 8, 9, 10]
    - capacity: 1 , que: [5, 6, 7, 8, 9, 10]
    - capacity: 1, que: [5, 6, 7, 8, 9, 10]

    ▷ day : 2
    - capacity: 11, que: [5, 6, 7, 8, 9, 10]
    - capacity: 6 , que: [6, 7, 8, 9, 10]
    - capacity: 6, que: [6, 7, 8, 9, 10]
    - capacity: 0 , que: [7, 8, 9, 10]
    - capacity: 0, que: [7, 8, 9, 10]

    ▷ day : 3
    - capacity: 11, que: [7, 8, 9, 10]
    - capacity: 4 , que: [8, 9, 10]
    - capacity: 4, que: [8, 9, 10]

    ▷ day : 4
    - capacity: 11, que: [8, 9, 10]
    - capacity: 3 , que: [9, 10]
    - capacity: 3, que: [9, 10]

    ▷ day : 5
    - capacity: 11, que: [9, 10]
    - capacity: 2 , que: [10]
    - capacity: 2, que: [10]

--------- capacity :  12 -----------
    ▷ day : 1
    - capacity: 12, que: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 11 , que: [2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 11, que: [2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 9 , que: [3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 9, que: [3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 6 , que: [4, 5, 6, 7, 8, 9, 10]
    - capacity: 6, que: [4, 5, 6, 7, 8, 9, 10]
    - capacity: 2 , que: [5, 6, 7, 8, 9, 10]
    - capacity: 2, que: [5, 6, 7, 8, 9, 10]

    ▷ day : 2
    - capacity: 12, que: [5, 6, 7, 8, 9, 10]
    - capacity: 7 , que: [6, 7, 8, 9, 10]
    - capacity: 7, que: [6, 7, 8, 9, 10]
    - capacity: 1 , que: [7, 8, 9, 10]
    - capacity: 1, que: [7, 8, 9, 10]

    ▷ day : 3
    - capacity: 12, que: [7, 8, 9, 10]
    - capacity: 5 , que: [8, 9, 10]
    - capacity: 5, que: [8, 9, 10]

    ▷ day : 4
    - capacity: 12, que: [8, 9, 10]
    - capacity: 4 , que: [9, 10]
    - capacity: 4, que: [9, 10]

    ▷ day : 5
    - capacity: 12, que: [9, 10]
    - capacity: 3 , que: [10]
    - capacity: 3, que: [10]

--------- capacity :  13 -----------
    ▷ day : 1
    - capacity: 13, que: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 12 , que: [2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 12, que: [2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 10 , que: [3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 10, que: [3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 7 , que: [4, 5, 6, 7, 8, 9, 10]
    - capacity: 7, que: [4, 5, 6, 7, 8, 9, 10]
    - capacity: 3 , que: [5, 6, 7, 8, 9, 10]
    - capacity: 3, que: [5, 6, 7, 8, 9, 10]

    ▷ day : 2
    - capacity: 13, que: [5, 6, 7, 8, 9, 10]
    - capacity: 8 , que: [6, 7, 8, 9, 10]
    - capacity: 8, que: [6, 7, 8, 9, 10]
    - capacity: 2 , que: [7, 8, 9, 10]
    - capacity: 2, que: [7, 8, 9, 10]

    ▷ day : 3
    - capacity: 13, que: [7, 8, 9, 10]
    - capacity: 6 , que: [8, 9, 10]
    - capacity: 6, que: [8, 9, 10]

    ▷ day : 4
    - capacity: 13, que: [8, 9, 10]
    - capacity: 5 , que: [9, 10]
    - capacity: 5, que: [9, 10]

    ▷ day : 5
    - capacity: 13, que: [9, 10]
    - capacity: 4 , que: [10]
    - capacity: 4, que: [10]

--------- capacity :  14 -----------
    ▷ day : 1
    - capacity: 14, que: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 13 , que: [2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 13, que: [2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 11 , que: [3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 11, que: [3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 8 , que: [4, 5, 6, 7, 8, 9, 10]
    - capacity: 8, que: [4, 5, 6, 7, 8, 9, 10]
    - capacity: 4 , que: [5, 6, 7, 8, 9, 10]
    - capacity: 4, que: [5, 6, 7, 8, 9, 10]

    ▷ day : 2
    - capacity: 14, que: [5, 6, 7, 8, 9, 10]
    - capacity: 9 , que: [6, 7, 8, 9, 10]
    - capacity: 9, que: [6, 7, 8, 9, 10]
    - capacity: 3 , que: [7, 8, 9, 10]
    - capacity: 3, que: [7, 8, 9, 10]

    ▷ day : 3
    - capacity: 14, que: [7, 8, 9, 10]
    - capacity: 7 , que: [8, 9, 10]
    - capacity: 7, que: [8, 9, 10]

    ▷ day : 4
    - capacity: 14, que: [8, 9, 10]
    - capacity: 6 , que: [9, 10]
    - capacity: 6, que: [9, 10]

    ▷ day : 5
    - capacity: 14, que: [9, 10]
    - capacity: 5 , que: [10]
    - capacity: 5, que: [10]

--------- capacity :  15 -----------
    ▷ day : 1
    - capacity: 15, que: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 14 , que: [2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 14, que: [2, 3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 12 , que: [3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 12, que: [3, 4, 5, 6, 7, 8, 9, 10]
    - capacity: 9 , que: [4, 5, 6, 7, 8, 9, 10]
    - capacity: 9, que: [4, 5, 6, 7, 8, 9, 10]
    - capacity: 5 , que: [5, 6, 7, 8, 9, 10]
    - capacity: 5, que: [5, 6, 7, 8, 9, 10]
    - capacity: 0 , que: [6, 7, 8, 9, 10]
    - capacity: 0, que: [6, 7, 8, 9, 10]

    ▷ day : 2
    - capacity: 15, que: [6, 7, 8, 9, 10]
    - capacity: 9 , que: [7, 8, 9, 10]
    - capacity: 9, que: [7, 8, 9, 10]
    - capacity: 2 , que: [8, 9, 10]
    - capacity: 2, que: [8, 9, 10]

    ▷ day : 3
    - capacity: 15, que: [8, 9, 10]
    - capacity: 7 , que: [9, 10]
    - capacity: 7, que: [9, 10]

    ▷ day : 4
    - capacity: 15, que: [9, 10]
    - capacity: 6 , que: [10]
    - capacity: 6, que: [10]

    ▷ day : 5
    - capacity: 15, que: [10]
    - capacity: 5 , que: []
    - capacity: 5, que: []

➤ min capacity: 15
```

##### 예제 2

```ts
--------- capacity : 5-----------
    ▷ day : 1
    - capacity: 5, que: [3, 2, 2, 4, 1, 4]
    - capacity: 2, que: [2, 2, 4, 1, 4]
    - capacity: 2, que: [2, 2, 4, 1, 4]
    - capacity: 0, que: [2, 4, 1, 4]
    - capacity: 0, que: [2, 4, 1, 4]

    ▷ day : 2
    - capacity: 5, que: [2, 4, 1, 4]
    - capacity: 3, que: [4, 1, 4]
    - capacity: 3, que: [4, 1, 4]

    ▷ day : 3
    - capacity: 5, que: [4, 1, 4]
    - capacity: 1, que: [1, 4]
    - capacity: 1, que: [1, 4]
    - capacity: 0, que: [4]
    - capacity: 0, que: [4]

--------- capacity : 6-----------
    ▷ day : 1
    - capacity: 6, que: [3, 2, 2, 4, 1, 4]
    - capacity: 3, que: [2, 2, 4, 1, 4]
    - capacity: 3, que: [2, 2, 4, 1, 4]
    - capacity: 1, que: [2, 4, 1, 4]
    - capacity: 1, que: [2, 4, 1, 4]

    ▷ day : 2
    - capacity: 6, que: [2, 4, 1, 4]
    - capacity: 4, que: [4, 1, 4]
    - capacity: 4, que: [4, 1, 4]
    - capacity: 0, que: [1, 4]
    - capacity: 0, que: [1, 4]

    ▷ day : 3
    - capacity: 6, que: [1, 4]
    - capacity: 5, que: [4]
    - capacity: 5, que: [4]
    - capacity: 1, que: []
    - capacity: 1, que: []

➤ min capacity: 6
```

### 코드

* [java](./_java/ShipWithinDays.java)

* [kotlin](./_kotlin/shipWithinDays.kt)

