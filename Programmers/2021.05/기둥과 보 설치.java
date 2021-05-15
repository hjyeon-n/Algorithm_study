import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args){
		// TODO Auto-generated method stub
		int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		int n = 5; 
		int[][] answer = solution(n, build_frame);
		
		for (int i = 0; i < graph.size(); i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static int[][] solution(int n, int[][] build_frame) {
		graph = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];
            int y = build_frame[i][1];
            int stuff = build_frame[i][2];
            int operate = build_frame[i][3];
            
//            삭제하는 경우
            if (operate == 0) {
            	int idx = 0;
            	for (int j = 0; j < graph.size(); j++) {
            		if (x == graph.get(j).get(0) && y == graph.get(j).get(1) && stuff == graph.get(j).get(2)) {
            			idx = j;
            		}
            	}
            	
            	ArrayList<Integer> tmp = graph.get(idx);
            	graph.remove(idx);
            	
            	if (!possible()) {
            		graph.add(tmp);
            	}
            }
            
            if (operate == 1) {
            	ArrayList<Integer> tmp = new ArrayList<Integer>();
            	tmp.add(x);
            	tmp.add(y);
            	tmp.add(stuff);
                graph.add(tmp);
                
                if (!possible()) {
            		graph.remove(graph.size() - 1);
            	}
            }
		}
		
		// 정렬 수행
		int[][] answer = new int[graph.size()][3];
        for (int i = 0; i < graph.size(); i++) {
        	answer[i][0] = graph.get(i).get(0);
        	answer[i][1] = graph.get(i).get(1);
        	answer[i][2] = graph.get(i).get(2);
        }
        
        Arrays.sort(answer, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                else {
                    if (o1[1] != o2[1]) {
                        return o1[1] - o2[1];
                    }
                    return o1[2] - o2[2];
                }
        	}
        });
        return answer;
        
    }
	
	public static boolean possible() {
		for (int i = 0; i < graph.size(); i++) {
			int x = graph.get(i).get(0);
            int y = graph.get(i).get(1);
            int stuff = graph.get(i).get(2);
            
//            기둥인 경우
            if (stuff == 0) {
            	boolean flag = false;
            	
//            	바닥 위일 때
            	if (y == 0) {
            		flag = true;
            	}
            	
//            	'보의 한 쪽 끝 부분 위' 혹은 '다른 기둥 위'라면
            	for (int j = 0; j < graph.size(); j++) {
            		if (x - 1 == graph.get(j).get(0) && y == graph.get(j).get(1) && 1 == graph.get(j).get(2)) {
            			flag = true;
            		}
            		if (x == graph.get(j).get(0) && y == graph.get(j).get(1) && 1 == graph.get(j).get(2)) {
                        flag = true;
                    }
                    if (x == graph.get(j).get(0) && y - 1 == graph.get(j).get(1) && 0 == graph.get(j).get(2)) {
                        flag = true;
                    }
            	}
            	
            	if (!flag) {
            		return false;
            	}
            }
            
//            보인 경우
            if (stuff == 1) {
            	boolean check = false;
                boolean left = false;
                boolean right = false;
                
//                '한쪽 끝 부분이 기둥 위' 혹은 '양쪽 끝 부분이 다른 보와 동시에 연결'
                for (int j = 0; j < graph.size(); j++) {
                    if (x == graph.get(j).get(0) && y - 1 == graph.get(j).get(1) && 0 == graph.get(j).get(2)) {
                        check = true;
                    }
                    
                    if (x + 1 == graph.get(j).get(0) && y - 1 == graph.get(j).get(1) && 0 == graph.get(j).get(2)) {
                        check = true;
                    }
                    
                    if (x - 1 == graph.get(j).get(0) && y == graph.get(j).get(1) && 1 == graph.get(j).get(2)) {
                        left = true;
                    }
                    
                    if (x + 1 == graph.get(j).get(0) && y == graph.get(j).get(1) && 1 == graph.get(j).get(2)) {
                        right = true;
                    }
                }
                
                if (left && right) {
                	check = true;
                }
                
//                아니라면 거짓(False) 반환
                if (!check) {
                	return false; 
                }
            }
		}
		return true;
	}
}