import java.util.*;
public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", 
				"07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", 
				"19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		
		int[] answer = solution(fees, records);
		
		for (int val : answer) {
			System.out.println(val);
		}
	}

	public static int[] solution(int[] fees, String[] records) {
        TreeMap<String, Integer> manage = new TreeMap<String, Integer>();
        TreeMap<String, Integer> save = new TreeMap<String, Integer>();
        
        for (String record : records) {
            int time = Integer.parseInt(record.split(" ")[0].replace(":", ""));
            String num = record.split(" ")[1];
            String action = record.split(" ")[2];
            
            time = transTime(time);
            
            if (action.equals("IN")) {
//                 입차하면 관리 맵에 put
                manage.put(num, time);
            }
            else {
                int inTime = manage.get(num);
                int val = time - inTime;
                
//                 이전에 기록이 있다면
                if (save.get(num) != null) {
                    save.put(num, save.get(num) + val);
                }
                else {
                    save.put(num, val);
                }
                manage.remove(num);
            }
        }
        
//         출차가 되지 않은 경우 처리
        for (String mapKey : manage.keySet()) {
            int usedTime = transTime(2359) - manage.get(mapKey);
            
            if (save.containsKey(mapKey)) {
                save.put(mapKey, save.get(mapKey) + usedTime);
            }
            else {
                save.put(mapKey, usedTime);
            }
        }
        
        int idx = 0;
        int[] answer = new int[save.keySet().size()];
        for (String mapKey : save.keySet()) {
            int totalTime = save.get(mapKey);
            int basicTime = fees[0];
            int basicFee = fees[1];
            int extraTime = fees[2];
            int extraFee = fees[3];
            
            if (totalTime - basicTime <= 0) {
                answer[idx] = basicFee;
            } 
            else {
                int restTime =  totalTime - basicTime;
                answer[idx] += basicFee;
                
                if (restTime % extraTime == 0) {
                    answer[idx] += (restTime / extraTime) * extraFee;
                }
                else {
                    answer[idx] += ((restTime / extraTime) + 1) * extraFee;
                }
            }  
            idx++;
        }
        
        return answer;
    }
    
    public static int transTime(int time) {
        int hour = time / 100;
        int minute = time % 100;
        
        return hour * 60 + minute;
    }
}