/*
m명이 늘어날 때마다 서버 1대가 추가로 필요
(n * m) ~ (n+1) * m 명 미만일경우 n대 
k시간 동안 운영ㅎ고 반납

모든 사용자가 사용하기 위해 서버를 최소 몇 번 증설해야하는가?

*/

// m => 서버 증설 인원
// k => 서버가 얼마나 유지되는지

class Solution {
    public int solution(int[] players, int m, int k) {
        int[] server = new int[24];
        int answer = 0;
        for(int i = 0; i< 24; i++){
            // 현재 지금 서버가 감당할 수 있는 인원수
            int serverCan = server[i] * m + m-1;
            // 만약 지금 서버가 플레이어를 감당할 수 없다면?
            if(serverCan < players[i]){
                // 증설해야하는 서버의 개수를 구해준다.
                int serverIncrease = ((players[i] - serverCan -1) / m) +1;
                answer += serverIncrease;
                int limit = Math.min(i+k,players.length);
                for(int j=i; j< limit; j++){
                    server[j] += serverIncrease;
                }
            }
        }
        
        return answer;
    }
}