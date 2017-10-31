package ctci.v6.ch2;

import java.util.LinkedList;

/**
 * Saliya Ekanayake on 4/17/17.
 */
public class Q1 {
    /*
    Write code to remove duplicates from an unsorted linked list.
    FOLLOW UP
    How would ou solve this problem if a temporary buffer is not allowed.
     */
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(2);
        ll.add(3);
        ll.add(2);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(7);
        ll.add(7);
        ll.add(9);


        System.out.println(ll);
    }
}
