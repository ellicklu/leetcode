package com.ellick.leetcode.l287;

public class TestFindDuplicate {
    public static void main(String[] args) {
        FindDuplicate fd = new FindDuplicate();
        int[] nums = new int[]{3,1,3,4,2};
        int dup = fd.findDuplicate(nums);
        System.out.println(dup);
    }
}
