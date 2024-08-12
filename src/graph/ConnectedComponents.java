package graph;

import java.util.LinkedList;

public class ConnectedComponents {
	
	private int V;	//number of vertices in the undirected graph
	private int E;	//number of edges in the undirected graph
	private LinkedList<Integer>[] adjList;

	public ConnectedComponents(int nodes) {
		V = nodes;
		E = 0;
		this.adjList = new LinkedList[nodes];
		for(int v=0;v<V;v++) {
			adjList[v] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		adjList[u].add(v);
		adjList[v].add(u);
		E++;
	}
	
	boolean[] visited = new boolean[V];
	int[] componentId = new int[V];
	int count = 0;
	
	public void dfscc(int start) {
		for(int v : adjList[start]) {
			if(!visited[v]) {
				dfscc(v, visited, componentId, count);
			}
		}
	}
	
	public void dfscc(int v, boolean[] visited2, int[] compId, int count2) {
		visited2[v] = true;
		compId[v] = count2;
		for(int w : adjList[v]) {
			if(!visited2[w]) {
				dfscc(v, visited2, compId, count2);
			}
		}
	}
	
	public int getCountCC() {
		return count;
	}
	
	public boolean isConnected(int x, int y) {
		return componentId[x] == componentId[y];
	}

	public static void main(String[] args) {
		int vertices = 5;
		ConnectedComponents graph = new ConnectedComponents(vertices);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);
		graph.addEdge(2, 4);
        graph.dfscc(2);
	}

}
