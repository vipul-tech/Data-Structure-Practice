package graph;

public class NumberOfIsland {
	
	public static void printGrid(char[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int numOfIslands(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int islandsCount = 0;
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j] == '1' && !visited[i][j]) {
					dfs(grid, i, j, visited);
					islandsCount++;
				}
			}
		}
		return islandsCount;
	}

	private static void dfs(char[][] grid, int row, int col, boolean[][] visited) {
		if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || 
				visited[row][col] || grid[row][col]=='0') {
			return;
		}
		visited[row][col] = true;
		dfs(grid, row, col-1, visited);
		dfs(grid, row-1, col, visited);
		dfs(grid, row, col+1, visited);
		dfs(grid, row+1, col, visited);
	}

	public static void main(String[] args) {
		char[][] grid = {
				{'1', '1', '0', '1'},
				{'1', '0', '0', '1'},
				{'0', '0', '1', '0'},
				{'0', '0', '0', '1'}
		};
		
		printGrid(grid);
		int totalIsland = numOfIslands(grid);
		System.out.println("Total island in above grid : " + totalIsland);
	}

}
