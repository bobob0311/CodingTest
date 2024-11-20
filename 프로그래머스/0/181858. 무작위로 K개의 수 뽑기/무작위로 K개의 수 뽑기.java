import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        int[] answer = new int[k];
        
        int idx = 0;
        for(int i =0; i<arr.length; i++){
            int prev = set.size();
            set.add(arr[i]);
            if(prev != set.size()){
                answer[idx++] = arr[i];
            }
            if(set.size() == k){
                break;
            }
        }
        
        for(int i = idx ; i<k ; i++){
            answer[i] = -1;
        }
        return answer;
    }
}