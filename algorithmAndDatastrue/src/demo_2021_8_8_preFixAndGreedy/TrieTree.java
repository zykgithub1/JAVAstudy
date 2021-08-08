package demo_2021_8_8_preFixAndGreedy;

public class TrieTree {
	public static class TrieNode {
		public int pass;
		public int end;
		public TrieNode[] nexts;

		public TrieNode() {
			pass = 0;
			end = 0;
			nexts = new TrieNode[26];
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			char[] charArr = word.toCharArray();
			int n = word.length();
			TrieNode cur = root;
			cur.pass++;
			int index = 0;
			for (int i = 0; i < n; i++) {
				index = charArr[i] - 'a';
				if (cur.nexts[index] == null) {
					cur.nexts[index] = new TrieNode();
				}
				cur = cur.nexts[index];
				cur.pass++;
			}
			cur.end++;
		}

		public void delete(String word) {
			if (search(word) != 0) {
				char[] chs = word.toCharArray();
				int index = 0;
				TrieNode cur = root;
				cur.pass--;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					if (--cur.nexts[index].pass == 0) {
						cur.nexts[index] = null;
						return;
					}
					cur = cur.nexts[index];
				}
				cur.end--;
			}

		}

		public int search(String word) {
			char[] chs = word.toCharArray();
			int index = 0;
			TrieNode cur = root;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (cur.nexts[index] == null) {
					return 0;
				}
				cur = cur.nexts[index];
			}
			return cur.end;
		}

		// return number of starting with the word in all words
		public int prefixNumber(String word) {
			char[] chs = word.toCharArray();
			int index = 0;
			TrieNode cur = root;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (cur.nexts[index] == null) {
					return 0;
				}
				cur = cur.nexts[index];
			}
			return cur.pass;
		}

	}
}
