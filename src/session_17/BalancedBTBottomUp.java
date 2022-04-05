package session_17;

public class BalancedBTBottomUp {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Pair {
        int height;
        boolean isBalanced;

        public Pair(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalanced(TreeNode root){
        Pair ans = isBalance(root);
        return ans.isBalanced;
    }

    public Pair isBalance(TreeNode root){
        if(root == null){
            return new Pair(0, true);
        }
        Pair left = isBalance(root.left);
        Pair right = isBalance(root.right);
        int meriHeight = Math.max(left.height, right.height)+1;
        int diff = Math.abs(left.height-right.height);
        boolean kyaBalanceHai = diff<=1 && left.isBalanced && right.isBalanced;
        return new Pair(meriHeight, kyaBalanceHai);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}