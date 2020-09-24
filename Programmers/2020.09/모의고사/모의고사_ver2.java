import java.util.ArrayList;

public class Programmers {
	static ArrayList<Integer> preorder;
	static ArrayList<Integer> postorder;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answers = {1, 2, 3, 4, 5};
		solution(answers);
	}
	
	public static int[] solution(int[] answers) {
		int[] score = new int[3];
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i = 0; i < answers.length; i++) {
            if (A[i % 5] == answers[i]) {
                score[0]++;
            }
            if (B[i % 8] == answers[i]) {
                score[1]++;
            }
            if (C[i % 10] == answers[i]) {
                score[2]++;
            }
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) {
                list.add(i + 1);
            }
        }
    
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
