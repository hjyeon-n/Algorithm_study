public class Programmers {
	static int answer, len; 
    static boolean[] visited;
    
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    	System.out.print(solution("hit", "cog", words));
    }
    
	public static int solution(String begin, String target, String[] words) {
        answer = 50;
        len = words.length;
        visited = new boolean[len]; 
        
        if (isContain(words, target)) {
            dfs(begin, target, words, 0);
        }
        else {
            return 0;
        }
        return answer;
    }
    
    public static boolean isContain(String words[], String target) {
        for (int i = 0; i < len; i++) {
            if (words[i].equals(target)) {
                return true;
            }
        }
        return false;
    }
    
    public static void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                if (canConvert(begin, words[i])) {
                    visited[i] = true;
                    dfs(words[i], target, words, cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }
    
    public static boolean canConvert(String begin, String word) {
        int cnt = 0;
        
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) == word.charAt(i)) {
                cnt++;
            }
        }
        
        if (cnt == begin.length() - 1) {
            return true;
        }
        return false;
    }
}