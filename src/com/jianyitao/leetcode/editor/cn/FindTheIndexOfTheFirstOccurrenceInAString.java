  /**
Given two strings needle and haystack, return the index of the first occurrence 
of needle in haystack, or -1 if needle is not part of haystack. 

 
 Example 1: 

 
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
 

 Example 2: 

 
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

 
 Constraints: 

 
 1 <= haystack.length, needle.length <= 10⁴ 
 haystack and needle consist of only lowercase English characters. 
 

 Related Topics 双指针 字符串 字符串匹配 👍 1703 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;
  
  public class FindTheIndexOfTheFirstOccurrenceInAString{
      public static void main(String[] args) {
          Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }