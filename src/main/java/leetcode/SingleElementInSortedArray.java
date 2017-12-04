package leetcode;

/**
 * Saliya Ekanayake on 11/6/17.
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 */
public class SingleElementInSortedArray {
    public static void main(String[] args) {
        SingleElementInSortedArray p = new SingleElementInSortedArray();
//        int[] nums = new int[]{1,1,2,3,3,4,4,8,8};
        int[] nums = new int[]{1,1,3,3,4,4,7,8,8};
//        int[] nums = new int[]{1,1,2,4,4,8,8};
//        int[] nums = new int[]{1,1,4,4,7,8,8};
//        int[] nums = new int[]{1,1,2};
        System.out.println(p.singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        /* the numbers are sorted and each number appears twice except for the single element
        We can do binary search because we can figure out which half of the array contains
        the single element; see code below.
         */

        // Nice trick is checking for evenness and integer division by 2 can both be done using
        // bit operators. >>1 to divide by 2 and &1 == 0 to check for evenness.

        int l = 0;
        int r = nums.length - 1;
        while (l<r) {
            boolean evenPairs = (((r-l)>>1)&1) == 0;
            int m = ((l + r) >> 1);
            if (nums[m-1] == nums[m]){
                if (evenPairs) {
                    // going left
                    r = m;
                } else {
                    // going right
                    l = m+1;
                }
                continue;
            }

            if (nums[m+1] == nums[m]){
                if (evenPairs) {
                    // going right
                    l = m;
                } else {
                    // going left
                    r = m-1;
                }
                continue;
            }

            break;
        }
        return nums[(l+r)>>1];
    }
}
