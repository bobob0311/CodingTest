import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] arr = new int[N+1];
        double[][] rate = new double[N][2];
        
        for(int i = 0; i<stages.length;i++){
            arr[stages[i]-1]++;
        }
        // stages 0 ~ N
        int down = arr[N];
        for(int i = N-1 ; i>=0;i--){
            down += arr[i];
            if(down == 0){
                rate[i] = new double[] {0,i+1};
                continue;
            }
            rate[i] = new double[] {(double) arr[i] / down,i+1};
        }

         Arrays.sort(rate, (a, b) -> {
            if (a[0] == b[0]) {
                return Double.compare(a[1], b[1]); 
            }
            return Double.compare(b[0], a[0]); 
        });
        
        for(int i =0; i<=N-1; i++){
            System.out.println(rate[i][0]+ " "+ rate[i][1]);
        }



        int[] answer = new int[N];
        for(int i =0; i<=N-1; i++){
            answer[i] = (int) rate[i][1];
        }
        
        return answer;
    }
}