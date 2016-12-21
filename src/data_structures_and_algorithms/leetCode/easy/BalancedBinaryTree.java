package data_structures_and_algorithms.leetCode.easy;

import data_structures_and_algorithms.data_structures.TreeNode;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
	if (root == null) {
	    return true;
	} else {
	    if (isLeaf(root)) {
		return true;
	    } else {
		if (Math.abs(height(root.left) - height(root.right)) > 1) {
		    return false;
		} else {
		    return isBalanced(root.left) && isBalanced(root.right);
		}
	    }
	}

    }

    public int height(TreeNode root) {
	if (root == null) {
	    return 0;
	} else {
	    if (isLeaf(root)) {
		return 1;
	    } else {
		return Math.max(height(root.left) + 1, height(root.right) + 1);
	    }
	}
    }

    public boolean isLeaf(TreeNode root) {
	if (root.left == null && root.right == null) {
	    return true;
	} else {
	    return false;
	}
    }

}
