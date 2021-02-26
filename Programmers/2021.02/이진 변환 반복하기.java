public class Programmers {
	static int cnt;
    static boolean[] visited;
    static int[] arr;
    static int[] answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = solution("110010101001");
		System.out.print(arr[0] + " " + arr[1]);
	}
	
	public static int[] solution(String s) {
        int conversion = 0;
        int sum = 0;
        
        while (true) {
            if (s.equals("1")) {
                break;
            }
            
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                   cnt++; 
                }
            }
            sum += cnt;
            s = Integer.toBinaryString(s.length() - cnt);
            conversion++;
        }
        
        int[] answer = {conversion, sum};
        return answer;
    }
}