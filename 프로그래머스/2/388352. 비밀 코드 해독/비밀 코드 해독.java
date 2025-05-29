import java.util.*;
/*
1~n 까지 서로 다른 정수 5개가 오름차순으로 정렬된 비밀 코드

m번의 시도 가능
5개 입력하면 몇 개가 비밀 코드에 포함되어있는지 알려준다. 

m번의 시도 후, 비밀 코드로 가능한 정수 조합의 개수를 알고 싶다. 


n => 어느 수까지인지   // 30
q => 입력한 정수를 담은 2차원 배열 // 10
ans => 시스템이 몇개 맞았는지 응답해줌.

모든 경우의 수를 세어볼까요? 

30 C 5 => 30*29*28*27*26 / (5*4*3*2)

240,000 * 5 => 100만

nowArr를 만든다.
q개의 case확인 맞는지 ~


*/

class Solution {
    static int[] nowArr = new int[5];
    static int limit;
    static int[][] targetArr;
    static int[] targetAnswer;
    static int answer = 0;
    
    
    public int solution(int n, int[][] q, int[] ans) {
        limit = n;
        targetArr = q;
        targetAnswer = ans;
        
        makeArr(0,0);
        
        return answer;
    }
    
    static void makeArr(int step, int prevValue){
        if(step == 5){
            chkAnswer();
            return;
        }
        for(int i = prevValue +1; i<= limit; i++){
            nowArr[step] = i;
            makeArr(step+1, i);
            nowArr[step] = 0;
        }
    }
    
    static void chkAnswer(){
        for(int i = 0; i< targetArr.length; i++){
            int cnt = 0;
            
            for(int j = 0; j< 5; j++){
                int nowTarget = nowArr[j];
                
                for(int k = 0; k<5; k++){
                    if(nowTarget == targetArr[i][k]){
                        cnt++;
                        break;
                    }else if(nowTarget < targetArr[i][k]){
                        break;
                    }
                }
            }
            
            if(cnt != targetAnswer[i]){
                return;
            }
        }
        answer++;
        return;
    }
    
    
}