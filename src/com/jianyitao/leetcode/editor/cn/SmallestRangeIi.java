  /**
You are given an integer array nums and an integer k. 

 For each index i where 0 <= i < nums.length, change nums[i] to be either nums[
i] + k or nums[i] - k. 

 The score of nums is the difference between the maximum and minimum elements 
in nums. 

 Return the minimum score of nums after changing the values at each index. 

 
 Example 1: 

 
Input: nums = [1], k = 0
Output: 0
Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.
 

 Example 2: 

 
Input: nums = [0,10], k = 2
Output: 6
Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 
2 = 6.
 

 Example 3: 

 
Input: nums = [1,3,6], k = 3
Output: 3
Explanation: Change nums to be [4, 6, 3]. The score is max(nums) - min(nums) = 6
 - 3 = 3.
 

 
 Constraints: 

 
 1 <= nums.length <= 10⁴ 
 0 <= nums[i] <= 10⁴ 
 0 <= k <= 10⁴ 
 

 Related Topics 贪心 数组 数学 排序 👍 162 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.util.*;

  public class SmallestRangeIi{
      public static void main(String[] args) {
          Solution solution = new SmallestRangeIi().new Solution();
          int[] a = {1,3,6};
          System.out.println(solution.smallestRangeII(a, 3));
          Vector<Integer> v2 = new Vector<>();
          Queue<Integer> queue = new LinkedList<Integer>();
          for (int i = 0; i <15; i++) {
              v2.add(i);
              System.out.print(v2.get(i) + " ");
              queue.add(i);
          }
          v2.add(4,99);
          System.out.println(v2);

          Deque<Integer> deque = new LinkedList<Integer>();
          System.out.println(queue.peek());
          System.out.println(queue.poll());
          System.out.println(queue.peek());
          System.out.println(queue.remove());

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int ans = 0, n = nums.length;
        if(n == 1 || n == 0){              //排除长度为0或1的情况
            return 0;
        }
        Arrays.sort(nums);                 //排序
        nums[0] += k;
        int min = nums[0],max = nums[0];
        for (int i = 1; i < n; i++) {      //循环处理i所在元素
            if(nums[i] + k >= min && nums[i] + k <= max){
                nums[i] += k;
            }else if(nums[i] - k >= min && nums[i] - k <= max){
                nums[i] -= k;
            }else{
                int diffAdd = nums[i] + k - min;
                int diffSub = max- ( nums[i] - k );
                if(diffAdd < diffSub){
                    nums[i] += k;

                }else {
                    nums[i] -= k;
                }
            }
            max = nums[i] > max ? nums[i] : max;
            min = nums[i] < min ? nums[i] : min;

        }
        return max - min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }