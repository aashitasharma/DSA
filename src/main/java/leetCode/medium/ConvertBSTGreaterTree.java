import java.util.*;
import data_structures.TreeNode;

public class ConvertBSTGreaterTree{

  public TreeNode convertBST(TreeNode root) {
    convertBSTHelper(root, 0);
    return root;
  }

  private int convertBSTHelper(TreeNode root, int n){
    if(root == null ) {
      return n;
    }
    if(root.left == null && root.right == null){
      root.val += n;
      return root.val;
    }
    root.val += convertBSTHelper(root.right, n);
    return convertBSTHelper(root.left, root.val);
  }
}
