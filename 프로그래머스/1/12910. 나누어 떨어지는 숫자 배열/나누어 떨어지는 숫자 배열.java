import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        for(int i =0; i<arr.length; i++){
            if(arr[i] % divisor == 0){
                list.add(arr[i]);
            }
        }
        
        int[] answerArr = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answerArr[i] = list.get(i);
        }
        if(answerArr.length == 0){
            return new int[] {-1};
        }
        Arrays.sort(answerArr);
        
        return answerArr;
    }
}