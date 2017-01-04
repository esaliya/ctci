package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by esaliya on 12/5/16.
 */

/*
https://leetcode.com/problems/3sum/

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {
    public static void main(String[] args) {

    }
//    public List<List<Integer>> threeSum(int[] nums) {
//        HashMap<Integer, List<Integer>> hm = new HashMap<>();
//        for (int i = 0; i < nums.length; ++i){
//            for (int j = i+1; j < nums.length; ++j){
//                int sum = nums[i]+nums[j];
//                if (hm.containsKey(sum)){
//                    hm.get(sum).add(i);
//                    hm.get(sum).add(j);
//                } else {
//                    List<Integer> l = new ArrayList<>();
//                    l.add(i);
//                    l.add(j);
//                    hm.put(sum, l);
//                }
//            }
//        }
//    }
}
