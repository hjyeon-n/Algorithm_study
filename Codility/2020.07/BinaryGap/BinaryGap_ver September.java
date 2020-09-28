class BinaryGap {
    public int solution(int N) {
        // write your code in Java SE 8
        int gap = 0;
        int max = 0;
        String binary = Integer.toBinaryString(N);
        
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                max = Math.max(gap, max);
                gap = 0;
            }
            else {
                gap++;
            }
        } 
        return max;
    }
}