import java.util.HashSet;

class Programmers {
	public static void main(String[] args) {
		String[] words= {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] answer = solution(3, words);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static int[] solution(int n, String[] words) {
        int len = words.length;
        
        if (words[0].length() <= 1) {
            return new int[]{1, 1};
        }
        
        char last = words[0].charAt(words[0].length() - 1);
        HashSet<String> set = new HashSet<String>();
        set.add(words[0]);
        
        for (int i = 1; i < len; i++) {
            String word = words[i];
            
            if (word.length() <= 1 || word.charAt(0) != last 
               || set.contains(word)) {
                return new int[]{i % n + 1, i / n + 1};
            }
            
            last = word.charAt(word.length() - 1);
            set.add(word);
        }

        return new int[]{0, 0};
    }
}
