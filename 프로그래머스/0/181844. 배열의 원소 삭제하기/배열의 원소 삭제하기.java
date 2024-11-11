import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new LinkedList<>();
        
        for(int i = 0 ;i<arr.length; i++){
            int target = arr[i];
            boolean flag = false;
            for(int chk : delete_list){
                if(target == chk){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                list.add(target);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}