package graph;

public class AdjacencyMatrix {
	
	private int V;	//number of vertices in the undirected graph
	private int E;	//number of edges in the undirected graph
	private int[][] adjacencyMatrix;
	
	public AdjacencyMatrix(int nodes) {
		this.V = nodes;
		this.E = 0;
		this.adjacencyMatrix = new int[nodes][nodes];
	}
	
	public void addEdge(int u, int v) {
		adjacencyMatrix[u][v] = 1;
		adjacencyMatrix[v][u] = 1;
		E++;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges " + "\n");
		for(int v=0;v<V;v++) {
			sb.append(v + ": ");
			for(int w : adjacencyMatrix[v]) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		AdjacencyMatrix graph = new AdjacencyMatrix(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);
		System.out.println("-----Adjacency Matrix representation of Graph-----");
		System.out.println(graph.toString());
	}

}
