package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenerateBinaryNumber {
	
	public static String[] generateBinary(int n) {
		String[] result = new String[n];
		Queue<String> queue = new LinkedList<>();
		queue.offer("1");
		for(int i=0;i<n;i++) {
			result[i] = queue.poll();
			String n1 = result[i] + "0";
			String n2 = result[i] + "1";
			queue.offer(n1);
			queue.offer(n2);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.print("Enter n to generate binary numbers from 0 to n : ");
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			String[] result = generateBinary(n);
			for(int i=0;i<result.length;i++) {
				System.out.println((i+1) + " : " + result[i]);
			}
		}
	}

}
