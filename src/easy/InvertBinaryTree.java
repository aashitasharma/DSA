package easy;

import data_structures.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root==null|| (root.left==null && root.right==null))
            return root;
        else{
            root.left=invertTree(root.left);
            root.right=invertTree(root.right);
            TreeNode _temp=root.left;
            root.left=root.right;
            root.right=_temp;
            return root;
        }
    }
}
