package com.ellick.leetcode.l287;
//https://leetcode-cn.com/problems/find-the-duplicate-number/
public class FindDuplicate {
    //TODO: fast,slow pointers. loop twice, first get meet-point, second restart to meet again with same pace

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2)
            return -1;
        int low = 1;
        int up = nums.length - 1;
        while(low != up) {
            int mid = Math.floorDiv(low+up,2);
            int target = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] <= mid && nums[i] >= low)
                    target++;
            }
            if (mid-low+1 < target){
                up = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length < 2)
            return -1;
        int groups = (int) Math.floorDiv(nums.length,32)+1;
        for(int g = 0; g < groups; g++) {
            int chkIdx = 0;
            for(int i = 0 ; i < nums.length; i++) {
                if(nums[i] <= 32*(g+1) && nums[i] > 32*g){
                    int check_bit = 1<<(nums[i]-32*g-1);
                    if((check_bit&chkIdx) != 0)
                        return nums[i];
                    chkIdx = chkIdx|check_bit;
                }
            }
        }
        return -1;
    }
}
