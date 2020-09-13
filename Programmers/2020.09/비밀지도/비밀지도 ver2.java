
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
        	answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }
        
        for (int i = 0; i < n; i++) {
            answer[i] = String.format("%" + n + "s", answer[i]);
            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("0", " ");
        }
        
        return answer;
    }
}
