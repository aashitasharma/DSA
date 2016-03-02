package medium;

import DataStructures.TreeNode;

public class Groupon_Validate_BST {

    public boolean isValidBST(TreeNode root) {
	return isValidUtil(root, null, null);
    }

    public boolean isValidUtil(TreeNode root, Integer max, Integer min) {
	if (root == null)
	    return true;
	if (root.left == null && root.right == null) {
	    // System.out.println("max="+max+" min="+min);
	    if (max != null && min == null)
		return (root.val < max);
	    if (min != null && max == null)
		return (root.val > min);
	    if (min != null && max != null)
		return (root.val < max) && (root.val > min);
	} else {
	    return (min == null || root.val > min)
		    && (max == null || root.val < max)
		    && isValidUtil(root.left, root.val, min)
		    && isValidUtil(root.right, max, root.val);
	}
	return true;

    }

}
