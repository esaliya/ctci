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
    static class TreeNode implements Comparable<TreeNode>{
        boolean isDummy = false;
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, boolean isDummy){
            val = x;
            this.isDummy = isDummy;
        }

        void print(){
            int l = hrec() - 1;
            Queue<TreeNode> nodes = new LinkedList<>();
            nodes.add(this);
            while (l >= 0) {
                int spaceCount = (int) Math.pow(2,l) - 1;
                StringBuilder sb = getSpaces(spaceCount);
                int nodeCount = nodes.size();
                for (int i = 0; i < nodeCount; ++i) {
                    TreeNode n = nodes.remove();
                    sb.append(n.isDummy ? "*" : n.val);
                    nodes.add(n.left == null ? new TreeNode(-1, true) : n.left);
                    nodes.add(n.right == null ? new TreeNode(-1, true) : n.right);
                    sb.append(getSpaces(2*spaceCount+1));
                }
                System.out.println(sb.toString());
                --l;
            }
        }

        StringBuilder getSpaces(int count){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; ++i){
                sb.append(" ");
            }
            return sb;
        }

        int hrec(){
            return 1 + (Math.max((left != null) ? left.hrec() : 0, (right != null) ? right.hrec() : 0));
        }

        @Override
        public int compareTo(TreeNode o) {
            return val - o.val;
        }
    }

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
