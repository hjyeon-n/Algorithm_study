import java.util.Scanner;

public class problem_5585 {	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		int money = 1000- scan.nextInt();
		int[] change = {500, 100, 50, 10, 5, 1};
		int count = 0;
		
		int i = 0;
		while (true) {
			if (change[i] <= money) {
				count += money / change[i]; 
				money = money % change[i];
			}
			i++;
			
			if(i > change.length - 1 || money == 0) {
				break;
			}
		}
		System.out.println(count);
	}
}