import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int idx = 0;
        int start = -1;
        int end = -1;
        while(idx < arr.length){
            if(arr[idx] == 2){
                start = idx;
                break;
            }
            idx++;
        }
        if(start == -1){
            return new int[] {-1};
        }
        idx = arr.length-1;
        while(idx >=0){
            if(arr[idx] == 2){
                end = idx;
                break;
            }
            idx--;
        }
        
        int[] answer = new int[end-start + 1];
        int index = 0;
        for(int i = start; i<=end; i++){
            answer[index++] = arr[i];
        }
        
        
        return answer;
    }
}