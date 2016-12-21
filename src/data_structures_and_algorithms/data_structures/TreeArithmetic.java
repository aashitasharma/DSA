package data_structures_and_algorithms.data_structures;

class BNode{
	public double eval(){return 0;};
}


class Binop extends BNode{

	protected BNode lNode;
	protected BNode rNode;
	public Binop(BNode l, BNode r){
		lNode=l;
		rNode=r;
	}
	
}
 class Plus extends Binop {
    public Plus(BNode l, BNode r) {
        super(l, r);
    }
    public double eval() {
        return lNode.eval() + rNode.eval();
    }
    @Override
    public String toString(){
    	return "(" + lNode.eval()+ "+" + rNode.eval() +")="+eval();
    }
}

 class Minus extends Binop {
	    public Minus(BNode l, BNode r) {
	        super(l, r);
	    }
	    public double eval() {
	        return lNode.eval() - rNode.eval();
	    }
	    @Override
	    public String toString(){
	    	return "(" + lNode.eval()+ "-" + rNode.eval() +")="+eval();
	    }
	}

 class Mult extends Binop {
	    public Mult(BNode l, BNode r) {
	        super(l, r);
	    }
	    public double eval() {
	        return lNode.eval() + rNode.eval();
	    }
	    @Override
	    public String toString(){
	    	return "(" + lNode.eval()+ "*" + rNode.eval() +")="+eval();
	    }
	}

 class Div extends Binop {
	    public Div(BNode l, BNode r) {
	        super(l, r);
	    }
	    public double eval() {
	        return lNode.eval() + rNode.eval();
	    }
	    @Override
	    public String toString(){
	    	return "(" + lNode.eval()+ "/" + rNode.eval() +")="+eval();
	    }
	}


class Const extends BNode {
    private double value;
    public Const(double d) { value = d; }
    public double eval() { return value; }
}

public class TreeArithmetic {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  
	        BNode n1 = new Const(1.1);
	        BNode n2 = new Const(2.2);
	        BNode n3 = new Minus(n1, n2);
	        System.out.println(""+ n3);
	        BNode n4 = new Const(3.3);
	        BNode n5 = new Plus(n3, n4);
	        System.out.println(""+ n5);
	}
}
