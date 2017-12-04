package leetcode;

/**
 * Saliya Ekanayake on 11/12/17.
 * https://leetcode.com/problems/arithmetic-slices/description/
 *
 A = [1, 2, 3, 4]
 return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
        ArithmeticSlices p = new ArithmeticSlices();
        int [] a = new int[]{1, 2, 3, 4};
        System.out.println(p.numberOfArithmeticSlices(a));
    }
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int startIdx = 0;
        int minLength = 3;
        if (A.length < minLength) return 0;

        while (startIdx <= A.length - minLength) {
            int arithmeticLength = 0;
            int diff = A[startIdx+1]-A[startIdx];
            for (int i = startIdx+2; i < A.length; ++i) {
                if (A[i]-A[i-1] == diff){
                    arithmeticLength += arithmeticLength == 0 ? 3 : 1;
                } else {
                    startIdx = i-1;
                    break;
                }
                if (i == A.length - 1){
                    startIdx = i;
                }
            }
            if (arithmeticLength != 0){
                count += (arithmeticLength*arithmeticLength - 3*arithmeticLength + 2)/2;
            }
        }
        return count;
    }
}
