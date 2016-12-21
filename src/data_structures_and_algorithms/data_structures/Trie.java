package data_structures_and_algorithms.data_structures;

/**
 * original trie structure with no enhancements;
 * 
 * @author Ankit
 *
 */
public class Trie {

    TrieNode root;

    public Trie() {
	root = new TrieNode();
    }

    public static void main(String args[]) {
	// Input keys (use only 'a' through 'z' and lower case)
	// String[] keys = { "the", "a", "there", "answer", "any", "by", "bye",
	// "their" };
	String[] keys = { "hack", "hackerrank" };
	Trie t = new Trie();
	// Construct trie
	for (int i = 0; i < keys.length; i++) {
	    t.insert(keys[i]);
	}

	System.out.println("hac " + t.startsWith("hac"));
	System.out.println("hack " + t.search("hack"));
	System.out.println(t.find("hac"));

    }

    public void insert(String word) {
	TrieNode temp = root;
	for (int i = 0; i < word.length(); i++) {
	    char c = word.charAt(i);
	    if (temp.children[c - 'a'] == null)
		temp.children[c - 'a'] = new TrieNode();
	    else
		temp.children[c - 'a'].count++;
	    temp = temp.children[c - 'a'];
	}
	temp.children[26] = new TrieNode();
    }

    public boolean search(String key) {
	boolean res = true;
	TrieNode temp = root;
	for (int i = 0; i < key.length(); i++) {
	    char c = key.charAt(i);
	    if (temp.children[c - 'a'] == null) {
		res = false;
		break;
	    }
	    temp = temp.children[c - 'a'];
	}
	return res && (temp.children[26] != null);
    }

    public boolean startsWith(String key) {
	boolean res = true;
	TrieNode temp = root;
	for (int i = 0; i < key.length(); i++) {
	    char c = key.charAt(i);
	    if (temp.children[c - 'a'] == null) {
		res = false;
		break;
	    }
	    temp = temp.children[c - 'a'];
	}
	return res;
    }

    public int find(String w) {
	int count = 0;
	boolean res = true;
	TrieNode temp = root;
	for (int i = 0; i < w.length(); i++) {
	    char c = w.charAt(i);
	    if (temp.children[c - 'a'] == null) {
		// res = false;
		break;
	    } else {
		count = temp.children[c - 'a'].count;
		temp = temp.children[c - 'a'];
	    }

	}
	return count;
    }

}

class TrieNode {
    TrieNode[] children;
    int count;

    public TrieNode() {
	children = new TrieNode[27];
	count = 1;
    }
}