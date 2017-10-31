package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Saliya Ekanayake on 9/21/17.
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 */
public class AllDuplicates {
    public static void main(String[] args) {
        AllDuplicates ad = new AllDuplicates();
//        int [] nums = new int[]{4,3,2,7,8,2,3,1};
        int [] nums = new int[]{10,2,5,10,9,1,1,4,3,7};
        System.out.println(Arrays.toString(ad.findDuplicates(nums).toArray()));
        System.out.println(Arrays.toString(ad.findDuplicatesWithoutExtraSpaceAndInOnTime(nums).toArray()));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> retList = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int n : nums){
            if (hs.contains(n)) {
                retList.add(n);
            } else {
                hs.add(n);
            }
        }
        return retList;
    }

    /*Could you do it without extra space and in O(n) runtime?
    *
    * The key to solving this is to realize that numbers in the array are between [1,n]
    * so we can use the value (minus 1) as an index to the array. The idea is all we
    * want is to make elements dirty if two points to the same element */
    public List<Integer> findDuplicatesWithoutExtraSpaceAndInOnTime(int[] nums) {
        List<Integer> retList = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i){
            int val = nums[i];
            int idx = (val > 0 && val <= n) ? (n-1) : (val > n ? (val - (n+1)) : -val - 1);


        }


        return retList;
    }
}
