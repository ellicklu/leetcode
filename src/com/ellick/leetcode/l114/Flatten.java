package com.ellick.leetcode.l114;

import com.ellick.leetcode.TreeNode;

import java.util.Stack;

//https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
public class Flatten {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while(!st.empty()){
            TreeNode node = st.pop();
            if(node.right != null)
                st.push(node.right);
            if(node.left != null) {
                node.right = node.left;
                st.push(node.right);
                node.left = null;
            }
            if(node.right == null && st.size() > 0)
                node.right = st.peek();
        }
    }
}
