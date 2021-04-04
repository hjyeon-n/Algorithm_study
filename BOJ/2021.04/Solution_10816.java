import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_10816 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[N];
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int n = upperBound(cards, target) - lowerBound(cards, target);
			sb.append(n + " ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int upperBound(int[] cards, int target) {
		int start = 0;
		int end = cards.length;
		
		while (start < end) {
			int mid = (start + end) / 2;
			
			if (cards[mid] <= target) {
				start = mid + 1;
			}
			else {
				end = mid;
			}
		}
		return end;
	}
	
	public static int lowerBound(int[] cards, int target) {
		int start = 0;
		int end = cards.length;
		
		while (start < end) {
			int mid = (start + end) / 2;
			
			if (cards[mid] >= target) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		return end;
	}
}