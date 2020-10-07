public class Programmers {    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[] lost = {2, 4};
    	int[] reserve = {1, 3, 5};
    	System.out.println(solution(5, lost, reserve));
    }
    
    public static int solution(int n, int[] lost, int[] reserve) {
    	int[] people = new int[n];
        int answer = n;

        for (int l : lost) {
            people[l - 1]--;
        }
        
        for (int r : reserve) {
            people[r - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if(people[i] == -1) {
                if(i - 1 >= 0 && people[i - 1] == 1) {
                    people[i]++;
                    people[i - 1]--;
                }
                else if(i + 1 < n && people[i + 1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }
                else { 
                    answer--;
                }
            }
        }
        return answer;
    }
}