package data_structures;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
	     val = x;
    }

    public static void printTree(TreeNode root){
      if(root == null) {
        return;
      }
      if(root.left == null && root.right == null){
        System.out.print(root.val + " ");
        return;
      }
      TreeNode.printTree(root.left);
      System.out.print(root.val + " ");
      TreeNode.printTree(root.right);
    }
}
