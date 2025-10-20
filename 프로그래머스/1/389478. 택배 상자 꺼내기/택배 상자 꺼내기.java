/*
n개를 w개씩 놓을 거임
하지만 리버스로~
그냥 마지막만 확인하면 될듯?
2단위로 같은 방향으로 돌아가니까
*/

class Solution {
    public int solution(int n, int w, int num) {
        int targetFloor = findFloor(num,w);
        int targetLine = findLine(num,w,targetFloor);
        int maxLineFloor = (n / (w*2)) *2;
        
        if(n - maxLineFloor * w >= targetLine){ 
            maxLineFloor++;
            if(w - (n - maxLineFloor * w) +1 <= targetLine && maxLineFloor * w < n) maxLineFloor++;
        
        }
        
        return maxLineFloor - targetFloor +1;
    }
    
    // 1층부터 시작
    public int findFloor(int targetNum,int lineCnt){
        int floor = targetNum/lineCnt;
        
        if(targetNum % lineCnt != 0){
            floor +=1;
        }
        return floor;
    }
    
    public int findLine(int targetNum, int lineCnt, int floor){
        int line = -1;
        if(floor % 2 == 0){
            if(targetNum % lineCnt == 0){
                line = 1;
            }else{
                line = lineCnt - (targetNum % lineCnt) +1;                
            } 
        }else{
            line = targetNum % lineCnt;
            if(line == 0 ) line = lineCnt;
        }
        
        
        return line;
    }
}