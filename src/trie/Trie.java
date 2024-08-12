package trie;

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	private class TrieNode {
		private TrieNode[] children;
		private boolean isWordEnd;
		
		public TrieNode() {
			this.children = new TrieNode[26];	//storing english words
			this.isWordEnd = false;
		}
	}
	
	public void insert(String word) {
		if(word==null || word.isEmpty())
			throw new IllegalArgumentException("Invalid input!!!");
		
		word = word.toLowerCase();
		
		TrieNode current = root;
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if(current.children[index]==null) {
				TrieNode node = new TrieNode();
				current.children[index] = node;
				current = node;
			}else {
				current = current.children[index];
			}
		}
		current.isWordEnd = true;
	}
	
	public boolean search(String word) {
		// Initialize the curr pointer with the root node
	    TrieNode current = root;
	    word = word.toLowerCase();
	    // Iterate across the length of the string
	    for (char c : word.toCharArray()) {

	        // Check if the node exists for the
	        // current character in the Trie
	        if (current.children[c - 'a'] == null)
	            return false;

	        // Move the curr pointer to the
	        // already existing node for the
	        // current character
	        current = current.children[c - 'a'];
	    }

	    // Return true if the word exists
	    // and is marked as ending
	    return current.isWordEnd;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("cat");
		trie.insert("son");
		trie.insert("cab");
		trie.insert("so");
		System.out.println("Inserted successfully!!");
		
		String word1 = "Sun";
		System.out.println(word1 + " is present ?" + trie.search(word1));
		
		String word2 = "SON";
		System.out.println(word2 + " is present ?" + trie.search(word2));
		
		String word3 = "ANT";
		System.out.println(word3 + " is present ?" + trie.search(word3));
		
		String word4 = "SONE";
		System.out.println(word4 + " is present ?" + trie.search(word4));
		
		String word5 = "SO";
		System.out.println(word5 + " is present ?" + trie.search(word5));
		
	}

}
