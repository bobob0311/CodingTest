class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        int xlimit = (board[0]-1)/2;
        int ylimit = (board[1]-1)/2;
        for(String input : keyinput){
            if(input.equals("left")){
                if(x> - xlimit){
                    x--;
                }
            }else if(input.equals("right")){
                if(x < xlimit){
                    x++;
                }
            }else if(input.equals("down")){
                if( y > -ylimit){
                    y--;
                }
            }else{
                if(y < ylimit){
                    y++;
                }
            }
        }
        int[] answer = {x,y};
        return answer;
    }
}