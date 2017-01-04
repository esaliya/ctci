package leetcode;

import java.util.Arrays;

/**
 * Created by esaliya on 12/5/16.
 */

/*
https://leetcode.com/problems/two-sum/

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }

    /*
    The brute force approach
     */
    public int[] twoSum(int[] nums, int target) {
        int[] sol = new int[2];
        for (int i = 0; i < nums.length; ++i){
            sol[0] = i;
            int find = target - nums[i];
            for (int j = i+1; j < nums.length; ++j){
                if (nums[j] == find){
                    sol[1] = j;
                    return sol;
                }
            }
        }
        return sol;
    }
}
