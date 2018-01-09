package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Saliya Ekanayake on 10/31/17.
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 */
public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        /*
        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7
       */

        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        root.left = l;
        TreeNode ll = new TreeNode(4);
        l.left = ll;
        TreeNode r = new TreeNode(3);
        root.right = r;
        l = new TreeNode(5);
        r.left = l;
        ll = new TreeNode(7);
        l.left = ll;
        TreeNode rr = new TreeNode(6);
        r.right = rr;

        root.print();

        FindBottomLeftTreeValue p = new FindBottomLeftTreeValue();
        p.findBottomLeftValue(root);

    }

    public int findBottomLeftValue(TreeNode root) {
        int[] ret = findrec(root, 0, 0);
        return ret[2];
    }

    public int[] findrec(TreeNode n, int d, int l){
        if (n.left == null && n.right == null){
            return new int[]{l, d, n.val};
        }

        int[] lt = null;
        int[] rt = null;
        if (n.left != null){
            lt = findrec(n.left, 2*d, l+1);
        }

        if (n.right != null){
            rt = findrec(n.right, 2*d+1, l+1);
        }

        if (rt == null){
            return lt;
        } else {
            if (lt == null){
                return rt;
            } else {
                return lt[0] >= rt[0] ? lt : rt;
            }
        }
    }
}
