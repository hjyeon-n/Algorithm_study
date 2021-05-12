import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
public class Main {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int[] stages= {2, 1, 2, 6, 2, 4, 3, 3};
		int[] answer = solution(5, stages);
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
	public static int[] solution(int N, int[] stages) {
		Stage[] fail = new Stage[N];
        double userNum = stages.length;
        
        for (int i = 1; i <= N; i++) {
            double cnt = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    cnt++;
                }
            }
            fail[i - 1] = new Stage(i - 1, cnt / userNum);
            userNum = userNum - cnt;
        }
        
        Arrays.sort(fail, new Comparator<Stage>() {
			public int compare(Stage a, Stage b) {
				if(a.failRate < b.failRate){
					return 1;
				}
				if (a.failRate > b.failRate) {
                    return -1;
                }
                return 0;
			}
		});
        
        int answer[] = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = fail[i].idx + 1;
        }
        return answer;
    }
}
class Stage{
    int idx;
    double failRate;

    public Stage(int idx, double failRate){
        this.idx = idx;
        this.failRate = failRate;
    }
}
