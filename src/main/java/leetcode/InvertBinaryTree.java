package leetcode;
import java.util.HashMap;
/**
 * https://leetcode.com/problems/invert-binary-tree/description/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InvertBinaryTree {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    if (root.left == null && root.right == null) return root;

    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    if (root.left != null) invertTree(root.left);
    if (root.right != null) invertTree(root.right);

    return root;
  }

  /* Let's write a recursive solution first 
  public TreeNode invertTree(TreeNode root) {
    TreeNode ret = root;
    if (ret.left == null && ret.right == null) return ret;

    HashMap<Integer, TreeNode> parents = new HashMap<>();
    HashMap<Integer, TreeNode> children = new HashMap<>();

    int level = 0;
    parents.put(0, root);
    while(parents.size() > 0){
      ++level;
      int maxChildren = Math.pow(2, level);

    }
  } */
}
