  /**
Given two strings s and t, return true if t is an anagram of s, and false 
otherwise. 

 An Anagram is a word or phrase formed by rearranging the letters of a 
different word or phrase, typically using all the original letters exactly once. 

 
 Example 1: 
 Input: s = "anagram", t = "nagaram"
Output: true
 
 Example 2: 
 Input: s = "rat", t = "car"
Output: false
 
 
 Constraints: 

 
 1 <= s.length, t.length <= 5 * 10⁴ 
 s and t consist of lowercase English letters. 
 

 
 Follow up: What if the inputs contain Unicode characters? How would you adapt 
your solution to such a case? 

 Related Topics 哈希表 字符串 排序 👍 714 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.util.Arrays;

  public class ValidAnagram{
      public static void main(String[] args) {
          Solution solution = new ValidAnagram().new Solution();
           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length(), n = t.length();
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        if(m != n){
            return false;
        }else{
            Arrays.sort(c1);
            Arrays.sort(c2);
//            for (int i = 0; i < n; i++) {
//                if(c1[i] != c2[i]){
//                    return false;
//                }
//            }

            return Arrays.equals(c1,c2);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }