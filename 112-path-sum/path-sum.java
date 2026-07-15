class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if(root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        int remaining_sum = targetSum - root.val;
        return hasPathSum(root.left, remaining_sum) || hasPathSum(root.right, remaining_sum);
    }
}