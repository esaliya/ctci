package leetcode;

public class ZigZagConversion {
  public static void main(String [] args) {
    ZigZagConversion p = new ZigZagConversion();
    String s = args.length > 0 ? args[0] : "PAYPALISHIRING";
    int numRows = args.length > 1 ? Integer.parseInt(args[1]) : 3;
    System.out.println(p.convert(s, numRows));
    System.out.println(p.convertFast(s, numRows));
  }

  /* not much difference in timing */
  public String convertFast(String s, int numRows) {
    int len = s.length();
    if (numRows == 1 || s == null || s.length() <3) return s;

    char [] schars = s.toCharArray();
    char [] ret = new char[len];
    int idx = 0;
    for (int i = 0; i < numRows; ++i) {
      for (int j = i, k = (2*numRows-2)-i; ; j+=2*numRows-2, k+=2*numRows-2) {
        if (j < len) {
          ret[idx++] = schars[j];
        }

        if (i > 0 && i < numRows - 1 && k < len) {
          ret[idx++] = schars[k];
        }

        if (j >= len && k >= len) break;
      }
    }
    return new String(ret); 
  }

  public String convert(String s, int numRows) {
    int len = s.length();
    if (numRows == 1) return s;

    StringBuilder ret = new StringBuilder();
    for (int i = 0; i < numRows; ++i) {
      for (int j = i, k = (2*numRows-2)-i; ; j+=2*numRows-2, k+=2*numRows-2) {
        if (j < len) {
          ret.append(s.charAt(j));
        }

        if (i > 0 && i < numRows - 1 && k < len) {
          ret.append(s.charAt(k));
        }

        if (j >= len && k >= len) break;
      }
    }

    return ret.toString();
  } 
}
