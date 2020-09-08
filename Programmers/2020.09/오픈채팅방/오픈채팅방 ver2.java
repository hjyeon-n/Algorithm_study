import java.util.*;

public class Main {
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
		HashMap <String, String> nameMap = new HashMap<String, String>();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < record.length; i++) {
			String[] str = record[i].split(" ");
			
			if (str.length > 2) {
				nameMap.put(str[1], str[2]);
			}
			
			if (!str[0].equals("Change")) {
				list.add(str[0] + " " + str[1]);
			}
		}
		
		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(" ");
			
			if (str[0].equals("Enter")) {
				answer[i] = nameMap.get(str[1]) + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
			}
			else {
				answer[i] = nameMap.get(str[1]) + "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
			}
		}
		return answer;
	}
}