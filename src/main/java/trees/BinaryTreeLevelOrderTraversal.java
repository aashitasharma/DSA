import data_structures.TreeNode;

public class BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {

  }

  private void levelOrderHelper(TreeNode root, List<List<Integer>> mainList, List<Integer>subList, int level) {
    if(root == null) {
      return;
    }
    subList.add(root.val);
    mainList.add(subList, l);
    if(root.left != null || root.right!=null) {
      if(level + 1 >= mainList.size()) {
        List<Integer> newSubList = new List<Integr>();
        levelOrderHelper(root.left, mainList, newSubList, level + 1);
        levelOrderHelper(root.right, mainList, newSubList, level + 1);
      }else {
        levelOrderHelper(root.left, mainList, mainList.get(level + 1), level + 1);
        levelOrderHelper(root.right, mainList, mainList.get(level + 1), level + 1);
      }
    }
    return;
  }
}
