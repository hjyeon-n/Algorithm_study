import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

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
        Deque<String> queue = new LinkedList<String>(); 
        int hit = 0;
        int fail = 0;
        int i = 0;

        while (i < cities.length) {
            if (queue.contains(cities[i].toLowerCase())) {
                hit++;
                ArrayList<String> list = new ArrayList<String>();
                while (true) {
                    String str = queue.peek();
                    queue.poll();
                    if (str.equals(cities[i].toLowerCase())) {
                        break;
                    }
                    list.add(str);
                }

                for (int j = list.size() - 1; j >= 0; j--) {
                    queue.addFirst(list.get(j));
                }
                queue.add(cities[i].toLowerCase());
            }
            else {
                fail++;
                if (queue.size() == cacheSize) {
                    queue.poll();
                }
                queue.add(cities[i].toLowerCase());
            }
            i++;
        }
        return hit + fail * 5;
    }
}
