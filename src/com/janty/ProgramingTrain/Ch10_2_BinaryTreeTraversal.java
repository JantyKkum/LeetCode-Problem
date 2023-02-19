package com.janty.ProgramingTrain;

import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: 二叉树遍历
 * @date: 2023/2/6 8:36
 * @description: 牛客网：https://www.nowcoder.com/practice/6e732a9632bc4d12b442469aed7fe9ce?tpId=40&tqId=21544&tPage=1&rp=1&ru=/ta/kaoyan&qru=/ta/kaoyan/question-ranking
 */
public class Ch10_2_BinaryTreeTraversal {

    //定义树的结构体
    static class TreeNode{
        char data;
        TreeNode leftChild = null;          //默认值
        TreeNode rightChild = null;         //默认值

        public TreeNode() {
        }

        public TreeNode(char data) {
            this.data = data;
        }

        public TreeNode(char data, TreeNode leftChild, TreeNode rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

    }

    //定义方法1：前序和中序序列返回唯一的树的根节点
    public static TreeNode findRoot(String preOrder, String inOrder){
        if(preOrder.length() == 0) return null;            //当前序遍历长度为0时，返回
        char rootdata = preOrder.charAt(0);                //根节点为前序的第一个字符
        int index = inOrder.indexOf(rootdata);             //找到其在中序中的位置

        TreeNode root = new TreeNode(rootdata);

        root.leftChild = findRoot(                         //递归查找左子树的根节点
                preOrder.substring(1,index+1),
                inOrder.substring(0,index));
        if(index+1 <= preOrder.length()){
            root.rightChild = findRoot(                         //递归查找左子树的根节点
                    preOrder.substring(index+1,preOrder.length()),
                    inOrder.substring(index+1,inOrder.length()));
        }
        return root;
    }

    //定义方法2：后序遍历
    public static void postOrder(TreeNode root){
        if(root == null) return;
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.print(root.data);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String preOrder = scanner.nextLine();
            String inOrder = scanner.nextLine();
            TreeNode root = findRoot(preOrder, inOrder);       //调用方法1
            postOrder(root);                                   //调用方法2
            System.out.println();                              //换行
        }
    }
}
