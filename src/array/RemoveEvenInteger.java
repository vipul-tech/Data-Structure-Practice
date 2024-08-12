package array;

public class RemoveEvenInteger {
	
	public static void main(String[] args) {
		int arr[] = {10,23,13,28,49,60,39};
		int result[] = removeEven(arr);
		printArray(result);
	}
	
	public static void printArray(int[] array) {
		int n = array.length;
		for(int i=0; i<n;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] removeEven(int[] arr) {
		
		int n = arr.length;
		int oddCount = 0;
		
		for(int i=0;i<n;i++) {
			if(arr[i]%2==1)
				oddCount++;
		}
		
		int result[] = new int[oddCount];
		int count = 0;
		
		for(int i=0;i<n;i++) {
			if(arr[i]%2==1) {
				result[count]=arr[i];
				count++;
			}
		}
		return result;
		
	}

}
