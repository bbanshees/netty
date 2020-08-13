package com.algorithm.normal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @author: Spike
 * @date: 2020-07-03 14:43
 **/

public class TreeNodeTest {


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildTree();
    }

    static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    static class Solution {
        public TreeNode buildTree() {
            int preorder[]={3,9,20,15,7};
            int inorder[]={9,3,15,20,7};
            return rebuild(preorder, inorder);
        }

        //使用递归：找出规律，最初的条件定好，最后的条件定好。
        private TreeNode rebuild(int[] preorder, int[] inorder){

            if(preorder.length==0){
                return null;
            }
            TreeNode treeNode = new TreeNode(preorder[0]);
            if(preorder.length==1){
                return treeNode;
            }
            List<Integer> list = Arrays.stream(inorder).boxed().collect(Collectors.toList());
            int index = list.indexOf(preorder[0]);

            int[] leftPre = arraySub(preorder,1,index+1);
            int[] leftIn = arraySub(inorder,0,index);

            int[] rightPre = arraySub(preorder,index+1,preorder.length);
            int[] rightIn = arraySub(inorder,index+1,inorder.length);

            treeNode.left = rebuild(leftPre, leftIn);

            treeNode.right = rebuild(rightPre, rightIn);

            return treeNode;

        }

        private  int[] arraySub(int[] data,int start,int end){
            int[] C=new int[end-start];//新建数组C长度为start-end
            int j=0;
            for(int i=start;i<end;i++){
                C[j]=data[i];
                j++;
            }
            return C;//返回截取数组的地址
        }
    }
}
