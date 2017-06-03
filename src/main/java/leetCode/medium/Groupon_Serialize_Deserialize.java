package leetCode.medium;
import java.util.*;

import data_structures.TreeNode;
public class Groupon_Serialize_Deserialize {

    public String serialize(TreeNode root) {
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

}
