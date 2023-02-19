  /**
In MATLAB, there is a handy function called reshape which can reshape an m x n 
matrix into a new one with a different size r x c keeping its original data. 

 You are given an m x n matrix mat and two integers r and c representing the 
number of rows and the number of columns of the wanted reshaped matrix. 

 The reshaped matrix should be filled with all the elements of the original 
matrix in the same row-traversing order as they were. 

 If the reshape operation with given parameters is possible and legal, output 
the new reshaped matrix; Otherwise, output the original matrix. 

 
 Example 1: 
 
 
Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]
 

 Example 2: 
 
 
Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]
 

 
 Constraints: 

 
 m == mat.length 
 n == mat[i].length 
 1 <= m, n <= 100 
 -1000 <= mat[i][j] <= 1000 
 1 <= r, c <= 300 
 

 Related Topics 数组 矩阵 模拟 👍 366 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.util.Arrays;
  import java.util.Scanner;

  public class ReshapeTheMatrix{
      public static void main(String[] args) {
          Solution solution = new ReshapeTheMatrix().new Solution();
          Scanner scanner = new Scanner(System.in);
          int[] a = {2,3,5,7,6};
          String b ="hello world";
          char[] c = {'h','e','l'};
          System.out.println(c.length);
          for(int i : a){
              System.out.println(i);
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(m * n != r * c){
            return mat;
        }else{
            int[][] ans = new int[r][c];
            for (int i = 0; i < m * n; i++) {
                ans[i/c][i%c] = mat[i/n][i%n];
            }
            return ans;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }