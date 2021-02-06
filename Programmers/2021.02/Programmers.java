import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(solution(118372));
	}
	
	public static long solution(long n) {
        ArrayList<Long> list = new ArrayList<Long>();
        
        while (n != 0) {
            list.add(n % 10);
            n = n / 10;
        } 
        
        Collections.sort(list, Comparator.reverseOrder());
        String num = "";
        for (int i = 0; i < list.size(); i++) {
            num += String.valueOf(list.get(i));
        }
        
        return Long.parseLong(num);
    }
}