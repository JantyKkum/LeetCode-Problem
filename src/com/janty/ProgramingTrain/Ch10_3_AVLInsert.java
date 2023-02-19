package com.janty.ProgramingTrain;

import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: 二叉查找树
 * @date: 2023/2/6 10:46
 * @description: 牛客网：https://www.nowcoder.com/practice/30a0153649304645935c949df7599602?tpId=69&tqId=29654&tPage=1&ru=/kaoyan/retest/11002&qru=/ta/hust-kaoyan/question-ranking
 */
public class Ch10_3_AVLInsert {
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
    public static TreeNode insert(TreeNode root,int x,int father){
        if(root == null){
            root = new TreeNode(x);
            System.out.println(father);
        }else if(x > root.data) {
            root.rightChild = insert(root.rightChild,x,root.data);
        }else if(x < root.data) {
            root.leftChild = insert(root.leftChild,x,root.data);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            TreeNode tree = null;
            while (n-- > 0){
                int x = scanner.nextInt();
                tree = insert(tree, x,-1);
            }
        }
    }
}
