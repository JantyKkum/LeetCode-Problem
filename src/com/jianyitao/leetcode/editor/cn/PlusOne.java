/**
 * You are given a large integer represented as an integer array digits, where
 * each digits[i] is the iᵗʰ digit of the integer. The digits are ordered from most
 * significant to least significant in left-to-right order. The large integer does
 * not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 * <p>
 * <p>
 * Related Topics 数组 数学 👍 1155 👎 0
 */

package com.jianyitao.leetcode.editor.cn;

import java.util.*;

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        System.out.println(solution.plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
        List list = new ArrayList();
        list.add(0);
        list.add(1);
        System.out.println(list);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int carry = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] != 9) {
                    digits[i] += carry;
                    return digits;
                } else if(i != 0){
                    digits[i] = 0;
                    carry = 1;
                }else{
                    int[] ans = new int[digits.length + 1];
                    ans[0] = 1;
                    return ans;
                }
            }
            return digits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}