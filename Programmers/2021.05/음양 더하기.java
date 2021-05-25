
public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		int[] absolutes = {4, 7, 12};
		boolean[] signs = {true,false,true};
		System.out.println(solution(absolutes, signs));
	}

	public static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;

		for (int i = 0; i < absolutes.length; i++) {
			int mark = signs[i] ? 1 : -1;
			answer += absolutes[i] * mark;
		}

		return answer;
	}
}