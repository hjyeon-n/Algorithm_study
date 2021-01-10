import java.util.ArrayList;

public class Programmers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("50*6-3*2"));
	}

	public static long solution(String expression) {
		long answer = 0;
		char[][] operator = {{'*', '+', '-'}, {'*', '-', '+'}, {'+', '*', '-'},
				{'+', '-', '*'}, {'-', '*', '+'}, {'-', '+', '*'}};

		ArrayList<String> list = new ArrayList<String>();
		String num = "";
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {
				if (num != null) {
					list.add(num);
					num = "";
				}
				list.add(String.valueOf(ch));
			}
			else {
				num += String.valueOf(ch);
			}
		}
		list.add(num);
		
		for (int i = 0; i < 6; i++) {
			ArrayList<String> tmp = list;
			for (int j = 0; j < 3; j++) {
				String target = String.valueOf(operator[i][j]);
				for (int k = 0; k < tmp.size(); k++) {
					if (tmp.get(k).equals(target)) {
						tmp = calc(tmp, target, k);
						k -= 2;
					}
				}
			}
			
			if (tmp.size() != 1) {
				tmp = calc(tmp, tmp.get(1), 1);
			}
			answer = Math.max(answer, Math.abs(Long.parseLong(tmp.get(0))));
		}  

		return answer;
	}

	public static ArrayList<String> calc(ArrayList<String> list, String target, int k) {
		long rslt = 0;
		long op1 = Long.parseLong(list.get(k - 1));
		long op2 = Long.parseLong(list.get(k + 1));
		
		switch(target) {
		case "+":
			rslt = op1 + op2;
			break;
		case "-":
			rslt = op1 - op2;
			break;
		case "*":
			rslt = op1 * op2;
			break;
		}
		
		ArrayList<String> newList = new ArrayList<String>();
		
		for (int i = 0; i < k - 1; i++) {
			newList.add(list.get(i));
		}
		
		newList.add(String.valueOf(rslt));
		
		for (int i = k + 2; i < list.size(); i++) {
			newList.add(list.get(i));
		}
		
		return newList;
	}
}