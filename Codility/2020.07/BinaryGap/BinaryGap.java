class BinaryGap {
	 public int solution(int N) {
	        // write your code in Java SE 8
		 int max = 0;
		 int len = 0;
		 String tmp = Integer.toBinaryString(N);
		 
		 for (int i = 0; i < tmp.length(); i++) {
			 if (tmp.charAt(i) == '1') {
				 len = 0;
				 int idx = i;
				 for (int j = i + 1; j < tmp.length(); j++) {
					 len = 0;
					 if (tmp.charAt(j) == '1') {
						 idx = j;
						 len = idx - i - 1;
						 max = Math.max(max, len);
						 break;
					 }
				 }
			 }
		 }
		 return max;
	 }
}
