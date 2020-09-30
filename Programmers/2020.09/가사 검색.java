import java.util.HashMap;
import java.util.Map;
public class Main {
	private static Map<String, Integer> cache = new HashMap<>();

	public static void main(String args[]){
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		int[] arr = solution(words, queries);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}


	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];

		Trie trie = makeTrie(words, false);
		Trie reversTrie = makeTrie(words, true);

		for (int i = 0; i < queries.length; i++) {
			if (cache.containsKey(queries[i])) {
				answer[i] = cache.get(queries[i]);
				continue;
			}

			int matchCount = 0;
			if (isMaterQuery(queries[i])) {
				matchCount = trie.getCount(queries[i].length() + "?");
			} else {
				if (queries[i].charAt(0) == '?') {
					matchCount = reversTrie.getCount(makeWordWithLength(queries[i], true));
				} else {
					matchCount = trie.getCount(makeWordWithLength(queries[i], false));
				}
			}
			answer[i] = matchCount;
			cache.put(queries[i], matchCount);
		}

		return answer;
	}

	public static Trie makeTrie(String[] words, Boolean isReversed) {
		Trie trie = new Trie();
		for (String word : words) {
			String wordWithLength = makeWordWithLength(word, isReversed);
			trie.insert(wordWithLength);
		}
		trie.setLeftNodeCount(trie.getRootNode());
		return trie;
	}

	private static String makeWordWithLength(String word, Boolean isReversed) {
		StringBuilder builder = new StringBuilder(word);
		if (isReversed) {
			builder.reverse();
		}
		return builder.insert(0, word.length()).toString();
	}

	private static boolean isMaterQuery(String query) {
		return query.charAt(0) == '?' & query.charAt(query.length() - 1) == '?';
	}
}

	class Trie {
		private TrieNode rootNode;

		public Trie() {
			this.rootNode = new TrieNode();
		}

		void insert(String word) {
			TrieNode thisNode = this.rootNode;
			for (int i = 0; i < word.length(); i++) {
				thisNode = thisNode.getChildNode().computeIfAbsent(word.charAt(i), x -> new TrieNode());
			}
		}

		public void setLeftNodeCount(TrieNode node) {
			HashMap<Character, TrieNode> childMap = node.getChildNode();
			if (childMap.size() == 0) {
				return;
			}
			for (TrieNode childNode : childMap.values()) {
				setLeftNodeCount(childNode);
			}
			int count = 0;
			for (TrieNode childNode : childMap.values()) {
				count += childNode.getValue();
			}
			node.setValue(count);
		}

		public int getCount(String query) {
			TrieNode thisNode = this.rootNode;
			for (int i = 0; i < query.length(); i++) {
				char character = query.charAt(i);
				if (character == '?') {
					break;
				}
				thisNode = thisNode.getChildNode().get(character);
				if (thisNode == null) {
					return 0;
				}
			}
			return thisNode.getValue();
		}

		public TrieNode getRootNode() {
			return rootNode;
		}
	}

	class TrieNode {
		private final HashMap<Character, TrieNode> childNode = new HashMap<>();
		private int value = 1;

		public HashMap<Character, TrieNode> getChildNode() {
			return childNode;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}