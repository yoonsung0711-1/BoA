class Solution {

  public static void main(String[] args) {
    int max = -1;
    int[] example = { 5,5,1,7,1,1,5,2,7,6 };

    Solution sol = new Solution();

    sol.largestRectangleArea(example);

  }

  public int largestRectangleArea(int[] heights) {
    if (heights.length == 0) return 0;
    int counter = 0;
    int min = Integer.MAX_VALUE;
    int maxArea = -1;
    if (heights.length == 0) return -1;
    for (int i = 0; i < heights.length; i++) {
      for (int j = 0; j < heights.length; j++) {
        if (i + j > heights.length) break;
        System.out.println("\n\t\ti: " + i + ", j: " + j);
        for (int k = i; k < heights.length - j; k++) {
          System.out.print(heights[k]);
          if (heights[k] < min) min = heights[k];
          //if (heights[k] > maxArea) maxArea = heights[k];
          counter++;
        }
        System.out.println("\n\t\tcounter: " + counter + ", min: " + min);
        System.out.println("\n\t\tarea: " + counter * min + ", maxArea " + maxArea);
        if (min * counter > maxArea) {
          maxArea = min * counter;
        }
        min = 20000;
        counter = 0;
      }
    }
    return maxArea;
  }
}
