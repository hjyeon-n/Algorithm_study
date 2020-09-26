
public class Programmers {    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[] arr = solution(10, 2);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int rslt = brown + yellow;

        for(int i = 1; i <= rslt; i++) {
            if(rslt % i == 0){
                int width = rslt / i;    
                int height = i;    

                int a = width - 2;    
                int b = height - 2;    
                
                if(a * b == yellow && width >= height){
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }
        return answer;
    }
}
