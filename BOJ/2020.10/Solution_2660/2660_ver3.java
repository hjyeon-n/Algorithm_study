import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 2660_ver3 {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int distance[][] = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
            	if (i != j) {
            		distance[i][j] = 12341234;
            	}
            }
        }
        
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if (x == -1 && y == -1) {
            	break;
            }
            
            distance[x][y] = 1;
            distance[y][x] = 1;
        }
        
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        
        int max[] = new int[N + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                max[i] = Math.max(distance[i][j], max[i]);
            }
            min = Math.min(max[i], min);
        }
        
        ArrayList<Integer> idxList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (min == max[i]) {
                idxList.add(i);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (min == max[i]) {
                list.add(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        System.out.println(min + " " + list.size());
        
        for (int idx : list) {
            sb.append(idx + " ");
        }
        System.out.println(sb);
    }
}