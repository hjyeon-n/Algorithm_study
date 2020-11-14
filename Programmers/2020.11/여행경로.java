import java.util.ArrayList;
import java.util.Collections;

public class Programmers {
	static String routes;
    static boolean[] visited;
    static ArrayList<String> list;
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
		String[][] tickets = {
				{"ICN", "SFO"}, 
				{"ICN", "ATL"}, 
				{"SFO", "ATL"}, 
				{"ATL", "ICN"}, 
				{"ATL", "SFO"}
		};
		String[] answer = solution(tickets);
    	
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
    }
    
	public static String[] solution(String[][] tickets) {
        String[] answer = {};
        list = new ArrayList<String>();
        int len = tickets.length;
        visited = new boolean[len];
        
        for (int i = 0; i < len; i++) {
//             출발지가 ICN일 때만 고려해야 함
            String departure = tickets[i][0];
            String destination = tickets[i][1];
            
            if (departure.equals("ICN")) {
                visited[i] = true;
                routes = departure + ",";
                DFS(tickets, destination, 1);
                visited[i] = false;
            }
        }
        Collections.sort(list);
        answer = list.get(0).split(",");
        
        return answer;
    }
    
    public static void DFS(String[][] tickets, String destination, int length) {
        routes += destination + ",";
        if (length == tickets.length) {
            list.add(routes);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            
            if (!visited[i] && destination.equals(start)) {
                visited[i] = true;
                DFS(tickets, end, length + 1);
                visited[i] = false;
                routes = routes.substring(0, routes.length() - 4);
            }
        }
    }
}