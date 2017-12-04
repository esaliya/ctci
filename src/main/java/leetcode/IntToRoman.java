package leetcode;
import java.util.HashMap;
public class IntToRoman {
  public static void main(String [] args) {
    IntToRoman p = new IntToRoman();
    System.out.println(p.intToRoman(Integer.parseInt(args[0])));
  }

  public String intToRoman(int n){
    HashMap<Integer, String> numToRoman = new HashMap<>();
    numToRoman.put(1, "I");
    numToRoman.put(5, "V");
    numToRoman.put(10, "X");
    numToRoman.put(50, "L");
    numToRoman.put(100, "C");
    numToRoman.put(500, "D");
    numToRoman.put(1000, "M");

    String romanNum = "";
    int mul = 10;
    while (n > 0) {
      int d = n%10;
      int base = mul/10;
      int mid = mul/2;
      if (d < 4){
        String roman = numToRoman.get(base);
        for (int i = 0; i < d; ++i) {
          romanNum = roman + romanNum;
        }
      } else if (d == 4) {
        romanNum = numToRoman.get(base) + numToRoman.get(mid) + romanNum;
      } else if (d == 5) {
        romanNum = numToRoman.get(mid) + romanNum;
      } else if (d < 9) {
        String roman = numToRoman.get(mid);
        for (int i = 5; i < d; ++i) {
          roman += numToRoman.get(base);
        }
        romanNum = roman + romanNum;
      } else {
        romanNum = numToRoman.get(base) + numToRoman.get(mul) + romanNum;
      }
      mul *= 10;
      n /= 10;
    }
    return romanNum;
  }
}
