import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(solution(4, costs));
	}

	public static int solution(int n, int[][] costs) {
        arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[2] < b[2]) {
                    return -1;
                }
                else if (a[2] > b[2]) {
                    return 1;
                }
                return 0;
            }
        });
        
        int answer = 0;
        for (int i = 0; i < costs.length; i++) {
            int x = costs[i][0];
            int y = costs[i][1];
            int w = costs[i][2];
            
            int a = find(x);
            int b = find(y);
            
            if (a != b) {
                answer += w;
                union(x, y);
            }
        }
        
        return answer;
    }
    
    public static int find(int v) {
        if (v == arr[v]) {
            return v;
        }
        return arr[v] = find(arr[v]);
    }
    
    public static void union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);
        
        if (v1 > v2) {
            arr[v1] = v2;
        }
        
        if (v1 < v2) {
            arr[v2] = v1;
        }
    }
}