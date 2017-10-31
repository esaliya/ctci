package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Saliya Ekanayake on 9/21/17.
 * https://leetcode.com/problems/maximum-binary-tree/description/
 */
public class MaximumBinaryTree {
    public static void main(String[] args) {
        int [] nums = new int[]{3,2,1,6,0,5};
        MaximumBinaryTree mbt = new MaximumBinaryTree();
        mbt.constructMaximumBinaryTree(nums);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Task{
        int startIdx;
        int endIdx;
        TreeNode root;

        public Task() {
        }

        public Task(int startIdx, int endIdx, TreeNode root) {
            this.startIdx = startIdx;
            this.endIdx = endIdx;
            this.root = root;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Task t = new Task(0, nums.length-1, new TreeNode(-1));
        List<Task> taskList = new ArrayList<>();
        taskList.add(t);
        while (taskList.size() > 0){
            handleTasks(taskList, nums);
        }
        return t.root;
    }

    private void handleTasks(List<Task> taskList, int[] nums) {
        Task t = taskList.remove(0);
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = t.startIdx; i <= t.endIdx; ++i){
            if (nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }
        }
        t.root.val = max;
        if (maxIdx > t.startIdx){
            TreeNode ln = new TreeNode(-1);
            t.root.left = ln;
            Task lt = new Task(t.startIdx, maxIdx - 1, ln);
            taskList.add(lt);
        }

        if (maxIdx < t.endIdx){
            TreeNode rn = new TreeNode(-1);
            t.root.right = rn;
            Task rt = new Task(maxIdx+1, t.endIdx, rn);
            taskList.add(rt);
        }
    }


}
