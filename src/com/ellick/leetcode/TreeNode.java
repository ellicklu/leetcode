package com.ellick.leetcode;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode constructTree(Integer[] array) {
        TreeNode[] nodesArray = new TreeNode[array.length];
        for(int i = 0; i < array.length; i++) {
            if(array[i] != null){
                TreeNode node = new TreeNode(array[i]);
                int parentIdx = Math.floorDiv(i-1,2);
                if(parentIdx < 0) {
                    nodesArray[0] = node;
                } else {
                    nodesArray[i] = node;
                    if((i & 1) == 1)
                        nodesArray[parentIdx].left = node;
                    else
                        nodesArray[parentIdx].right = node;
                }
            }
        }
        return nodesArray[0];
    }
}