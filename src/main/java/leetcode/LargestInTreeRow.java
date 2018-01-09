package leetcode;

/*
 * Saliya Ekanayake 01/07/2018
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class LargestInTreeRow {
  public static void main(String[] args) {
    /*
     *     1
     *    / \
     *   3   2
     *  / \   \
     * 5   3   9
     */

    TreeNode root = new TreeNode(1);
    TreeNode l = new TreeNode(3);
    root.left = l;
    TreeNode r = new TreeNode(2);
    root.right = r;
    TreeNode ll = new TreeNode(5);
    l.left = ll;
    TreeNode rr = new TreeNode(3);
    l.right  = rr;
    rr = new TreeNode(9);
    r.right = rr;

    root.print();

    LargestInTreeRow p = new LargestInTreeRow();
    System.out.println(Arrays.toString(p.largestValues(root).toArray()));

  }

  public List<Integer> largestValues(TreeNode root) {
    List<Integer> vals = new ArrayList<>();
    List<TreeNode> nodes = new ArrayList<>();
    
    if (root == null) return vals;

    nodes.add(root);
    while (nodes.size() > 0) {
      helper(nodes, vals);
    }
    return vals;
  }

  public void helper(List<TreeNode> nodes, List<Integer> vals) {
    int size = nodes.size();
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < size; ++i) {
      TreeNode n = nodes.get(i);
      if (max < n.val) {
        max = n.val;
      }

      if (n.left != null) nodes.add(n.left);
      if (n.right != null) nodes.add(n.right);
    }

    for (int i = 0; i < size; ++i) {
      nodes.remove(0);
    }
    vals.add(max);
  }
}

