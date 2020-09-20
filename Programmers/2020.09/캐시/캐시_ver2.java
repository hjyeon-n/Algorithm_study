import java.util.LinkedList;
import java.util.Queue;

public class Programmers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println(solution(15, arr));
	}

	public static int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0) {
			return 5 * cities.length;
		}
 		Queue<String> queue = new LinkedList<String>();	
		int answer = 0;
		int i = 0;
		while (i < cities.length) {
			if (queue.contains(cities[i].toLowerCase())) {
				answer++;
				queue.remove(cities[i].toLowerCase());
				queue.add(cities[i].toLowerCase());
			}
			else {
				answer += 5;
				if (queue.size() == cacheSize) {
					queue.poll();
				}
				queue.add(cities[i].toLowerCase());
			}
			i++;
		}
        return answer;
    }
}
