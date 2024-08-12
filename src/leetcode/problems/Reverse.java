package leetcode.problems;

public class Reverse {
	
	public long reverseNumber(int number) {
		boolean isNegative = number<0;
		if(isNegative) {
			number = number * -1;
		}
		int lastDigit = 1;
		long reversedNumber = 0;
		while(number>0) {
			lastDigit = number % 10;
			reversedNumber = reversedNumber * 10 + lastDigit;
			number = number / 10;
		}
		
		return isNegative?reversedNumber*-1:reversedNumber;
	}

	public static void main(String[] args) {
		Reverse reverse = new Reverse();
		int number = -12345;
		long reversedNumber = reverse.reverseNumber(number);
		System.out.println("Reverse of " + number + " : " + reversedNumber);
	}

}
