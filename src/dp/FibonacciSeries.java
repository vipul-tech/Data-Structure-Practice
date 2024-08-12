package dp;

public class FibonacciSeries {
	
	public int fibonacciUsingRecusion(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		int left = fibonacciUsingRecusion(n-1);
		int right = fibonacciUsingRecusion(n-2);
		return left+right;
	}
	
	public int fibonacciUsingDpBottomUp(int n) {
		int[] table = new int[n+1];
		table[0]=0;
		table[1]=1;
		
		for(int i=2;i<=n;i++) {
			table[i] = table[i-1] + table[i-2];
		}
		return table[n];
	}
	
	public int fibonacciUsingDpTopDown(int memo[], int n) {
		if(memo[n]==0) {
			if(n<2) {
				memo[n] = n;
			}
			else {
				int left = fibonacciUsingDpTopDown(memo, n-1);
				int right = fibonacciUsingDpTopDown(memo, n-2);
				memo[n] = left+right;
			}
		}
		return memo[n];
	}

	public static void main(String[] args) {
		FibonacciSeries fibonacciSeries = new FibonacciSeries();
		int n = 6;
		System.out.println("Using recursion");
		System.out.println(n + "th fibonacci series number is : " + fibonacciSeries.fibonacciUsingRecusion(n));
		System.out.println("Using Dp Bottom Up Approach");
		System.out.println(n + "th fibonacci series number is : " + fibonacciSeries.fibonacciUsingDpBottomUp(n));
		System.out.println("Using Dp Top Down Approach");
		System.out.println(n + "th fibonacci series number is : " + fibonacciSeries.fibonacciUsingDpTopDown(new int[n+1], n));
		
	}

}
