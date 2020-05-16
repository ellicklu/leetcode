package com.ellick.leetcode.l199;

import com.ellick.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rmv = new ArrayList<Integer>();
        if (root == null)
            return rmv;
        List<Integer> rmost = new ArrayList<Integer>();
        exploreNode(root, rmost, rmv, 0, 0);
        return rmv;
    }

    private void exploreNode(TreeNode root, List<Integer> rmost, List<Integer> rmv, int idx, int level){
        if(rmv.size() < level+1) {
            rmv.add(root.val);
            rmost.add(idx);
        } else if (idx > rmost.get(level)) {
            rmv.set(level, root.val);
            rmost.set(level, idx);
        }
        if(root.left != null)
            exploreNode(root.left, rmost, rmv, 2*idx+1, level+1);
        if(root.right != null)
            exploreNode(root.right, rmost, rmv, 2*idx+2, level+1);
    }
}
