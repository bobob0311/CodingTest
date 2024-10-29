/*
선공 "O" 후공 "X"

게임종료
1. 가로 세로 대각선 3개 일경우
2. 9칸이 모두 찬 경우

기본 조건 O > x+1

*/

class Solution {
    public int solution(String[] board) {
        int cntO =0;
        int cntX =0;
        
        for(String str : board){
            for(int i = 0; i<str.length(); i++){
                if(str.charAt(i) == 'O'){
                    cntO++;
                }else if (str.charAt(i) == 'X'){
                    cntX++;
                }
            }
        }
        // 비기는 경우도 여기에 들어가는 듯?
        // 후공이 선공보다 많을 경우 + 선공이 후공보다 2개이상 많을 경우 
        if(!(cntO >= cntX && cntO < cntX+2)){
            return 0;
        }
        
        boolean chkO = false;
        boolean chkX = false;
        // 가로 확인
        for(String str : board){
            int lineO =0;
            int lineX =0;
            for(int i = 0; i<str.length(); i++){
                if(str.charAt(i) == 'O'){
                    lineO++;
                }else if (str.charAt(i) == 'X'){
                    lineX++;
                }
                if(lineO == 3){
                    chkO = true;;
                }
                if(lineX == 3){
                    chkX = true;
                }
            }
        }
        
        // 세로 확인
        for(int j =0; j<3; j++){
            int lineO =0;
            int lineX =0;
            for(int i = 0; i<3; i++){
                if(board[i].charAt(j) == 'O'){
                    lineO++;
                }else if (board[i].charAt(j) == 'X'){
                    lineX++;
                }
                if(lineO == 3){
                    chkO = true;;
                }
                if(lineX == 3){
                    chkX = true;
                }
            }
        }
        
        // 대각선 확인
        int lineO = 0;
        int lineX = 0;
        int lineO2 = 0;
        int lineX2 = 0;
        
        for(int i =0; i<3; i++){
            if(board[i].charAt(i) == 'X'){
                lineX++;
            }else if(board[i].charAt(i) == 'O'){
                lineO++;
            }
            if(board[i].charAt(2-i) == 'X'){
                lineX2++;
            }else if(board[i].charAt(2-i) == 'O'){
                lineO2++;
            }
        }
        
        if(lineO == 3 || lineO2==3){
            chkO = true;
        }
        if(lineX ==3 || lineX2==3){
            chkX = true;
        }
        
        
        
        if(chkO && chkX){
            return 0;
        }else if(chkO){
            if(cntO != cntX+1){
                return 0;
            }
        }else if(chkX){
                if(cntO != cntX){
                    return 0;
                }
        }
        return 1;
    }
}