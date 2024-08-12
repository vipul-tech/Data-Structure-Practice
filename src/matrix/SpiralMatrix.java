package matrix;

public class SpiralMatrix {
	
	public void printSpiralMatrix(int[][] matrix, int row, int column) {
		int i, j=0, k=0;
		while(j<row && k<column) {
			for(i=k;i<column;i++) {
				System.out.print(matrix[j][i] + " ");
			}
			j++;
			for(i=j;i<row;i++) {
				System.out.print(matrix[i][column-1] + " ");
			}
			column--;
			if(j<row) {
				for(i=column-1;i>=k;i--) {
					System.out.print(matrix[row-1][i] + " ");
				}
				row--;
			}
			if(k<column) {
				for(i=row-1;i>=j;i--) {
					System.out.print(matrix[i][k] + " ");
				}
				k++;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{10, 20, 30, 40, 55},
				{15, 25, 35, 45, 42},
				{27, 29, 37, 48, 23},
				{32, 33, 39, 51, 47},
				{29, 61, 83, 78, 96}
		};
		
		SpiralMatrix sm = new SpiralMatrix();
		sm.printSpiralMatrix(matrix, 5, 5);
	}

}
