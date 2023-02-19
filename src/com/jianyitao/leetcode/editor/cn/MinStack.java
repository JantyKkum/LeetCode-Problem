  /**
Design a stack that supports push, pop, top, and retrieving the minimum element 
in constant time. 

 Implement the MinStack class: 

 
 MinStack() initializes the stack object. 
 void push(int val) pushes the element val onto the stack. 
 void pop() removes the element on the top of the stack. 
 int top() gets the top element of the stack. 
 int getMin() retrieves the minimum element in the stack. 
 

 You must implement a solution with O(1) time complexity for each function. 

 
 Example 1: 

 
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

 
 Constraints: 

 
 -2³¹ <= val <= 2³¹ - 1 
 Methods pop, top and getMin operations will always be called on non-empty 
stacks. 
 At most 3 * 10⁴ calls will be made to push, pop, top, and getMin. 
 

 Related Topics 栈 设计 👍 1491 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.util.Deque;
  import java.util.LinkedList;
  import java.util.PriorityQueue;

  public class MinStack{
      public static void main(String[] args) {

           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class MinStack1 {
    Deque<Integer> minStack;
    Deque<Integer> myStack;

    public MinStack1() {
        myStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val){
        myStack.push(val);
        minStack.push(Math.min(minStack.peek(),val));
    }
    
    public void pop() {
        myStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return myStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

  }

