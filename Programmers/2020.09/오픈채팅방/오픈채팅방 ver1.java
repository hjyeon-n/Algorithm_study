import java.util.*;

public class Main {
	static HashMap <String, String> map;
	static int cnt;
	public static void main(String[] args){
		// TODO Auto-generated method stub
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] answer = solution(record);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static String[] solution(String[] record) {
		map = new HashMap<String, String>();
		cnt = 0;
		record = splitStr(record, 0);
		String[] answer = splitStr(record, 1);
		return answer;
	}
	
	public static String[] splitStr(String[] record, int flag) {
        String[] rslt = new String[record.length - cnt];
        int j = 0;
        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            int len = str.length;
            switch(str[0]) {
                case "Enter":
                    if (len > 2) {
                        map.put(str[1], str[2]);
                        rslt[j++] = str[0] + " " + str[1];
                    }
                    else {
                        rslt[j++] = map.get(str[1]) + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
                    }
                    break;
                case "Leave":
                	if (flag == 1) {
                        rslt[j++] = map.get(str[1]) + "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
                    }
                    else {
                        rslt[j++] = str[0] + " " + str[1];
                    }
                    break;
                case "Change":
                	if (flag == 0) {
                        rslt[j++] = str[0] + " " + str[1];
                        map.put(str[1], str[2]);
                        cnt++;
                    }
                    break;
            }
        }
        return rslt;
    }
}