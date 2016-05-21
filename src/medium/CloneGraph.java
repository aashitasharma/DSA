package medium;

import java.util.*;

public class CloneGraph {
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		
		Map<UndirectedGraphNode, UndirectedGraphNode> visited=new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> q=new LinkedList<UndirectedGraphNode>();
		q.add(node);
		UndirectedGraphNode newnode=new UndirectedGraphNode(node.label);
		visited.put(node, newnode);
		while(!q.isEmpty()){
			UndirectedGraphNode curr=q.poll();
			for(UndirectedGraphNode child:curr.neighbors){
				if(!visited.containsKey(child)){
					q.add(child);
					UndirectedGraphNode newchild=new UndirectedGraphNode(child.label);
					visited.get(curr).neighbors.add(newchild);
					visited.put(child, newchild);
				}
				else{
					visited.get(curr).neighbors.add(visited.get(child));
				}
			}
		}
		return newnode;
    }
	
	
	
}
