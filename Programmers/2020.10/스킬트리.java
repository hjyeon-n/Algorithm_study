public class Programmers {
	static boolean[] visited;
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
    	
    	System.out.print(solution("CBD", skill_trees));
    }
    
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int len = skill_trees.length;
        
        for (int i = 0; i < len; i++) {
            String str = skill_trees[i];
            String tmp = "";
            for (int j = 0; j < str.length(); j++) {
                String alpha = String.valueOf(str.charAt(j));
                if (skill.contains(alpha)) {
                    tmp += alpha;
                }   
            }
            
            boolean flag = true;
            for (int j = 0; j < tmp.length(); j++) {
            	if (tmp.charAt(j) != skill.charAt(j)) {
            		flag = false;
            		break;
            	}
            }
            
            if (flag) {
            	answer++;
            }
        }
        return answer;
    }
}