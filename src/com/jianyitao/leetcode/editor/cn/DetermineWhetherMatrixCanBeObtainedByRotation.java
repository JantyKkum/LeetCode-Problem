/**
 * Given two n x n binary matrices mat and target, return true if it is possible
 * to make mat equal to target by rotating mat in 90-degree increments, or false
 * otherwise.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * Output: true
 * Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * Output: false
 * Explanation: It is impossible to make mat equal to target by rotating mat.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * Output: true
 * Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal
 * target.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * n == mat.length == target.length
 * n == mat[i].length == target[i].length
 * 1 <= n <= 10
 * mat[i][j] and target[i][j] are either 0 or 1.
 * <p>
 * <p>
 * Related Topics 数组 矩阵 👍 26 👎 0
 */

package com.jianyitao.leetcode.editor.cn;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public static void main(String[] args) {
        Solution solution = new DetermineWhetherMatrixCanBeObtainedByRotation().new Solution();
        int[][] mat = {{0, 1}, {1, 1}};
        int[][] target = {{
                1, 0
        }, {
                0, 1
        }};
        solution.findRotation(mat,target);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            int n = mat.length, x = 0;
            int[] a1 = new int[n * n];
            int[] a2 = new int[n * n];
            int[] a3 = new int[n * n];
            int[] a4 = new int[n * n];
            int[] a5 = new int[n * n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a1[x] = mat[i][j];
                    //旋转90°
                    a2[x] = target[j][n - 1 - i];
                    //旋转180°
                    a3[x] = target[n - 1 - i][n - 1 - j];
                    //旋转270°
                    a4[x] = target[n - 1 - j][i];
                    //旋转360°
                    a5[x] = target[i][j];
                    x++;
                }
            }
            return Arrays.equals(a1, a2) || Arrays.equals(a1, a3) || Arrays.equals(a1, a4) || Arrays.equals(a1, a5);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}