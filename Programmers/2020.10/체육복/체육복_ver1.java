import java.util.ArrayList;
import java.util.Arrays;

public class Programmers {    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	int[] lost = {2, 4};
    	int[] reserve = {1, 3, 5};
    	System.out.println(solution(5, lost, reserve));
    }
    
    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        ArrayList<Integer> lostList = new ArrayList<Integer>();
        ArrayList<Integer> reserveList = new ArrayList<Integer>();
        for (int i = 0; i < lost.length; i++) {
            lostList.add(lost[i]);
        }

        for (int i = 0; i < reserve.length; i++) {
            reserveList.add(reserve[i]);
        }

        int k = 0;
        while (k < reserveList.size()) {
            boolean flag = false;
            for (int j = 0; j < lostList.size(); j++) {
                if (reserveList.get(k) == lostList.get(j)) {
                    reserveList.remove(k);
                    lostList.remove(j);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                k++;
            }
        }

        for (int i = 0; i < reserveList.size(); i++) {
            boolean flag = false;
            int front = reserveList.get(i) - 1;
            int back = reserveList.get(i) + 1;

            for (int j = 0; j < lostList.size(); j++) {
                if (lostList.get(j) == front || lostList.get(j) == back) {
                    lostList.remove(j);
                    flag = true;
                    break;
                }
            }

            if (lostList.size() == 0) {
                break;
            }

            if (flag) {
                continue;
            }
        }
        int answer = n - lostList.size(); 
        return answer;
    }
}