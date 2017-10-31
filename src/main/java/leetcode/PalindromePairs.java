package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Saliya Ekanayake on 9/20/17.
 *
 * https://leetcode.com/problems/palindrome-pairs/description/
 */
public class PalindromePairs {
    public static void main(String[] args) {
        String [] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        PalindromePairs pp = new PalindromePairs();
        List<List<Integer>> ids = pp.palindromePairs(words);
        System.out.print("[ ");
        for (List<Integer> pair : ids){
            System.out.print("["+pair.get(0)+","+pair.get(1)+"] ");
        }
        System.out.println("]");
    }

    // TODO - can we do better than the two loop bruteforce
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < words.length; ++i){
            for (int j = 0; j < words.length; ++j){
                if (i == j) continue;
                if (checkPalindrome(words[i], words[j])){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    ret.add(pair);
                }
            }
        }
        return ret;
    }

    private boolean checkPalindrome(String a, String b){
        assert (a != null && b != null);
        String c = a+b;
        int len = c.length();
        boolean isPalindrome = true;
        for (int i = 0; i < len/2; ++i){
            if (c.charAt(i) == c.charAt((len - 1) - i)) continue;
            isPalindrome = false;
            break;
        }
        return isPalindrome;
    }
}
