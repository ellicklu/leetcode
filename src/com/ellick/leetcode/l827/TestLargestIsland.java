package com.ellick.leetcode.l827;

public class TestLargestIsland {
    public static void main(String[] args) {
        LargestIsland fd = new LargestIsland();
        //int[][] grid = new int[][]{{1,1,0},{1,0,1},{0,1,1}};
        //int[][] grid = new int[][]{{1,1},{1,1}};
        int[][] grid = new int[][]{{1,0,1},{0,0,0},{0,1,1}};
        int size = fd.largestIsland(grid);
        System.out.println(size);
    }
}
