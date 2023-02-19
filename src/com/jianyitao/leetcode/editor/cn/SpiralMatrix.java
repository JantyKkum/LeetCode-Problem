  /**
Given an m x n matrix, return all elements of the matrix in spiral order. 

 
 Example 1: 
 
 
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
 

 Example 2: 
 
 
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

 
 Constraints: 

 
 m == matrix.length 
 n == matrix[i].length 
 1 <= m, n <= 10 
 -100 <= matrix[i][j] <= 100 
 

 Related Topics 数组 矩阵 模拟 👍 1290 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.List;

  public class SpiralMatrix{
      public static void main(String[] args) {
          Solution solution = new SpiralMatrix().new Solution();
           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m = matrix.length;      //行
        int n = matrix[0].length;   //列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }