import java.util.Arrays;

public class Programmers {
	static boolean[] visited;
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[] people = {70, 80, 50};
    	System.out.println(solution(people, 100));
    }
    
	public static int solution(int[] people, int limit) {
        int answer = 0;
        int len = people.length;
        Arrays.sort(people);
        
        int min = 0; 
        int max = len - 1;
        
        while (min <= max) {
        	if (people[min] + people[max] <= limit) {
        		min++;
        	}
        	max--;
        	answer++;
        }
        return answer;
    }
}