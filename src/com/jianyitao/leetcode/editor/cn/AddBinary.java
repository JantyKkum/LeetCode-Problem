  /**
Given two binary strings a and b, return their sum as a binary string. 

 
 Example 1: 
 Input: a = "11", b = "1"
Output: "100"
 
 Example 2: 
 Input: a = "1010", b = "1011"
Output: "10101"
 
 
 Constraints: 

 
 1 <= a.length, b.length <= 10⁴ 
 a and b consist only of '0' or '1' characters. 
 Each string does not contain leading zeros except for the zero itself. 
 

 Related Topics 位运算 数学 字符串 模拟 👍 945 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.io.*;

  public class AddBinary{
      public static void main(String[] args) throws IOException {
          String filePath1 = "F:/mytemp";
          File file = new File(filePath1);
          if(!file.exists()){
              file.mkdir();
          }
          String filePath2 = "F:/mytemp/hello.txt";
          File file2 = new File(filePath2);
          if(!file2.exists()){
              file2.createNewFile();

          }
          BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
          bufferedWriter.write("这是一个测试例子阿萨德三等奖asdasdas");
          bufferedWriter.close();
          System.exit(0);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int carry = 0,tempa,tempb;
        StringBuilder sb = new StringBuilder();
        int n = Math.max(a.length(),b.length());
        if(a.equals("0") && b.equals("0")){
            return "0";
        }
        for (int i = 0; i < n; i++) {
            if(i < a.length()){        //a的长度范围内读取a的数值位
                tempa = a.charAt(a.length()-i-1)-'0' ;
            }else{
                tempa = 0;
            }
            if(i < b.length()){        //b的长度范围内读取a的数值位
                tempb = b.charAt(b.length()-i-1)-'0';
            }else{
                tempb = 0;
            }

            sb.append((tempa+tempb+carry)%2);
            carry = ((tempa+tempb+carry)/2);
        }
        if(carry == 1){
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }