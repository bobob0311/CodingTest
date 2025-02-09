/*
돌아가는 순서가 중요한가?
결국 열을 돌리든 행을 돌리든 돌아가는 횟수에 따라 달라진다. 
돌아가는 순서가 중요하지는 않을 것으로 생각된다. 
다르게 시작된 애는 홀수번 돌아가야한다. 
같게 시작디된 애는 짝수번 돌아가야된다. 
그럼 하나의 열을 짝수번 돌렸을 때로 확인을 해야되는건가?
10000 개의 짝 홀 조합이 존재 
100개를 확인 해야된다?
두번 뒤집으면 결국 원점 아닌가? 원점이 맞다.
그러면 그냥 모든 경우의 수대로 돌린다?
10000 * 100
*/

class Solution {
    static int n;
    static int m;
    static int total = 10000;
    public int solution(int[][] beginning, int[][] target) {
        n = beginning.length;
        m = beginning[0].length;
        
        boolean[] chkN = new boolean[n];
        sol(chkN,0,0,beginning,target);
        if(total == 10000){
            return -1;
        }else{
            return total;
        }
    }
    
    static void sol(boolean[] chkN,int nowCnt, int turnCount,int[][] beginning, int[][] target){
        if(nowCnt == n){
            chkValid(chkN,turnCount,beginning,target);
            return;
        }
        for(int i = 0; i<2; i++){
            if(i == 0){
                chkN[nowCnt] = true;
                sol(chkN,nowCnt+1,turnCount+1,beginning,target);
                chkN[nowCnt] = false;
            }else{
                
                sol(chkN,nowCnt+1,turnCount,beginning,target);
            }
        }
    }
    
    static void chkValid(boolean[] chkN, int answer,int[][] beginning, int[][] target){
        for(int i = 0; i<m; i++){
            // 이전 상태를 저장할 변수
            // 돌리면 false
            // 아니면 true
            boolean prev = (chkN[0]) ? (beginning[0][i] != target[0][i]) : (beginning[0][i] == target[0][i]);
            for(int j = 0; j<n; j++){
                // 현재 상태를 저장
                boolean now;
                // 만약 줄을 돌렸으면 지금꺼랑 반대이므로 now함수에 같지않으면 true
                if(chkN[j]){
                    now = (beginning[j][i] != target[j][i]);
                // 줄을 안돌렸을 경우이므로 같은 경우만 true;
                }else{
                    now = (beginning[j][i] == target[j][i]);
                }
                // 이전 상태값하고 now값이 다르면 불가능하므로 return
                if(prev != now){
                    return;
                }
            }
            if(!prev){
                answer++;
            }
        }
        
        total = Math.min(total,answer);
        return;
    }
}