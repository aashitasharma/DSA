package data_structures_and_algorithms.data_structures;
//BST

import java.util.*;

enum traversalModes{
	inOrder,
	preOrder,
	postOrder,
	BFS
}

class InvalidModeException extends Exception{
}

class Node<X extends Integer>{
                private X data;
                Node<X> leftNode;
                Node<X> rightNode;
                public X getData(){
                        return this.data;
                }
                public void setData(X data){
                        this.data=data;
                }
                public Node(X data){
                        this.data=data;
                }
		public Node(){}
       }


class BTree<X extends Integer>{
	protected Node<X> root;
	public BTree(X data){
		this.root=new Node<X>(data);
	}
	public BTree(){
		this.root=new Node<X>();
	}

	public void toString(traversalModes m) throws InvalidModeException{
		if(m==traversalModes.inOrder)
			this.inOrder();
		else if(m==traversalModes.preOrder)
			this.preOrder();
		else if(m==traversalModes.postOrder)	
			this.postOrder();
		else throw new InvalidModeException();
	}
	
	//insert into B trees of minimal height-complete B trees
		

	//Given a binary search tree, design an algorithm which creates a linked list of all the
	//nodes at each depth
	public List<List<Node<X>>> listOfList(){
		Queue<Node<X>> pq=new LinkedList<Node<X>>();
		List<List<Node<X>>> mainList=new ArrayList<List<Node<X>>>();
		pq.add(root);
		while(!pq.isEmpty()){
			List<Node<X>> tempNodes=new ArrayList<Node<X>>();
			while(!pq.isEmpty()){
				tempNodes.add(pq.poll());
			}
			for(Node<X>n:tempNodes){
				if(n.leftNode!=null) pq.add(n.leftNode);
				if(n.rightNode!=null) pq.add(n.rightNode);
			}
			mainList.add(tempNodes);
			//tempNodes.clear();						
		}
		return mainList;	
	}

	protected void inOrder(Node<X> root){
		if(root!=null){
                        System.out.println(root.getData());
                        if(root.leftNode!=null) inOrder(root.leftNode);
                        if(root.rightNode!=null) inOrder(root.rightNode);
                }
	}
	
	public void inOrder(){
		inOrder(this.root);
	}

	protected void preOrder(Node<X> root){
		if(root!=null){
                        if(root.leftNode!=null) preOrder(root.leftNode);
                        System.out.println(root.getData());
			if(root.rightNode!=null) preOrder(root.rightNode);
                }
	}

	public void preOrder(){
		preOrder(this.root);
	}

	protected void postOrder(Node<X> root){
		if(root!=null){
                        if(root.leftNode!=null) postOrder(root.leftNode);
                        if(root.rightNode!=null) postOrder(root.rightNode);
			System.out.println(root.getData());
                }
	}

	public void postOrder(){
		postOrder(this.root);
	}

	public void BFS(){
                Queue<Node<X>> pq=new LinkedList<Node<X>>();
                pq.add(this.root);
                while(!pq.isEmpty()){
                        Node<X> headNode=pq.remove();
                        if(headNode.leftNode!=null) pq.add(headNode.leftNode);
                        if(headNode.rightNode!=null) pq.add(headNode.rightNode);
                        System.out.println(headNode.getData());
                 }
        }		
}

class BSTree<X extends Integer> extends BTree<X>{
	
	public BSTree(){
		this.root=new Node<X>();
	}
	
	public BSTree(X data){
		this.root=new Node<X>(data);
	}	

	private void insert(Node<X> root,X data){
		Node<X> newNode=new Node<X>(data);
		
		if(root!=null){
			if(root.leftNode==null && root.rightNode==null){
				if(root.getData() < data) root.rightNode=newNode;
				else  root.leftNode=newNode;
			}
			else{
				if(root.getData()< data){
					if(root.rightNode==null) root.rightNode=newNode;
					else insert(root.rightNode,data);
				}
				else if(root.leftNode==null) root.leftNode=newNode;
				else insert(root.leftNode,data);
			}
		}	
	}

	public void insert(X data){
		insert(this.root, data);
	}	
	
	private boolean search(Node<X> root, X data){
		if(root.getData()==data) return true;
                else{
                        if(root.getData()>data){
                                if(root.leftNode!=null) return search(root.leftNode, data);
                                else return false;
                        }
                        else{
                                if(root.rightNode!=null) return search(root.rightNode,data);
                                else return false;
                        }
                }
	}
	
	public boolean search(X data){
		return search(this.root, data);
	}

	public Node<X> inOrderSuccessor(Node<X> givenNode){
		List<Node<X>> list=new ArrayList<Node<X>>();
		Deque<Node<X>> pq=new LinkedList<Node<X>>();
		pq.add(this.root);
		while(!pq.isEmpty()){
			list.add(pq.poll());
			if(this.root.rightNode!=null) pq.addFirst(this.root.rightNode);		
			if(this.root.leftNode!=null) pq.addFirst(this.root.leftNode);
			System.out.println("==>"+pq.isEmpty());
		}
		//System.out.println("size="+list.size());
		for(Node<X> n:list){
			if(n.getData().equals(givenNode.getData())) return list.get(list.indexOf(n)+1);
		}
		return null;	
	}
}	

public class TreeAndGraphs{
	public static void main(String[] args){
		System.out.println("Trees");
		
		BSTree<Integer> ti=new BSTree<Integer>(10);
			
		ti.insert(20);
		ti.insert(5);
		ti.insert(2);
		ti.insert(6);
		ti.insert(21);
		ti.insert(19);
		try{
			ti.toString(traversalModes.inOrder);
			System.out.println("====Preorder====");
			ti.toString(traversalModes.preOrder);
			System.out.println("======PostOrder====");
			ti.toString(traversalModes.postOrder);
		}
		catch(InvalidModeException e){
			System.out.println("Invalid Traversal");
		}
		System.out.println("====BFS====");
		ti.BFS();
		System.out.println("==========");
		List<List<Node<Integer>>> list= ti.listOfList();
		for(List<Node<Integer>> l:list){
			for(Node<Integer> n:l)
				System.out.print(n.getData()+" " );
			System.out.println();
		}
		System.out.println("==========");
		System.out.println(ti.search(11));
		System.out.println("==========");
		System.out.println(ti.inOrderSuccessor(new Node<Integer>(10)).getData());		
	}
}
