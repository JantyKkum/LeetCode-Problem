  /**
Given an integer array nums, return true if any value appears at least twice in 
the array, and return false if every element is distinct. 

 
 Example 1: 
 Input: nums = [1,2,3,1]
Output: true
 
 Example 2: 
 Input: nums = [1,2,3,4]
Output: false
 
 Example 3: 
 Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 
 
 Constraints: 

 
 1 <= nums.length <= 10⁵ 
 -10⁹ <= nums[i] <= 10⁹ 
 

 Related Topics 数组 哈希表 排序 👍 892 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.util.HashMap;
  import java.util.HashSet;
  import java.util.Map;
  import java.util.Set;

  public class ContainsDuplicate{
      public static void main(String[] args) {
          Solution solution = new ContainsDuplicate().new Solution();
           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set record = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(!record.contains(nums[i])){
                record.add(nums[i]);
            }else{
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }