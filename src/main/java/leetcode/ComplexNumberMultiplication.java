package leetcode;

/*
 * https://leetcode.com/problems/complex-number-multiplication/description/
 */

public class ComplexNumberMultiplication {
  public static void main(String[] args) {
    String a = "1+2i";
    String b = "-3+-5i";
  
    ComplexNumberMultiplication p = new ComplexNumberMultiplication();
    String ret = p.complexNumberMultiply(a,b);
    System.out.println("(" + a + ") * (" + b + ") = (" + ret + ")");  
  }

  public String complexNumberMultiply(String a, String b) {
    int pidx = a.indexOf('+');
    int ra = Integer.parseInt(a.substring(0, pidx));
    int ia = Integer.parseInt(a.substring(pidx+1, a.length()-1));

    pidx = b.indexOf('+');
    int rb = Integer.parseInt(b.substring(0, pidx));
    int ib = Integer.parseInt(b.substring(pidx+1, b.length()-1));

    int rret = ra*rb + -1*ia*ib;
    int iret = ra*ib + rb*ia;

    return rret + "+" + iret + "i";
  }
}
