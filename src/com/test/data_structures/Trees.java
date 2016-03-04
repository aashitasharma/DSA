package com.test.data_structures;

import java.util.LinkedList;

public class Trees {
    public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}

	@Override
	public String toString() {
	    return "Val=" + val;
	}
    }

    public static boolean isBalanced(TreeNode root) {
	if (root == null)
	    return false;
	else {
	    if (isLeaf(root))
		return true;
	    else {
		if (Math.abs(height(root.left) - height(root.right)) > 1)
		    return false;
		else
		    return isBalanced(root.left) & isBalanced(root.right);
	    }
	}
    }

    public static int height(TreeNode root) {
	if (root == null)
	    return 0;
	else {
	    if (isLeaf(root))
		return 1;
	    else {
		return Math.max(height(root.left) + 1, height(root.right) + 1);
	    }
	}
    }

    public static boolean isLeaf(TreeNode root) {
	if (root.left == null && root.right == null)
	    return true;
	else
	    return false;
    }

    public static boolean isPresent(TreeNode root, TreeNode p) {
	if (root != null) {
	    if (root == p)
		return true;
	    else
		return isPresent(root.left, p) || isPresent(root.right, p);
	}
	return false;
    }

    /**
     * Lowest common ancester.
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
	    TreeNode q) {
	if (root != null) {
	    if (root == p || root == q) {
		return root;
	    }
	    boolean p_onLeft = isPresent(root.left, p);
	    boolean q_onLeft = isPresent(root.left, q);
	    if (p_onLeft && q_onLeft)
		return lowestCommonAncestor(root.left, p, q);
	    else if (!p_onLeft && !q_onLeft)
		return lowestCommonAncestor(root.right, p, q);
	    else
		return root;
	}
	return root;
    }

    public static TreeNode rotate_left(TreeNode pivot, TreeNode parent) {
	parent.left = pivot.left;
	pivot.left = parent;
	return pivot;
    }

    public static TreeNode rotate_right(TreeNode pivot, TreeNode parent) {
	parent.left = pivot.right;
	pivot.right = parent;
	return pivot;
    }

    public static void preorder(TreeNode root) {
	if (root == null)
	    return;
	if (root.left == null && root.right == null) {
	    System.out.println("Leaf: " + root);
	} else {
	    System.out.println(root);
	    System.out.println("LEFT");
	    preorder(root.left);
	    System.out.println("RIGHT");
	    preorder(root.right);
	}
    }

    public static String serialize(TreeNode root) {
	if (root == null)
	    return "";
	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	StringBuilder sb = new StringBuilder();
	stack.add(root);
	while (!stack.isEmpty()) {
	    TreeNode curr = stack.removeFirst();
	    if (curr != null) {
		sb.append(curr.val + " ");
		stack.add(curr.left);
		stack.add(curr.right);
	    } else {
		sb.append("null ");
	    }
	}
	return sb.toString();
    }

    public TreeNode deserialize(String data) {
	if (data.length() == 0)
	    return null;
	int i = 1;
	String[] nodes = data.split(" ");
	TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	stack.add(root);
	while (!stack.isEmpty()) {
	    TreeNode curr = stack.removeFirst();
	    if (!nodes[i].equals("null")) {
		curr.left = new TreeNode(Integer.parseInt(nodes[i]));
		stack.add(curr.left);
	    } else
		curr.left = null;
	    i++;
	    if (!nodes[i].equals("null")) {
		curr.right = new TreeNode(Integer.parseInt(nodes[i]));
		stack.add(curr.right);
	    } else
		curr.right = null;
	    i++;
	}
	return root;
    }

    public static void swap_Nodes(TreeNode root, int k, int level, int mult,
	    int base_k) {
	if (root == null)
	    return;
	if (level + 1 == k) {
	    TreeNode temp = root.left;
	    root.left = root.right;
	    root.right = temp;
	    swap_Nodes(root.left, base_k * (++mult), level + 1, mult, base_k);
	    swap_Nodes(root.right, base_k * (mult), level + 1, mult, base_k);
	} else {
	    swap_Nodes(root.left, k, level + 1, mult, base_k);
	    swap_Nodes(root.right, k, level + 1, mult, base_k);
	}
    }

    /**
     * Find Minimum Depth of a Binary Tree <O(n)
     * 
     * @param root
     * @return
     */

    public static int minHeight(TreeNode root) {
	if (root == null)
	    return 0;
	else {
	    class Node {
		TreeNode root;
		int depth;

		Node(TreeNode r, int d) {
		    root = r;
		    depth = d;
		}
	    }
	    LinkedList<Node> q = new LinkedList<Node>();
	    q.add(new Node(root, 1));
	    while (!q.isEmpty()) {
		Node n = q.removeFirst();
		if (n.root.left == null && n.root.right == null)
		    return n.depth;
		else {
		    if (n.root.left != null) {
			q.add(new Node(n.root.left, n.depth+1));
		    }
		    if (n.root.right != null) {
			q.add(new Node(n.root.right, n.depth+1));
		    }
		}
	    }
	}
	return 0;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Trees.TreeNode root = new Trees().new TreeNode(8);

	Trees.TreeNode node1 = new Trees().new TreeNode(4);
	Trees.TreeNode node2 = new Trees().new TreeNode(11);
	root.left = node1;
	root.right = node2;
	Trees.TreeNode node3 = new Trees().new TreeNode(5);
	Trees.TreeNode node4 = new Trees().new TreeNode(3);
	node1.right = node3;
	node1.left = node4;
	Trees.TreeNode node5 = new Trees().new TreeNode(6);
	Trees.TreeNode node6 = new Trees().new TreeNode(10);
	node3.right = node5;
	node5.left = node6;
	String s = serialize(root);
	System.out.println(s);
	int k = 2;
	int level = (k == 1) ? 0 : 1;
	swap_Nodes(root, k, level, 1, k);
	k = 2;
	level = (k == 1) ? 0 : 1;
	swap_Nodes(root, k, level, 1, k);
	preorder(root);

    }

}
