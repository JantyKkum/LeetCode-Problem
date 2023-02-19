  /**
Given a circular integer array nums (i.e., the next element of nums[nums.length 
- 1] is nums[0]), return the next greater number for every element in nums. 

 The next greater number of a number x is the first greater number to its 
traversing-order next in the array, which means you could search circularly to find 
its next greater number. If it doesn't exist, return -1 for this number. 

 
 Example 1: 

 
Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
 

 Example 2: 

 
Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 

 
 Constraints: 

 
 1 <= nums.length <= 10⁴ 
 -10⁹ <= nums[i] <= 10⁹ 
 

 Related Topics 栈 数组 单调栈 👍 749 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.util.Arrays;

  public class NextGreaterElementIi{
      public static void main(String[] args) {
          Solution solution = new NextGreaterElementIi().new Solution();
           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        int[] nums2 = new int[nums.length*2];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
            nums2[i+nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums2.length; j++) {
                if(nums2[j] > nums[i]){
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }