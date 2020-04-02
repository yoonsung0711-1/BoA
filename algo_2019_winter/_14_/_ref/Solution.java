package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {

  public static void main(String[] args) {
    int[] example = { 3, 8, 8, 3, 6, 6, 5, 11 };
    int m = Arrays.stream(example).max().getAsInt();
    int n = example.length;
    int[][] mat = new int[m][n];
    for (int i = m - 1; i > -1; i--) {
      for (int j = 0; j < n; j++) {
        if (i >= m - example[j]) {
          mat[i][j] = 1;
        } else
          mat[i][j] = 0;
      }
    }
    // Arrays.stream(new int[][]{{1,2,3},{4,5,6}})

    // Arrays.stream(mat)
    // .map(x->
    // Arrays.stream(x)
    // .boxed()
    // .collect(Collectors.toList())
    // ).forEach(System.out::println);

    // Arrays.stream(new int[][]{{1,2,3},{4,5,6}}).map().reduce(new
    // ArrayList<ArrayList<Integer>>(), (acc, curr) -> {
    // return curr;
    // });
    // System.out.println(

    // Arrays.stream(mat)
    // .map(x->
    // Arrays.stream(x)
    // .boxed()
    // .collect(Collectors.toList())
    // ).forEach(x -> System.out.println(x.getClass()));
    // System.out.println(

    List<List<Integer>> arr =
      Arrays.stream(mat)
        .map(x-> 
                Arrays.stream(x)
                  .boxed()
                  .collect(Collectors.toList())
            ).collect(Collectors.toList())
      ;

    // );
    // System.out.println(arr);

    List<ArrayList<Integer>> arr2 =
      Arrays.stream(mat)
        .map(x-> 
          new ArrayList<Integer>(
                Arrays.stream(x)
                  .boxed()
                  .collect(Collectors.toList())
              )
            ).collect(Collectors.toList())
      ;
    
      System.out.println(arr2);

    ArrayList<ArrayList<Integer>> arr3 =
      new ArrayList<ArrayList<Integer>>(
      Arrays.stream(mat)
        .map(x-> 
          new ArrayList<Integer>(
                Arrays.stream(x)
                  .boxed()
                  .collect(Collectors.toList())
              )
            ).collect(Collectors.toList())
      )
      ;
    
      System.out.println(arr3);
  }

  public int largestRectangleArea(int[] heights) {
    return 0;
  }
}
