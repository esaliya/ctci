package leetcode;

/**
 * Saliya Ekanayake on 9/17/17.
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }

        ListNode(int[] arr){
            int i = 0;
            ListNode current = this;
            while (i < arr.length){
                current.val = arr[i];
                if (i < arr.length -1) {
                    current.next = new ListNode(0);
                }
                current = current.next;
                ++i;
            }
        }

        void print(){
            ListNode current = this;
            System.out.print("[ ");
            while (current != null){
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{2,4,3});
//        ListNode l1 = new ListNode(new int[]{5});
        ListNode l2 = new ListNode(new int[]{5,6,4});
//        ListNode l2 = new ListNode(new int[]{5});
        ListNode lret = addTwoNumbers(l1, l2);
        lret.print();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lres = new ListNode(0);
        ListNode ret = lres;
        int q = 0;
        int r = 0;
        while (l1 != null || l2 != null){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x+y+lres.val;
            q = sum / 10;
            r = sum % 10;
            lres.val = r;
            if (q > 0 || (l1 != null && l1.next != null) || (l2 != null && l2.next != null)){
                lres.next = new ListNode(q);
                lres = lres.next;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return ret;
    }
}
