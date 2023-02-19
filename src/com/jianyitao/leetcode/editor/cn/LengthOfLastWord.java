  /**
Given a string s consisting of words and spaces, return the length of the last 
word in the string. 

 A word is a maximal substring consisting of non-space characters only. 

 
 Example 1: 

 
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
 

 Example 2: 

 
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
 

 Example 3: 

 
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 

 
 Constraints: 

 
 1 <= s.length <= 10⁴ 
 s consists of only English letters and spaces ' '. 
 There will be at least one word in s. 
 

 Related Topics 字符串 👍 540 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import com.janty.test.Dog;

  import java.io.*;
  import java.util.Arrays;
  import java.util.Properties;

  public class LengthOfLastWord{
      public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
          int[] a =new int[10];
          int[] b =new int[10];
          for (int i = 0; i < 10; i++) {
              a[i] = i;
              b[i] = i;
          }
          System.out.println(a==b);
          System.out.println(Arrays.equals(a, b));
          Properties properties = new Properties();
          String filePath = "src\\com\\jianyitao\\leetcode\\editor\\cn\\doc\\dog.dat";
          properties.load(new InputStreamReader(new FileInputStream(filePath)));
          properties.get(filePath);
//          System.out.println(classPath);
          String name = (String) properties.get("name");
          int age = Integer.parseInt((String) properties.get("age"));
          String color = (String) properties.get("color");
//          System.out.println(name+age+color+" ");
//          Class cls = Class.forName(classPath);
//          Object o = cls.newInstance();
//          Method dog = cls.getMethod("Dog");
          Dog dog1 = new Dog(name, age, color);
          System.out.println(dog1);

//          Constructor constructor = cls.getConstructor();
//          System.out.println(constructor);


      }


      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {

        String[] ans = s.split(" ");
        return ans[ans.length-1].length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }