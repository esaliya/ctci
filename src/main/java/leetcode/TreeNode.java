package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Saliya Ekanayake on 1/7/18.
 */
public class TreeNode implements Comparable<TreeNode>{
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

    private StringBuilder getSpaces(int count){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; ++i){
            sb.append(" ");
        }
        return sb;
    }

    private int hrec(){
        return 1 + (Math.max((left != null) ? left.hrec() : 0, (right != null) ? right.hrec() : 0));
    }

    @Override
    public int compareTo(TreeNode o) {
        return val - o.val;
    }
}
