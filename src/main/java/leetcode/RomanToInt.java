package leetcode;

import java.util.HashMap;

/**
 * Saliya Ekanayake on 12/3/17.
 */
public class RomanToInt {
    public static void main(String[] args) {
        RomanToInt p = new RomanToInt();
        System.out.println(p.romanToInt(args[0]));
    }

    public int romanToInt(String s){
      int A = 'A';
      int Z = 'Z';
      int len = (Z-A)+1;

      int [] romanVals = new int[len];
      romanVals[(int)'I'-A] = 1;
      romanVals[(int)'V'-A] = 5;
      romanVals[(int)'X'-A] = 10;
      romanVals[(int)'L'-A] = 50;
      romanVals[(int)'C'-A] = 100;
      romanVals[(int)'D'-A] = 500;
      romanVals[(int)'M'-A] = 1000;

      int num = 0;
      int prev = 0;
      for (int i = 0; i < s.length(); ++i) {
        char c = s.charAt(i); // Assume capital letters, else we could do toUppercase();
        int temp = romanVals[(int)c - A];
        if (prev != 0 && temp > prev){
          num += temp - 2*prev;
          prev = 0;
        } else {
          num += temp;
          prev = temp;
        }
      }

      return num;
    }
}
