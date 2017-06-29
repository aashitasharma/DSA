import data_structures.TreeNode;

public class LargestValueInLevel {

  public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        levelOrderHelper(root, list, 0);
        return list;
    }

    private void levelOrderHelper(TreeNode root, List<Integer> largestValueList, int level) {
    if(root == null) {
      return;
    }
    if(root.left != null || root.right!=null) {
      if(level < largestValueList.size()) {
          if(largestValueList.get(level) < root.val){
            largestValueList.set(level, root.val);
          }
      }else{
        largestValueList.add(level, root.val);
      }
      levelOrderHelper(root.left, largestValueList, level + 1);
      levelOrderHelper(root.right, largestValueList, level + 1);
    }else{
      if(level < largestValueList.size()) {
          if(largestValueList.get(level) < root.val){
            largestValueList.set(level, root.val);
          }
      }else{
        largestValueList.add(level, root.val);
      }
    }
    }
}
