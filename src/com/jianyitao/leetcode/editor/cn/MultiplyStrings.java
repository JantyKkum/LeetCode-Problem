  /**
Given two non-negative integers num1 and num2 represented as strings, return 
the product of num1 and num2, also represented as a string. 

 Note: You must not use any built-in BigInteger library or convert the inputs 
to integer directly. 

 
 Example 1: 
 Input: num1 = "2", num2 = "3"
Output: "6"
 
 Example 2: 
 Input: num1 = "123", num2 = "456"
Output: "56088"
 
 
 Constraints: 

 
 1 <= num1.length, num2.length <= 200 
 num1 and num2 consist of digits only. 
 Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 
 

 Related Topics 数学 字符串 模拟 👍 1125 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;
  
  public class MultiplyStrings{
      public static void main(String[] args) {
          Solution solution = new MultiplyStrings().new Solution();
           String s1 = "123456789";
          String s2 ="987654321";
          System.out.println(solution.multiply(s1, s2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
        int[] a3 = new int[n1+n2];

        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        for (int i = 0; i < n1; i++) {
            a1[i] = (int)(num1.charAt(n1-1-i)-'0');
        }

        for (int i = 0; i < n2; i++) {
            a2[i] = (int)(num2.charAt(n2-1-i)-'0');
            for (int j = 0; j < n1; j++) {
                int sum = a3[i+j] + a1[j] * a2[i];
                a3[i+j] = sum % 10;
                a3[i+j+1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n1+n2-1; i >= 0; i--) {
            if(sb.length()==0 && a3[i]==0){
                continue;
            }
            sb.append(a3[i]);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }