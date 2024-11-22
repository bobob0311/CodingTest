import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        double[] avgScore = new double[score.length];
        int[] answer = new int[score.length];
        for(int i =0; i<score.length; i++){
            avgScore[i] = (double) (score[i][0] + score[i][1])/2;
        }
        
        for(int i =0; i<score.length; i++){
            double nowScore = avgScore[i];
            int a = 1;
            for(int j =0; j<score.length; j++){
                if(nowScore < avgScore[j]){
                    a++;
                }
            }
            answer[i] = a;
        }
        return answer;
    }
}