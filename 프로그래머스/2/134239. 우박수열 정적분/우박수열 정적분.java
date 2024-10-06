import java.util.*;


// a-b => a n은 횟수

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> list = new LinkedList<>();
        list.add(k);
        int n = 0;
        while(k != 1){
            if(k % 2 == 0){
                k/=2;
            }else{
                k= k*3 + 1;
            }
            list.add(k);
            n++;
        }
        list.add(1);
        
        double[] answer = new double[ranges.length];
        int idx = 0;
        for(int[] arr : ranges){
            int start = arr[0];
            int end = arr[1] +n;
            if(start > end){
                answer[idx++] = -1;
            }else if(start == end){
                answer[idx++] = 0;
            }else{
                double temp = 0;
                double h1 = list.get(start++);
                double h2 = list.get(start++);
                while(start <= end+1){
                    temp += (double) ((h1+h2) / 2);
                    h1 = h2;
                    h2 = list.get(start++);
                }
                answer[idx++] = (double) temp;
            }
        }
        
        return answer;
    }
}