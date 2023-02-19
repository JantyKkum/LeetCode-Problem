  /**
Given an array of integers temperatures represents the daily temperatures, 
return an array answer such that answer[i] is the number of days you have to wait 
after the iᵗʰ day to get a warmer temperature. If there is no future day for which 
this is possible, keep answer[i] == 0 instead. 

 
 Example 1: 
 Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
 
 Example 2: 
 Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
 
 Example 3: 
 Input: temperatures = [30,60,90]
Output: [1,1,0]
 
 
 Constraints: 

 
 1 <= temperatures.length <= 10⁵ 
 30 <= temperatures[i] <= 100 
 

 Related Topics 栈 数组 单调栈 👍 1379 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;
  
  public class DailyTemperatures{
      public static void main(String[] args) {
          Solution solution = new DailyTemperatures().new Solution();
          int[] temperatures = {30,60,90};
          int[] ints = solution.dailyTemperatures(temperatures);
          for (int i : ints) {
              System.out.print(i+" ");
          }

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length, j=0;
        int[] ans = new int[n];
        for (int i = 0; i < n-1; i++) {
            j = i+1;
            if(temperatures[j] > temperatures[i]){
                ans[i] = j-i;
            }else{

            }

        }
        ans[n-1]=0;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }