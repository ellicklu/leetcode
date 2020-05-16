package com.ellick.leetcode.l827;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode-cn.com/problems/making-a-large-island/
public class LargestIsland {
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int[][] idx = new int[grid.length][grid[0].length];
        HashMap<Integer, Integer> islands = new HashMap<Integer, Integer>();
        int largestSize = 0 ;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length ; j++) {
                if (grid[i][j] == 0)
                    continue;
                int[] left = getLeft(i, j, grid, idx);
                int[] up = getUp(i, j, grid, idx);
                int tmpsize = 0;
                if(left[0] != 1 && up[0] != 1) {//new island
                    idx[i][j] = i*grid[0].length+j;
                    tmpsize = 1;
                    islands.put(idx[i][j], tmpsize);
                } else {
                    int[] leftSize = getRootIsland(islands, left[1]);
                    int[] upSize = getRootIsland(islands, up[1]);
                    if(left[0] == 1 && up[0] == 1) {//merge islands
                        if(leftSize[1] >= upSize[1] && leftSize[0] != upSize[0]) {//merge up to left
                            tmpsize = leftSize[1]+upSize[1]+1;
                            islands.put(leftSize[0], tmpsize);
                            idx[i][j] = leftSize[0];
                            islands.put(upSize[0], 0-leftSize[0]);
                        } else if (leftSize[1] < upSize[1]){
                            tmpsize = leftSize[1]+upSize[1]+1;
                            islands.put(upSize[0], tmpsize);
                            idx[i][j] = upSize[0];
                            islands.put(leftSize[0], 0-upSize[0]);
                        } else {
                            tmpsize = leftSize[1]+1;
                            islands.put(leftSize[0], tmpsize);
                            idx[i][j] = leftSize[0];
                        }
                    } else if(left[0] == 1) {// add to left island
                        tmpsize = leftSize[1]+1;
                        islands.put(leftSize[0], tmpsize);
                        idx[i][j] = leftSize[0];
                    } else {// add to up island
                        tmpsize = upSize[1]+1;
                        islands.put(upSize[0], tmpsize);
                        idx[i][j] = upSize[0];
                    }
                }
                largestSize = Math.max(largestSize, tmpsize);
            }
        }

        for(Integer item : islands.keySet()) {
            System.out.println(item + "-" + islands.get(item));
        }
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    HashSet<Integer> toBridge  = new HashSet<Integer>();
                    if(get(i,j-1, grid) == 1)
                        toBridge.add(getRootIsland(islands, getIdx(i, j-1, idx))[0]);
                    if(get(i,j+1, grid) == 1)
                        toBridge.add(getRootIsland(islands, getIdx(i, j+1, idx))[0]);
                    if(get(i-1,j, grid) == 1)
                        toBridge.add(getRootIsland(islands, getIdx(i-1, j, idx))[0]);
                    if(get(i+1,j, grid) == 1)
                        toBridge.add(getRootIsland(islands, getIdx(i+1, j, idx))[0]);
                    int artifIslandSize = 1;
                    for(Integer isl : toBridge) {
                        if(islands.containsKey(isl))
                            artifIslandSize += islands.get(isl);
                    }
                    largestSize = Math.max(largestSize, artifIslandSize);
                }
            }
        }
        return largestSize;
    }
    int[] empty = new int[]{-1,0};
    private int[] getRootIsland(HashMap<Integer, Integer> islands, int idx){
        if(!islands.containsKey(idx))
            return empty;
        int size = islands.get(idx);
        while(size < 1) {
            idx = 0-size;
            size = islands.get(idx);
        }
        return new int[]{idx,size};
    }

    private int get(int x, int y, int[][] grid){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return -1;
        return grid[x][y];
    }

    private int getIdx(int x, int y, int[][] idx){
        if(x < 0 || y < 0 || x >= idx.length || y >= idx[0].length)
            return -1;
        return idx[x][y];
    }
    private int[] getLeft(int x, int y, int[][] grid, int[][] idx){
        return new int[]{get(x, y-1, grid), getIdx(x, y-1, idx)};
    }
    private int[] getUp(int x, int y, int[][] grid, int[][] idx){
        return new int[]{get(x-1, y, grid), getIdx(x-1, y, idx)};
    }
    private int[] getRight(int x, int y, int[][] grid, int[][] idx){
        return new int[]{get(x, y+1, grid), getIdx(x, y+1, idx)};
    }
    private int[] getDown(int x, int y, int[][] grid, int[][] idx){
        return new int[]{get(x+1, y, grid), getIdx(x+1, y, idx)};
    }
}
