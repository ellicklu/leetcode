package com.ellick.leetcode.l199;

import com.ellick.leetcode.TreeNode;

public class TestRightSideView {
    public static void main(String[] args){
        RightSideView rightSideView = new RightSideView();
        TreeNode root = TreeNode.constructTree(new Integer[]{1,2,3,null,5,null,4});
        rightSideView.rightSideView(root);
    }
}
