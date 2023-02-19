  /**
Given a 2D matrix matrix, handle multiple queries of the following type: 

 
 Calculate the sum of the elements of matrix inside the rectangle defined by 
its upper left corner (row1, col1) and lower right corner (row2, col2). 
 

 Implement the NumMatrix class: 

 
 NumMatrix(int[][] matrix) Initializes the object with the integer matrix 
matrix. 
 int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the 
elements of matrix inside the rectangle defined by its upper left corner (row1, 
col1) and lower right corner (row2, col2). 
 

 You must design an algorithm where sumRegion works on O(1) time complexity. 

 
 Example 1: 
 
 
Input
["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3,
 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
Output
[null, 8, 11, 12]
 

Explanation
NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0,
 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)


 
 Constraints: 

 
 m == matrix.length 
 n == matrix[i].length 
 1 <= m, n <= 200 
 -10⁴ <= matrix[i][j] <= 10⁴ 
 0 <= row1 <= row2 < m 
 0 <= col1 <= col2 < n 
 At most 10⁴ calls will be made to sumRegion. 
 

 Related Topics 设计 数组 矩阵 前缀和 👍 461 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;
  
  public class RangeSumQuery2dImmutable{
      public static void main(String[] args) {

           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    int[][] sums;                       //二维前缀和

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;          //行数
        int n = matrix[0].length;       //列数
        if(m>0){
            sums = new int[m+1][n+1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i+1][j+1] = sums[i+1][j] + sums[i][j+1] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1] - sums[row1][col2+1] - sums[row2+1][col1] + sums[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }