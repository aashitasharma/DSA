import data_structures.TreeNode;

public class AddRowInTree {
   public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode new_node = new TreeNode(v);
            new_node.left = root;
            return new_node;
        }
        addOneRowHelper(root, null, v, d, 1);
        return root;
    }

    public void addOneRowHelper(TreeNode root, TreeNode parent, int v, int d, int level) {
        if(level != d) {
          if(root == null){
            return;
          }
          addOneRowHelper(root.left, root, v, d, level+1);
          addOneRowHelper(root.right, root, v, d, level+1);
        }else{
          TreeNode new_node = new TreeNode(v);
          if(root == null){
            if(parent.left == null) {
              parent.left = new_node;
            }
            else if(parent.right == null) {
              parent.right = new_node;
            }
          }else{
            if(parent.left == root) {
              parent.left = new_node;
              new_node.left = root;
            }
            if(parent.right == root) {
              parent.right = new_node;
              new_node.right = root;
            }
          }
          return;
        }
  }

}
