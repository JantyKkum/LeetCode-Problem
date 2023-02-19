  /**
Given two strings s and p, return an array of all the start indices of p's 
anagrams in s. You may return the answer in any order. 

 An Anagram is a word or phrase formed by rearranging the letters of a 
different word or phrase, typically using all the original letters exactly once. 

 
 Example 1: 

 
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
 

 Example 2: 

 
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

 
 Constraints: 

 
 1 <= s.length, p.length <= 3 * 10⁴ 
 s and p consist of lowercase English letters. 
 

 Related Topics 哈希表 字符串 滑动窗口 👍 1071 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.List;

  public class FindAllAnagramsInAString{
      public static void main(String[] args) {
          Solution solution = new FindAllAnagramsInAString().new Solution();
           
      }


      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = p.length();
        char[] pChar = p.toCharArray();
        Arrays.sort(pChar);
        for (int i = 0; i < s.length()-n+1; i++) {
            String subStr = s.substring(i,i+n);
            char[] subChar = subStr.toCharArray();
            Arrays.sort(subChar);
            if(Arrays.equals(subChar,pChar)) ans.add(i);
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
