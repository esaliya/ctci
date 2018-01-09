package leetcode;

import java.util.Arrays;

public class CountingBits {
  public static void main(String[] args) {
    int num = args.length > 0 ? Integer.parseInt(args[0]) : 0;
    CountingBits p = new CountingBits();
    System.out.println(Arrays.toString(p.countBits(num)));
  }

  public int[] countBits(int num) {
    int [] ret = new int[num+1];
    ret[0] = 0;
    for (int i = 1; i <= num; ++i) {
      boolean isOdd = (i & 1) == 1;
      //System.out.println("i: " + i + " isOdd " + isOdd + " (i&1) " + (i&1));
      if (isOdd) {
        ret[i] = ret[i-1]+1;
      } else {
        ret[i] = ret[i>>1];
      }
    }
    return ret;
  }

 /* this is wrong because it wasn't handling the case when
  * numbers go from odd to even. Works up to 5 but fails afterwards.
  * 
  * Also, no need to trouble this much on this, see the logic above
  */
  /*
  public int[] countBits(int num) {
    if (num == 0) return new int[]{0};

    int [] ret = new int[num+1];
    ret[0] = 0;

    int bitsLeft = 1;
    int bitsUsed = 0;
    for (int i = 1; i <= num; ++i) {
      if (bitsUsed < bitsLeft) {
        ++bitsUsed;
      } else {
        ++bitsLeft; 
        bitsUsed = 1;
      }
      ret[i] = bitsUsed;
    }

    return ret;
  }
  */
}
