import java.util.HashMap;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		
		int[] answer = solution(enroll, referral, seller, amount);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int len = enroll.length;
        HashMap<String, String> map = new HashMap<String, String>();
        HashMap<String, Integer> moneyMap = new HashMap<String, Integer>();
            
//         추천인 매칭 & 수익금 초기화
        for (int i = 0; i < len; i++) {
            map.put(enroll[i], referral[i]);
            moneyMap.put(enroll[i], 0);
        }
        
        for (int i = 0; i < seller.length; i++) {
        	int money = amount[i] * 100;
        	int share = money / 10;
        	
        	moneyMap.put(seller[i], moneyMap.get(seller[i]) + money - share);
//        	추천인
        	String recom = map.get(seller[i]);
        	
        	while (moneyMap.containsKey(recom)) {
        		int tmp = share / 10;
        		
        		moneyMap.put(recom, moneyMap.get(recom) + share - tmp);
        		share = tmp;
        		recom = map.get(recom);
        	}
        }
        
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = moneyMap.get(enroll[i]);
        }
        
        return answer;
    }
}