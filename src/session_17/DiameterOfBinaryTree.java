package session_17;

public class DiameterOfBinaryTree {

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

    class Pair{
        int height;
        int diameter;
        public Pair(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public int diameterOfBinaryTree(TreeNode root){
        Pair ans = diameterOfBinaryTreee(root);
        return ans.diameter;
    }

    public Pair diameterOfBinaryTreee(TreeNode root){
        if(root == null){
            return new Pair(0,0);
        }
        Pair left = diameterOfBinaryTreee(root.left);
        Pair right = diameterOfBinaryTreee(root.right);
        int apniHeight = Math.max(left.height, right.height)+1;
        int apnaDia = left.height + right.diameter;
        int maxDia = Math.max(apnaDia, Math.max(left.diameter, right.diameter));
        return new Pair(apniHeight,apnaDia);
    }

}
