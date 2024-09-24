import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> st = new Stack<>();
        int answer = 0;
        int length = board.length;
        
        for(int line : moves){
            int idx = 0;
            while(idx<length){
                if(board[idx][line-1] != 0){
                    if(!st.isEmpty()){
                        if(st.peek() == board[idx][line-1]){
                            answer+=2;
                            st.pop();
                        }else{
                            st.push(board[idx][line-1]);
                        }
                    }else{
                        st.push(board[idx][line-1]);
                    }
                    board[idx][line-1] = 0;
                    break;
                }else{
                    idx++;
                }
            }
            
        }
        
        return answer;
    }
}