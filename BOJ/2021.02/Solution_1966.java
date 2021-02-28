import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1966 {
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int caseNum = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < caseNum; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int target = Integer.parseInt(st.nextToken());
        	
        	Queue<Pair> queue = new LinkedList<Pair>();
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		int val = Integer.parseInt(st.nextToken());
        		list.add(val);
        		queue.add(new Pair(val, j));
        	}
        	
        	Collections.sort(list, Collections.reverseOrder());
        	int cnt = 0;
        	int answer = 0;
        	while (!queue.isEmpty()) {
        		if (queue.peek().val < list.get(0)) {
        			Pair pair = queue.poll();
        			queue.add(pair);
        		}
        		else {
        			cnt++;
        			Pair pair = queue.poll();
        			list.remove(0);
        			if (pair.idx == target) {
        				answer = cnt;
        				break;
        			}
        		}
        	}
        	
        	if (answer != 0) {
        		System.out.println(answer);
        	}
        	else {
        		System.out.println(cnt);
        	}
        }
    }
    
    
}

class Pair {
	int val;
	int idx;
	
	public Pair(int val, int idx) {
		this.val = val;
		this.idx = idx;
	}
}