import java.util.Arrays;
class Programmers {
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[] progresses = {93, 30, 55};
    	int[] speeds = {1, 30, 5};
    	int[] answer = solution(progresses, speeds);
    	
    	for (int i = 0; i < answer.length; i++) {
    		System.out.println(answer[i]);
    	}
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i = 0; i < progresses.length; i++) {
            while(progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i != 0).toArray();
    }
}