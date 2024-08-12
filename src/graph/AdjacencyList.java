package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyList {
	
	private int V;	//number of vertices in the undirected graph
	private int E;	//number of edges in the undirected graph
	private LinkedList<Integer>[] adjList;

	public AdjacencyList(int nodes) {
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
	
	public void bfs(int s) {
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.offer(s);
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			System.out.print(u + " ");
			for(int v : adjList[u]) {
				if(!visited[v]) {
					visited[v] = true;
					queue.offer(v);
				}
			}
		}
	}
	
	public void dfs(int s) {
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(s);
		
		while(!stack.isEmpty()) {
			int u = stack.pop();
			if(!visited[u]) {
				visited[u] = true;
				System.out.print(u + " ");
				for(int v : adjList[u]) {
					if(!visited[v]) {
						stack.push(v);
					}
				}
			}
		}
	}
	
	public void recursiveDfs(int startVertex) {
		boolean[] visited = new boolean[V];
		recursiveDfs(startVertex, visited);
//		for(int v=0;v<V;v++) {
//			if(!visited[v]) {
//				recursiveDfs(v, visited);
//			}
//		}
	}
	
	public void recursiveDfs(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int w : adjList[v]) {
			if(!visited[w]) {
				recursiveDfs(w, visited);
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges " + "\n");
		for(int v=0;v<V;v++) {
			sb.append(v + ": ");
			for(int w : adjList[v]) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		AdjacencyList graph = new AdjacencyList(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);
		graph.addEdge(2, 4);
		System.out.println("-----Adjacency List representation of Graph-----");
		System.out.println(graph.toString());
		
		System.out.print("BFS traversal of graph : ");
		graph.bfs(0);
		
		System.out.println();
		System.out.print("DFS traversal of graph : ");
		graph.dfs(0);
		
		System.out.println();
		System.out.print("Recursive DFS traversal of graph : ");
		graph.recursiveDfs(2);
	}

}
