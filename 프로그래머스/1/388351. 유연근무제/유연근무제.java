/*
유연 근무제

출근 희망 시각 + 10분
토요일 일요일 영향 X
시에 100* 분을 더해

startday 1~7 월 ~일

7로 나눠서 나머지가 6이나 0이 나오면 pass
*/

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++){
            
            int selectedTime = schedules[i];
            int time = selectedTime/ 100;
            int min = selectedTime % 100;
            
            int cnt = 0;
            for(int j = 0; j< timelogs[i].length; j++){
                int days = (startday + j) % 7;
                int realTime = timelogs[i][j];
                
                int rTime = realTime / 100;
                int rmin = realTime % 100;
                
                
                
                if(days == 0 || days == 6){
                    continue;
                }
                
                int diff = (rTime - time) * 60 + (rmin - min);
                
                if(diff <= 10) cnt++; 
            }
            
            if(cnt == 5) answer++;
        }
        
        
        
        return answer;
    }
}