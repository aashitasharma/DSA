package company_interviews.Palantir;

import data_structures.TreeNode;

/*
 * Find the successor in a binary search tree: 
 * TreeNode findSuccessor(TreeNode root, int t)
 * in-order successor node
 */

/* O(n) time O(1) space */
class FindSuccessor {
    private static void inorderSuccessor(TreeNode root, int t) {
	data_structures.TreeNode cur = root;
	int successor = -1;

	// int minGreaterNode = Integer.MAX_VALUE;

	while (cur != null) {
	    if (cur.val == t && cur.right != null) {
		successor = cur.right.val;
	    }

	    // if (cur.val > t) {
	    // minGreaterNode = Math.min(minGreaterNode, cur.val);
	    // }

	    if (cur.left != null) {
		TreeNode pre = cur.left;

		while (pre.right != null && pre.right != cur) {
		    pre = pre.right;
		}

		if (pre.right == null) { // set right to successor
		    pre.right = cur;
		    cur = cur.left;
		} else { // visit and revert the change
		    pre.right = null;
		    cur = cur.right;
		}

	    } else { // visit and move to successor
		cur = cur.right;
	    }
	}

	System.out.print(successor);

	/*
	 * if not exist, return the least greater node if still not exist such
	 * node return null
	 */
	/*
	 * if (minGreaterNode == Integer.MAX_VALUE) { System.out.print("null");
	 * }else{ System.out.print(minGreaterNode); }
	 */
    }
}
