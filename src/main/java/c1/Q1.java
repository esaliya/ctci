package c1;

import java.util.HashSet;

public class Q1 {
    public static void main(String[] args) {
        String testStr = "abcdefgh;";

        System.out.println(isAllUniqueWithHashing(testStr));
    }

    private static boolean isAllUniqueWithHashing(String testStr) {
        HashSet<Character> hs = new HashSet<Character>();
        int length = testStr.length();
        for (int i = 0; i < length; ++i){
            char c = testStr.charAt(i);
            if (hs.contains(c)) return false;
            hs.add(c);
        }
        return true;
    }


}
