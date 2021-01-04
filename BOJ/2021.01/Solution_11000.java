import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_11000 {
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[][] lesson = new int[N][2];
    
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lesson[i][0] = Integer.parseInt(st.nextToken());
            lesson[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lesson, new Comparator<int[]>() {
			@Override
			public int compare(int[] start, int[] end) {
				if(start[0] == end[0]){
					return Integer.compare(start[1], end[1]);
				}
				return Integer.compare(start[0], end[0]);
			}
        });
        
        PriorityQueue<Integer> roomSize = new PriorityQueue<>();
 
        for (int i = 0; i < N; i++) {
 
            if (!roomSize.isEmpty() && roomSize.peek() <= lesson[i][0]){
                roomSize.poll();
            }
            roomSize.add(lesson[i][1]);
        }
 
        System.out.println(roomSize.size());
    }
}