import java.util.Arrays;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
		System.out.print(solution(routes));
	}

	public static int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int camera = routes[0][1];

        for (int i = 0; i < routes.length; i++) {
            if (camera < routes[i][0]) {
                camera = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}