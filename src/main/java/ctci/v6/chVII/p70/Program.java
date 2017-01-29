package ctci.v6.chVII.p70;

import java.util.Hashtable;

/**
 *  Saliya Ekanayake on 1/3/17.
 *
 *  Given a smaller string s a bigger string b, design an algorithm to find
 *  all permutations of the shorter string within the longer one. Print the
 *  location of each permutation.
 *
 *  My implementation has O(ba) but there's a better O(b) algorithm.
 *  See http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
 */
public class Program {
    /*
    s = "anti"
    b = "kantianpqnaitrd"
     */
    public static void main(String[] args) {
        String s = "antia";
        String b = "kantianapqnaitard";

        int IDX_TOT = 0;
        int IDX_COUNT = 1;
        Hashtable<Character, Integer[]> pattern = new Hashtable<>();
        for (int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            pattern.merge(c, new Integer[]{1,0}, (p,q) -> {p[IDX_TOT] += q[IDX_TOT]; p[IDX_COUNT] += q[IDX_COUNT]; return p;});
        }

        int windowLength = s.length();

        for (int i = 0; i < b.length(); ++i){
            if (!pattern.containsKey(b.charAt(i))) continue;

            /* possible to find a permutation ahead */

            boolean success = true;
            // reset counts
            for (Character c : pattern.keySet()){
                pattern.get(c)[IDX_COUNT] = 0;
            }
            pattern.get(b.charAt(i))[IDX_COUNT] = 1;

            for (int j = i+1; (j < i+windowLength) && (j < b.length()); ++j){
                if (!pattern.containsKey(b.charAt(j))){
                    success = false;
                    break;
                }

                // OK, keep going but see if we enough of this character left in the pattern
                Integer[] arr = pattern.get(b.charAt(j));
                if (arr[IDX_COUNT].intValue() == arr[IDX_TOT].intValue()) {
                    success = false;
                    break; // can't increment
                }
                // increment if we still come here
                ++arr[IDX_COUNT];
            }

            if (success){
                System.out.println("Permutation at idx " + i + " --> " + b.substring(i, i+windowLength));
            }
        }
    }
}
