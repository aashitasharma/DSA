package data_structures;

import java.util.*;

public class Graph {

    int nodes;
    List<Integer>[] adjList;

    public Graph(int n) {
	nodes = n;
	adjList = new LinkedList[n];
	for (int i = 0; i < n; i++) {
	    adjList[i] = new LinkedList<Integer>();
	}
    }

    /**
     * add edge from vertc1 to vertx2
     */
    public void addEdge(int vertx1, int vertx2) {
	adjList[vertx1].add(vertx2);
    }
    
    /**
     * 
     * @param v
     * @param visited
     * @param recStack
     * @return
     */
    public boolean isCycle(int v, boolean[] visited, boolean[] recStack){
	if(visited[v]==false){
	    visited[v]=true;
	    recStack[v]=true;
	    for(Integer c:adjList[v]){
		if(visited[c]==false && isCycle(c, visited, recStack))
		    return true;
		else if(recStack[c]==true)
		    return true;
	    }
	}
	recStack[v]=false;
	return false;
    }

}