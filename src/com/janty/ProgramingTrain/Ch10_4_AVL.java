package com.janty.ProgramingTrain;

import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: LeetCode-Problem
 * @date: 2023/2/6 9:36
 * @description: 牛客网：https://www.nowcoder.com/practice/b42cfd38923c4b72bde19b795e78bcb3?tpld=69&tqld=29670&tPage=1&ru=/kaoyan/retest/11002&qru=/ta/hust-kaoyan/question-ranking
 */
public class Ch10_4_AVL {
    //定义树的结构体
    static class TreeNode{
        int data;
        TreeNode leftChild = null;          //默认值
        TreeNode rightChild = null;         //默认值

        public TreeNode() {
        }

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

    }

    //方法1：确定插入节点的根节点
    public static TreeNode insert(TreeNode root,int x){
        if(root == null){
            return new TreeNode(x);
        }else if(x > root.data) {
            root.rightChild = insert(root.rightChild,x);
        }else if(x < root.data) {
            root.leftChild = insert(root.leftChild,x);
        }
        return root;
    }

    //定义方法2：前序遍历
    public static void preOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    //定义方法3：中序遍历
    public static void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.leftChild);
        System.out.print(root.data+" ");
        inOrder(root.rightChild);
    }

    //定义方法4：后序遍历
    public static void postOrder(TreeNode root){
        if(root == null) return;
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.print(root.data+" ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            TreeNode tree = null;
            while (n-- > 0){
                int x = scanner.nextInt();
                tree = insert(tree,x);
            }
            preOrder(tree);
            System.out.println();
            inOrder(tree);
            System.out.println();
            postOrder(tree);
            System.out.println();
        }
    }
}
