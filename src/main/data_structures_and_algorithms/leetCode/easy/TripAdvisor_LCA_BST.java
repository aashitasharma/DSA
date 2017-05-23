package data_structures_and_algorithms.leetCode.easy;

import data_structures_and_algorithms.data_structures.TreeNode;

public class TripAdvisor_LCA_BST {

    public boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDescendant(TreeNode parent, TreeNode child) {
        if (parent != null) {
            if (parent.val == child.val) {
                return true;
            } else if (parent.val > child.val) {
                return isDescendant(parent.left, child);
            } else {
                return isDescendant(parent.right, child);
            }
        } else {
            return false;
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null && p!=null && q!=null) {
            if (!isLeaf(root)) {
                TreeNode temp1=lowestCommonAncestor(root.left, p, q);
                if(temp1!=null)
                    return temp1;
                temp1=lowestCommonAncestor(root.right, p, q);
                if(temp1!=null)
                    return temp1;
                if (isDescendant(root, q) && isDescendant(root, p)) {
                    return root;
                }
            }
        }
        return null;
    }

}
