import java.util.ArrayList;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution("LULLLLLLU"));
	}
	
	public static int solution(String dirs) {
		int answer = 0;
		ArrayList<String> list = new ArrayList<String>();
        int[] loc = {5, 5};
        for (int i = 0; i < dirs.length(); i++) {
            char alpha = dirs.charAt(i);
            String start = String.valueOf(loc[0]) + "," + String.valueOf(loc[1]);
            
            if (alpha == 'U') {
                if (loc[1] + 1 <= 10) {
                    loc[1] += 1;
                    String str1 = start + "/" + String.valueOf(loc[0]) + "," + String.valueOf(loc[1]);
                    String str2 = String.valueOf(loc[0]) + "," + String.valueOf(loc[1]) + "/" + start;
                    if (!list.contains(str1) && !list.contains(str2)) {
                    	list.add(str1);
                    	list.add(str2);
                    	answer++;
                    }
                }
            }
            else if (alpha == 'D') {
                if (loc[1] - 1 >= 0) {
                    loc[1] -= 1;
                    String str1 = start + "/" + String.valueOf(loc[0]) + "," + String.valueOf(loc[1]);
                    String str2 = String.valueOf(loc[0]) + "," + String.valueOf(loc[1]) + "/" + start;
                    if (!list.contains(str1) && !list.contains(str2)) {
                    	list.add(str1);
                    	list.add(str2);
                    	answer++;
                    }
                }
            }
            else if (alpha == 'L') {
                if (loc[0] - 1 >= 0) {
                    loc[0] -= 1;
                    String str1 = start + "/" + String.valueOf(loc[0]) + "," + String.valueOf(loc[1]);
                    String str2 = String.valueOf(loc[0]) + "," + String.valueOf(loc[1]) + "/" + start;
                    if (!list.contains(str1) && !list.contains(str2)) {
                    	list.add(str1);
                    	list.add(str2);
                    	answer++;
                    }
                }
            }
            else if (alpha == 'R') {
                if (loc[0] + 1 <= 10) {
                    loc[0] += 1;
                    String str1 = start + "/" + String.valueOf(loc[0]) + "," + String.valueOf(loc[1]);
                    String str2 = String.valueOf(loc[0]) + "," + String.valueOf(loc[1]) + "/" + start;
                    if (!list.contains(str1) && !list.contains(str2)) {
                    	list.add(str1);
                    	list.add(str2);
                    	answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}