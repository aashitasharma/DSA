package data_structures;
/**
 * 
 * @author Ankit
 * Used for Range Query problems, 
 * Given an array find the sum of array elements from start to end, provided array elements keeps on changing.
 * BI Trees gives both update and search finction in O(logN) time
 *
 */
public class BinaryIndexTrees {

    SegmentTrees root;
    public BinaryIndexTrees(int[] a) {
	// TODO Auto-generated co	nstructor stub
	root=new SegmentTrees(0,0,0);
	root=insert(root, 0, a.length-1, a);
    }
    
    public static SegmentTrees insert(SegmentTrees root, int start, int end, int[] a){
	if(end<start)
	    return null;
	if(start==end){
	    root.value= a[start]; 
	}
	else{
	    int mid=start+(end-start)/2;
	    if(root.left==null)
		root.left=new SegmentTrees(0,0,0);
	    root.left=insert(root.left, start, mid, a);
	    if(root.right==null)
		root.right=new SegmentTrees(0,0,0);
	    root.right=insert(root.right, mid+1, end, a);
	    root.value=root.left.value+root.right.value;
//	    root.start=start;
//	    root.end=end;
//	    return root;
	}
	root.start=start;
	root.end=end;
	return root;
    }
    
    public static int search(SegmentTrees root, int start, int end){
	if(root==null)
	    return 0;
	if(root.start>=start && root.end<=end)
	    return root.value;
	else{
	    if(end<root.start || start>root.end)
		return 0;
	    else
		return search(root.left,start, end )+search(root.right, start, end);
	}
    }
    
    public static int update(SegmentTrees root, int pos, int val){
	if(root==null) return 0;
	if(root.start==pos && root.end==pos){
	    root.value=val;
	    return val;
	}
	if(root.start>pos || root.end<pos)
	    return root.value;
	else{
	    root.value=update(root.left, pos, val)+update(root.right, pos, val);
	    return root.value;
	}
    }
    
    public void pre_tra(SegmentTrees root){
	if(root==null) return ;
	if(root.left==null && root.right==null)
	    System.out.println(root.value);
	else{
	    pre_tra(root.left);
	    pre_tra(root.right);
	    System.out.println(root.value);
	}
    }
    
  
    void update(int i, int val) {
        update(root, i, val);
    }

    public int sumRange(int i, int j) {
        return search(root, i,j);
    }
    
    public static void main(String[] args){
  	int[] a={1,3,5};
  	BinaryIndexTrees bi=new BinaryIndexTrees(a);
//  	bi.pre_tra(bi.root);
//  	System.out.println(bi.sumRange(0,2));
  	bi.update(1, 10);
//  	bi.pre_tra(bi.root);
//  	System.out.println(bi.sumRange(2,2));
  	bi.pre_tra(bi.root);
  	
      }

}

class SegmentTrees{
    int value;
    int start;
    int end;
    SegmentTrees left;
    SegmentTrees right;
    public SegmentTrees(int v, int s, int e){
	start=s;
	end=e;
	value=v;
    }
}