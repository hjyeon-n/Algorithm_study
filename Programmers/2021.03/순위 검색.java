import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;


class Programmers {
	static HashMap<String, ArrayList<Integer>> map;
    static boolean[] visited;
    static String[] comb_arr;
    static String[] candidate;
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		int[] answer = solution(info, query);
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<String, ArrayList<Integer>>();
        ArrayList<Integer> scoreList = new ArrayList<Integer>();
        
//         info 후보군
        for (int i = 0; i < info.length; i++) {
            String[] arr = info[i].split(" ");
            candidate = new String[4];
            int score = Integer.parseInt(arr[arr.length - 1]);
            scoreList.add(score);
            
            for (int j = 0; j < 4; j++) {
                candidate[j] = arr[j];
            }
            
            for (int j = 1; j <= 4; j++) {
//                 후보군 조합
                visited = new boolean[4];
                comb_arr = new String[4];
                comb(4, j, 0, 0, score);
            }
        }
        
        Collections.sort(scoreList);
        
        Iterator<String> iter= map.keySet().iterator();
        while (iter.hasNext()){
            String key = iter.next();
            ArrayList<Integer> tmp = map.get(key);
            Collections.sort(tmp);
        }
        
//         쿼리에 따른 후보군 찾기
        for (int i = 0; i < query.length; i++) {
            String str = query[i];
            String[] strArr = str.split(" ");
            int score = Integer.parseInt(strArr[strArr.length - 1]);
            str = "";
            
            for (int j = 0; j < strArr.length - 1; j++) {
            	str += strArr[j];
            }
            str = str.replace("-", "");
            str = str.replace("and", "");
            
            ArrayList<Integer> list;
            
            if (str.equals("")) {
            	list = scoreList;
            }
            else {
            	list = map.get(str);
            }
            
            if (list == null) {
            	answer[i] = 0;
            }
            else {
            	answer[i] = binarySearch(list, score);
            }
        }
        return answer;
    }
    
    public static void comb(int n, int m, int depth, int idx, int score) {
        if (depth == m) {
            String str = "";
            
            for (int i = 0; i < m; i++) {
                str += comb_arr[i];
            }
            
            if (map.containsKey(str)) {
                ArrayList<Integer> list = map.get(str);
                list.add(score);
//                Collections.sort(list);
                map.put(str, list);
            }
            else {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(score);
                map.put(str, tmp);
            }
        }
        
        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb_arr[depth] = candidate[i];
                comb(n, m, depth + 1, i, score);
                visited[i] = false;
            }
        }
    }
    
    public static int binarySearch(ArrayList<Integer> list, int score) {
        int start = 0;
        int end = list.size();
        
        while (start < end) {
            int mid = (start + end) / 2;
            
            if (list.get(mid) >= score) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return list.size() - end;
    }
}
