package com.ellick.leetcode.l120;

import java.util.List;
//
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() != 1) {
            return 0;
        }
        int[] parents = new int[]{triangle.get(0).get(0)};
        //遍历每一层(第二层开始）
        for(int l = 1; l < triangle.size(); l++) {
            int[] temp = new int[l+1];
            //遍历每一层每个单元BFS
            temp[0] = parents[0]+triangle.get(l).get(0);
            temp[l] = parents[l-1]+triangle.get(l).get(l);
            for(int i = 1; i < l; i++) {
                temp[i] = Math.min(parents[i], parents[i-1]) + triangle.get(l).get(i);
            }
            parents = temp;
        }
        int sum = Integer.MAX_VALUE;
        for(int m = 0; m < parents.length; m++) {
            sum = Math.min(sum, parents[m]);
        }
        return sum;
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() != 1) {
            return 0;
        }
        int sum = minTotal1(triangle, 0, 0, 0);
        return sum;
    }

    public int minTotal1(List<List<Integer>> triangle, int level, int idx, int sum) {
        sum+=triangle.get(level).get(idx);
        if(level == triangle.size() - 1)
            return sum;
        else
            return Math.min(minTotal1(triangle, level+1, idx, sum), minTotal1(triangle, level+1, idx+1, sum));
    }
}
