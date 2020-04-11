package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
  public int largestRectangleArea(int[] heights) {
    if (heights.length == 0) return 0;
    if (heights.length == 1) return heights[0];
    // int m = Arrays.stream(heights).max().getAsInt();
    int m = -1;
    for (int i = 0; i < heights.length; i++) {
      if (heights[i] > m) {
        m = heights[i];
      }
    }
    int n = heights.length;
    int[][] mat = new int[m][n];

    for (int i = m - 1; i > -1; i--) {
      for (int j = 0; j < n; j++) {
        if (i >= m - heights[j]) {
          mat[i][j] = 1;
        } else
          mat[i][j] = 0;
      }
    }

    // ArrayList<ArrayList<Integer>> arr =
    //   new ArrayList<ArrayList<Integer>>(
    //     Arrays.stream(mat)
    //       .map(x-> 
    //         new ArrayList<Integer>(
    //               Arrays.stream(x)
    //                 .boxed()
    //                 .collect(Collectors.toList())
    //             )
    //           ).collect(Collectors.toList()));

    // arr.forEach(x->System.out.println(x));

    //
    int maxArea = 0;
    for (int i = 0; i < mat.length; i++) {
      int cnt = 0, width = 0;
      if (mat[i][0] == 1) {
        cnt = 1;
      } 
      for (int j = 1; j <mat[0].length; j++){
        if (mat[i][j] == 1) {
          cnt++;
          if (j == mat[0].length - 1) {
            if (cnt > width) {
              width = cnt;
            }
            cnt = 0;
          }
        } else {
          if (cnt > width) {
            width = cnt;
          }
          cnt = 0;
        }
      }
      System.out.println("i:" + i + ", height: " + (mat.length - i) + ", width: " + width + ", area: " + width * (mat.length - i));
      if (width * (mat.length - i) > maxArea) {
        maxArea = width * (mat.length - i);
      }
      width = 0;
    }; // End for

    // System.out.println(maxArea);

    return maxArea;
  }
 
  public static void main(String[] args) {
    // int[] example = { 3, 8, 8, 3, 6, 6, 5, 11 };
    System.out.println(
      new Solution().largestRectangleArea(new int[] {1})
    );
  }
  //   int m = Arrays.stream(example).max().getAsInt();
  //   int n = example.length;
  //   int[][] mat = new int[m][n];

  //   for (int i = m - 1; i > -1; i--) {
  //     for (int j = 0; j < n; j++) {
  //       if (i >= m - example[j]) {
  //         mat[i][j] = 1;
  //       } else
  //         mat[i][j] = 0;
  //     }
  //   }

  //   ArrayList<ArrayList<Integer>> arr =
  //     new ArrayList<ArrayList<Integer>>(
  //       Arrays.stream(mat)
  //         .map(x-> 
  //           new ArrayList<Integer>(
  //                 Arrays.stream(x)
  //                   .boxed()
  //                   .collect(Collectors.toList())
  //               )
  //             ).collect(Collectors.toList()));

  //   // System.out.println(arr.get(10));
  //   arr.forEach(x->System.out.println(x));

  //   //
  //   int maxArea = 0;
  //   for (int i = 0; i < arr.size(); i++) {
  //     int cnt = 0, width = 0;
  //     if (arr.get(i).get(0) == 1) {
  //       cnt = 1;
  //     } 
  //     for (int j = 1; j < arr.get(0).size(); j++){
  //       if (arr.get(i).get(j) == 1) {
  //         cnt++;
  //         if (j == arr.get(0).size() - 1) {
  //           if (cnt > width) {
  //             width = cnt;
  //           }
  //           cnt = 0;
  //         }
  //       } else {
  //         if (cnt > width) {
  //           width = cnt;
  //         }
  //         cnt = 0;
  //       }
  //     }
  //     System.out.println("i:" + i + ", height: " + (arr.size() - i) + ", width: " + width + ", area: " + width * (arr.size() - i));
  //     if (width * (arr.size() - i) > maxArea) {
  //       maxArea = width * (arr.size() - i);
  //     }
  //     width = 0;
  //   }; // End for

  //   System.out.println(maxArea);

  // }
}
