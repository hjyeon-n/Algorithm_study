import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 5052_ver2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 1; test <= T; test++) {
            int N = Integer.parseInt(br.readLine());
//            전화번호는 길어야 10자리 이내이므로
            Trie trie = new Trie(10, '0');
            boolean isConsistent = true;
            
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                if (isConsistent) {
                    isConsistent = trie.insert(line);
                }
            }
            
            if (isConsistent) {
                System.out.println("YES");
            } 
            else {
            	System.out.println("NO");
            }
        }
    }
}

class Trie {
    int ALPHA_SIZE;
    char ALPHA_START;
    TrieNode root;

    Trie(int size, char start) {
        this.ALPHA_SIZE = size;
        this.ALPHA_START = start;
        this.root = new TrieNode();
    }

    class TrieNode {
        TrieNode[] child = new TrieNode[ALPHA_SIZE];
        boolean isEnd;

        TrieNode() {
            for (int i = 0; i < ALPHA_SIZE; i++) {
                child[i] = null;
            }
            isEnd = false;
        }
    }

    boolean insert(String key) {
        int len = key.length();
        int idx;

        TrieNode cur = root;
        for (int i = 0; i < len; i++) {
            idx = key.charAt(i) - ALPHA_START;
            
            if (cur.child[idx] == null) {
                cur.child[idx] = new TrieNode();
            } 
            else if (i == len - 1) {
                return false;
            }
//            현재 위치로 변경
            cur = cur.child[idx];
            
            if (cur.isEnd) {
            	return false;
            }
        }
        cur.isEnd = true;
        return true;
    }

//    boolean search(String key) {
//        int idx;
//
//        TrieNode cur = root;
//        for (int i = 0; i < key.length(); i++) {
//            idx = key.charAt(i) - ALPHA_START;
//            if (cur.child[idx] == null) {
//                return false;
//            }
//            cur = cur.child[idx];
//        }
//
//        return (cur != null && cur.isEnd);
//    }
}
