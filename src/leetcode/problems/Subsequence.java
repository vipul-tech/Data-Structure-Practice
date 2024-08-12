package leetcode.problems;

public class Subsequence {
	
	public boolean isSubsequence(String str, String seq) {
		int i=0;	//traverse str
		int j=0;	//traverse seq
		while(i<str.length() && j<seq.length()) {
			if(str.charAt(i)==seq.charAt(j)) {
				j++;
			}
			i++;
		}
		return j==seq.length();
	}

	public static void main(String[] args) {
		Subsequence subsequence = new Subsequence();
		System.out.println(subsequence.isSubsequence("abcde", "ace"));
		System.out.println(subsequence.isSubsequence("abcde", "aec"));
	}

}
