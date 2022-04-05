package session_17;

public class BalancedBinaryTree {

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

    private int height(TreeNode root) {

        if (root == null) {

            return 0;
        }
        int leftSubTreeKiHeight = height(root.left);
        int rightSubTreeKiHeight = height(root.right);

        int max = Math.max(leftSubTreeKiHeight, rightSubTreeKiHeight);

        return max + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        int diff = Math.abs(left - right);
        if(diff<=1){
            boolean leftNode = isBalanced(root.left);
            boolean rightNode = isBalanced(root.right);
            return leftNode && rightNode;
        }else{
            return false;
        }
   }

    public static void main(String[] args) {

    }

}