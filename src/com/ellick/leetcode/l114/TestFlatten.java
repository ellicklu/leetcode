package com.ellick.leetcode.l114;

import com.ellick.leetcode.TreeNode;

public class TestFlatten {
    public static void main(String args[]){
        TreeNode root = TreeNode.constructTree(new Integer[]{1,2,5,3,4,null,6});
        Flatten flat = new Flatten();
        flat.flatten(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }
}
