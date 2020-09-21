import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Arrays.sort(A);
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (binarySearch(num, A)) {
				System.out.println("1");
			}
			else {
				System.out.println("0");
			}
		}
	}
	
	public static boolean binarySearch(int val, int[] arr) {
		int first = 0;
		int last = arr.length - 1;
		int mid;
		
		while (first <= last) {
			mid = (first + last) / 2;
			if (val == arr[mid]) {
				return true;
			}
			else {
				if (arr[mid] < val) {
					first = mid + 1;
				}
				else {
					last = mid - 1;
				}
			}
		}
		return false;
	}
}