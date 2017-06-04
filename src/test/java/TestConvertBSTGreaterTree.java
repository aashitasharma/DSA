import org.junit.Test;
import org.junit.Before;
import java.util.*;
import data_structures.TreeNode;

public class TestConvertBSTGreaterTree{

  @Test
  public void test1(){
    System.out.println("test1");
    ConvertBSTGreaterTree greaterTree = new ConvertBSTGreaterTree();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(13);
    greaterTree.convertBST(root);
    TreeNode.printTree(root);
  }

  @Test
  public void test2(){
    System.out.println("test2");
    ConvertBSTGreaterTree greaterTree = new ConvertBSTGreaterTree();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    greaterTree.convertBST(root);
    TreeNode.printTree(root);
  }

  @Test
  public void test3(){
    System.out.println("test3");
    ConvertBSTGreaterTree greaterTree = new ConvertBSTGreaterTree();
    TreeNode root = new TreeNode(5);
    root.right = new TreeNode(13);
    greaterTree.convertBST(root);
    TreeNode.printTree(root);
  }

  @Test
  public void test4(){
    System.out.println("test4");
    ConvertBSTGreaterTree greaterTree = new ConvertBSTGreaterTree();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(13);
    root.left.left = new TreeNode(1);
    root.right.right = new TreeNode(18);
    root.right.left = new TreeNode(9);
    greaterTree.convertBST(root);
    TreeNode.printTree(root);
  }

  @Test
  public void test5(){
    System.out.println("test5");
    ConvertBSTGreaterTree greaterTree = new ConvertBSTGreaterTree();
    TreeNode root = new TreeNode(5);
    greaterTree.convertBST(root);
    TreeNode.printTree(root);
  }

  @Test
  public void test6(){
    System.out.println("test6");
    ConvertBSTGreaterTree greaterTree = new ConvertBSTGreaterTree();
    TreeNode root = null;
    greaterTree.convertBST(root);
    TreeNode.printTree(root);
  }

}
