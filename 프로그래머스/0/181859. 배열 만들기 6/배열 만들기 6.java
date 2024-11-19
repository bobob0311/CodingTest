import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<arr.length; i++){
            if(st.isEmpty()){
                st.push(arr[i]);
            }else{
                if(st.peek() == arr[i]){
                    st.pop();
                }else{
                    st.push(arr[i]);
                }
            }
        }
        
        int[] answer = new int[st.size()];
        if(st.size() == 0){
            return new int[] {-1};
        }
        for(int i = st.size() -1 ; i>=0 ; i--){
            answer[i] = st.pop();
        }
        
        return answer;
    }
}