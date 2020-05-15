package com.ellick.leetcode.l120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMinimumTotal {
    public static void main(String[] args) {
        MinimumTotal mt = new MinimumTotal();
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).addAll(Arrays.asList(new Integer[]{2}));
        triangle.add(new ArrayList<Integer>());
        triangle.get(1).addAll(Arrays.asList(new Integer[]{3,4}));
        triangle.add(new ArrayList<Integer>());
        triangle.get(2).addAll(Arrays.asList(new Integer[]{6,5,7}));
        triangle.add(new ArrayList<Integer>());
        triangle.get(3).addAll(Arrays.asList(new Integer[]{4,1,8,3}));
        mt.minimumTotal(triangle);
    }
}
