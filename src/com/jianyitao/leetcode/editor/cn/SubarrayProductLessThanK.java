  /**
Given an array of integers nums and an integer k, return the number of 
contiguous subarrays where the product of all the elements in the subarray is strictly 
less than k. 

 
 Example 1: 

 
Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less 
than k.
 

 Example 2: 

 
Input: nums = [1,2,3], k = 0
Output: 0
 

 
 Constraints: 

 
 1 <= nums.length <= 3 * 10⁴ 
 1 <= nums[i] <= 1000 
 0 <= k <= 10⁶ 
 

 Related Topics 数组 滑动窗口 👍 638 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.math.BigInteger;

  public class SubarrayProductLessThanK{
      public static void main(String[] args) {
          Solution solution = new SubarrayProductLessThanK().new Solution();
          int[] nums = {90,4,6,67,2,4,677,3};
          int k = 30;
          System.out.println(solution.numSubarrayProductLessThanK(nums, k));

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0,product = 1,n = nums.length;
        int i = 0;                                //i为窗口的左指针
        for (int j = 0; j < n; j++) {             //j为窗口的右指针,对窗口的右边界进行枚举
            product *= nums[j];                   //计算初始窗口的乘积，数据最大超过一次k，即k*nums[i] 10^9，不超int的范围
            while(i<=j && product >=k){           //窗口范围内时，如果乘积大于k，则缩小窗口继续探讨
                product /= nums[i];               //
                i++;
            }
            ans += j-i+1;                         //此时窗口范围内的数据都能满足要求
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }