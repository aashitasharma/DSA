package leetCode.medium;

import data_structures.TreeNode;

public class TripAdvisor_LCA_BT {

    public boolean isPresent(TreeNode root, TreeNode p){
        if(root!=null){
            if(root==p)
                return true;
            else
                return isPresent(root.left, p) || isPresent(root.right, p);
        }
        return false;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root!=null){
        	if(root==p || root==q){
        		return root;
        	}
            boolean p_onLeft=isPresent(root.left, p);
            boolean q_onLeft=isPresent(root.left, q);
            if(p_onLeft && q_onLeft)
                return lowestCommonAncestor(root.left, p, q);
            else if(!p_onLeft && !q_onLeft) 
                return lowestCommonAncestor(root.right, p, q);
            else
                return root;    
        }
        return root;
    }

}
