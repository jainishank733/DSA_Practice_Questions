package Session_16;

import java.util.Scanner;

public class BinaryTree {

    private Scanner sc = new Scanner(System.in);
    private class Node{
        int val;
        Node left;
        Node right;
    }

    private Node root;

    public BinaryTree(){
        this.root = construct(null, true);
    }

    private Node construct(Node parent, boolean isLeftChild){
        if(parent == null){
            System.out.println("Enter the data for root node!");
        }else{
            if(isLeftChild){
                System.out.println("Enter the data for left child of " + parent.val);
            }else{
                System.out.println("Enter the data for right child of " + parent.val);
            }
        }
        Node node = new Node();
        node.val = sc.nextInt();
        System.out.println("kya "+node.val+" ka left child hai");
        boolean kyaLeftHai = sc.nextBoolean();
        if(kyaLeftHai){
            node.left = construct(node, true);
        }
        System.out.println("kya "+node.val+" ka right child hai");
        boolean kyaRightHai = sc.nextBoolean();
        if(kyaRightHai){
            node.right = construct(node, false);
        }
        return node;
    }

    public void display(){
        display(this.root);
    }

    private void display(Node root){
        if(root == null){
            return;
        }
        String str = "";
        if(root.left!=null){
            str+=root.left.val;
        }else{
            str+="_";
        }
        str+="->"+root.val+"<-";
        if(root.right!=null){
            str+=root.right.val;
        }else{
            str+="_";
        }
        System.out.println(str);
        display(root.left);
        display(root.right);
    }

    public int maxHeight(){
        return maxHeight(this.root);
    }

    private int maxHeight(Node root){
        if(root == null){
            return 0;
        }
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        int meriHeight = Math.max(left, right) + 1;
        return meriHeight;
    }

    public void preOrder(){
        preOrder(this.root);
    }

    private void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(){
        preOrder(this.root);
    }

    private void postOrder(Node root){
        if(root == null){
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.val);
    }

    public void inOrder(){
        preOrder(this.root);
    }

    private void inOrder(Node root){
        if(root == null){
            return;
        }
        preOrder(root.left);
        System.out.println(root.val);
        preOrder(root.right);
    }

    public boolean hasPathSum(Node root, int targetSum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && (targetSum- root.val)==0){
            return true;
        }
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);
        return left || right;
    }

    /*
    public int sumRootToLeaf(){
        return sumRootToLeaf(this.root,0);
    }

    private int sumRootToLeaf(Node root, int sum){
        if(root == null){
            return sum;
        }
        if(root.left==null && root.right==null){
            return sum*10+root.val;
        }
        if(root.right == null || root.left == null){
            return sum*10+0;
        }
        int left = sumRootToLeaf(root.left, sum*10+root.val);
        int right = sumRootToLeaf(root.right, sum*10+root.val);
        return left+right;
    }
    */


}

