  /**
Design a parking system for a parking lot. The parking lot has three kinds of 
parking spaces: big, medium, and small, with a fixed number of slots for each 
size. 

 Implement the ParkingSystem class: 

 
 ParkingSystem(int big, int medium, int small) Initializes object of the 
ParkingSystem class. The number of slots for each parking space are given as part of 
the constructor. 
 bool addCar(int carType) Checks whether there is a parking space of carType 
for the car that wants to get into the parking lot. carType can be of three kinds: 
big, medium, or small, which are represented by 1, 2, and 3 respectively. A car 
can only park in a parking space of its carType. If there is no space available,
 return false, else park the car in that size space and return true. 
 

 
 Example 1: 

 
Input
["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
[[1, 1, 0], [1], [2], [3], [1]]
Output
[null, true, true, false, false]

Explanation
ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
parkingSystem.addCar(1); // return true because there is 1 available slot for a 
big car
parkingSystem.addCar(2); // return true because there is 1 available slot for a 
medium car
parkingSystem.addCar(3); // return false because there is no available slot for 
a small car
parkingSystem.addCar(1); // return false because there is no available slot for 
a big car. It is already occupied.
 

 
 Constraints: 

 
 0 <= big, medium, small <= 1000 
 carType is 1, 2, or 3 
 At most 1000 calls will be made to addCar 
 

 Related Topics 设计 计数 模拟 👍 124 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.math.BigDecimal;

  public class DesignParkingSystem{
      public static void main(String[] args) {
          BigDecimal bigDecimal = new BigDecimal("1999.11");
          BigDecimal bigDecimal2 = new BigDecimal("3.124570");
          System.out.println(bigDecimal.add(bigDecimal2));
          System.out.println(bigDecimal.subtract(bigDecimal2));
          System.out.println(bigDecimal.multiply(bigDecimal2));
//System.out.println(bigDecimal.divide(bigDecimal2));//可能抛出异常 ArithmeticException
//在调用 divide 方法时， 指定精度即可. BigDecimal.ROUND_CEILING
//如果有无限循环小数， 就会保留 分子 的精度
          System.out.println(bigDecimal.divide(bigDecimal2, BigDecimal.ROUND_CEILING));
           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class ParkingSystem {
    int bigContent;
    int midContent;
    int smallContent;

    public ParkingSystem(int big, int medium, int small) {
        bigContent += big;
        midContent += medium;
        smallContent += small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1 && bigContent > 0){
            bigContent--;
            return true;

        }else if(carType == 2 && midContent > 0){
            midContent--;
            return true;

        }else if(carType == 3 && smallContent > 0){
            smallContent--;
            return true;

        }else{
            return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }