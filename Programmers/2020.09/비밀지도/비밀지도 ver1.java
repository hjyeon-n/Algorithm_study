
public class Programmers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};	
		
		String[] rslt = solution(6, arr1, arr2);
		for (String str : rslt) {
			System.out.println(str);
		}
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			String str1 = String.format("%0"+ n + "d", Long.parseLong(Long.toBinaryString(arr1[i])));
			String str2 = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr2[i])));

			String answerStr = "";
			for (int j = 0; j < n; j++) {
				if (str1.charAt(j) == '0' && str2.charAt(j) == '0') {
					answerStr += " ";
				}
				else {
					answerStr += "#";
				}
			}
			answer[i] = answerStr;
		}

		return answer;
	}
}
