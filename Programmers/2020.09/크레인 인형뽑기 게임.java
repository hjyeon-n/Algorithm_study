import java.util.Stack;

public class Programmers {    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
//    	int[] arr = {1, 2, 3, 2, 3, 1};
//    	int[] answer = solution(arr);
//    	
//    	for (int i = 0; i < arr.length; i++) {
//    		System.out.print(answer[i] + " ");
//    	}
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int moves_len = moves.length;
        int board_len = board.length;
        
        for (int i = 0; i < moves_len; i++) {
            int loc = moves[i] - 1;
            
            int pick = 0;
            for (int j = 0; j < board_len; j++) {
                if (board[j][loc] != 0) {
                    pick = board[j][loc];
                    board[j][loc] = 0;
                    break;
                }
            }
            if (pick == 0) {
                continue;
            }
            if (!stack.isEmpty()) {
                if (stack.peek() == pick) {
                    stack.pop();
                    answer += 2;
                }
                else {
                    stack.push(pick);
                }
            }
            else {
                stack.push(pick);
            }
        }
        
        return answer;
    }
}
