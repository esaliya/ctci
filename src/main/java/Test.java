/**
 * Saliya Ekanayake on 2/4/17.
 */
public class Test {
    public static void main(String[] args) {
        String s = "00110";
//        String s = "1100010";
        System.out.println(counting(s));
    }

    static int counting(String s) {
        int len = s.length();
        int count = 0;
        if (len < 2) return count;

        char junk = 'a';
        char lVal = s.charAt(0);
        char rVal = junk;
        int lSameCount = 1; // to keep track of how many similar values seen on left
        int rIdx = 0;

        for (int i = 1; i < len; ++i){
            rVal = s.charAt(i);
            if (rVal == lVal){
                ++lSameCount;
            } else {
                lVal = rVal;
                ++count;
                int j = 1;
                boolean dont = false;
                for (; j < lSameCount; ++j){
                    if (j+i == len) break;
                    if (rVal == s.charAt(j+i)){
                        ++count;
                    } else {
                        lSameCount = j;
                        i+=(j-1); // -1 because the loop will anyway increment i
                        dont = true;
                        break;
                    }
                }
                if (!dont) {
                    i += j - 1;
                }
            }
        }
        return count;
    }
}
