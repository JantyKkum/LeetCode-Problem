  /**
Given a string s, return the string after replacing every uppercase letter with 
the same lowercase letter. 

 
 Example 1: 

 
Input: s = "Hello"
Output: "hello"
 

 Example 2: 

 
Input: s = "here"
Output: "here"
 

 Example 3: 

 
Input: s = "LOVELY"
Output: "lovely"
 

 
 Constraints: 

 
 1 <= s.length <= 100 
 s consists of printable ASCII characters. 
 

 Related Topics 字符串 👍 223 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.awt.print.Book;
  import java.util.Arrays;
  import java.util.Comparator;

  public class ToLowerCase {
      public static void main(String[] args) {
          Solution solution = new ToLowerCase().new Solution();
      }

      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public String toLowerCase(String s) {
              StringBuilder ans = new StringBuilder(s.length());
              for (int i = 0; i < s.length(); i++) {
                  if('A' <= s.charAt(i)  && s.charAt(i)<= 'Z'){
                      ans.append((char)(s.charAt(i) | 32));
                  }else{
                      ans.append(s.charAt(i));
                  }
              }
              return ans.toString();
          }

      }
//leetcode submit region end(Prohibit modification and deletion)

  }