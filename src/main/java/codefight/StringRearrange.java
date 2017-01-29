package codefight;

/**
 * Saliya Ekanayake on 1/6/17.
 *
 * https://codefights.com/challenge/RWQS5cCEodqSWx4bR?utm_source=facebook&utm_medium=cpc&utm_campaign=Solve_A_Challenge_V11%28US%29
 *
 * Given an array of equal-length strings, check if it is possible to rearrange the strings in such a way that after the rearrangement the strings at consecutive positions would differ by exactly one character.

 Example

 For inputArray = ["aba", "bbb", "bab"], the output should be
 stringsRearrangement(inputArray) = false;
 For inputArray = ["ab", "bb", "aa"], the output should be
 stringsRearrangement(inputArray) = true.
 */
public class StringRearrange {
    public static void main(String[] args) {
        String[] strings = new String[]{"ab", "bb", "aa"}; // expected true

        // OK, my solution will pin the first string and arrange others based on that. That's why it fails
        System.out.println(new StringRearrange().stringsRearrangement(strings));
    }

    boolean stringsRearrangement(String[] inputArray) {
        int len = inputArray.length;
        short[][] differByOnes = new short[len][len];
        for (int i = 0; i < len; ++i){
            differByOnes[i][i] = 0;
            for (int j = 0; j < i; ++j){
//                differByOnes[]
            }
        }
        return false;
    }


//    boolean stringsRearrangement(String[] inputArray) {
//        int len = inputArray.length;
//        for (int i = 0; i < len; ++i){
//            String s = inputArray[i];
//            for (int j = i+i; j < len; ++j){
//                String next = inputArray[j];
//                if (isDifferByOne(s, next)) {
//                    if (j == i+i) break;
//                    inputArray[j] = inputArray[i+1];
//                    inputArray[i+1] = next;
//                    break;
//                }
//            }
//
//            if (i < len-1 && !(isDifferByOne(s, inputArray[i+1]))) return false;
//        }
//        return true;
//    }

    boolean isDifferByOne(String s, String t){
        int diffs = 0;
        for (int i = 0; i < s.length(); ++i){
            if (s.charAt(i) != t.charAt(i)){
                ++diffs;
                if (diffs > 1) return false;
            }
        }
        return (diffs == 1);
    }
}
