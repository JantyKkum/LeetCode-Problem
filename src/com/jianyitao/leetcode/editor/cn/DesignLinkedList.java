  /**
Design your implementation of the linked list. You can choose to use a singly 
or doubly linked list. A node in a singly linked list should have two attributes: 
val and next. val is the value of the current node, and next is a pointer/
reference to the next node. If you want to use the doubly linked list, you will need 
one more attribute prev to indicate the previous node in the linked list. Assume 
all nodes in the linked list are 0-indexed. 

 Implement the MyLinkedList class: 

 
 MyLinkedList() Initializes the MyLinkedList object. 
 int get(int index) Get the value of the indexᵗʰ node in the linked list. If 
the index is invalid, return -1. 
 void addAtHead(int val) Add a node of value val before the first element of 
the linked list. After the insertion, the new node will be the first node of the 
linked list. 
 void addAtTail(int val) Append a node of value val as the last element of the 
linked list. 
 void addAtIndex(int index, int val) Add a node of value val before the indexᵗʰ 
node in the linked list. If index equals the length of the linked list, the 
node will be appended to the end of the linked list. If index is greater than the 
length, the node will not be inserted. 
 void deleteAtIndex(int index) Delete the indexᵗʰ node in the linked list, if 
the index is valid. 
 

 
 Example 1: 

 
Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex",
 "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3
 

 
 Constraints: 

 
 0 <= index, val <= 1000 
 Please do not use the built-in LinkedList library. 
 At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and 
deleteAtIndex. 
 

 Related Topics 设计 链表 👍 734 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.util.LinkedList;

  public class DesignLinkedList{
      public static void main(String[] args) {

           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class MyLinkedList {
    LinkedList<Integer> linkedList;
    public MyLinkedList() {
        linkedList = new LinkedList<>();
    }
    
    public int get(int index) {
        if(index < 0 || index >= linkedList.size()) return -1;
        return linkedList.get(index);
    }
    
    public void addAtHead(int val) {
        LinkedList<Integer> temp = new LinkedList<>();
        linkedList.add(0,val);
    }
    
    public void addAtTail(int val) {
        linkedList.add(val);
    }
    
    public void addAtIndex(int index, int val) {

    }
    
    public void deleteAtIndex(int index) {

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }