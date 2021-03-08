import java.util.*;
class Solution {
    static boolean[][] graph;
    static int[] dist;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        dist = new int[n + 1];
        graph = new boolean[n + 1][n + 1];
        
        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]][edge[i][1]] = true;
            graph[edge[i][1]][edge[i][0]] = true;
        }
        
        bfs(n);
        Arrays.sort(dist);
        int max = dist[n];
        
        for (int i = n; i >= 1; i--) {
            if (max == dist[i]) {
                answer++;         
            }
            
            if (max > dist[i]) {
                break;
            }
        }
        
        return answer;
    }
    
    public static void bfs(int n) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(1, 1));
        dist[1] = 1;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int val = node.val;
            int cnt = node.cnt;
            
            for (int i = 2; i <= n; i++) {
                if (graph[val][i] && dist[i] == 0) {
                    dist[i] = cnt + 1;
                    queue.add(new Node(i, dist[i]));
                }
            }
        }
    }
}

class Node {
    int val;
    int cnt;
    
    public Node (int val, int cnt) {
        this.val = val;
        this.cnt = cnt;
    }
}