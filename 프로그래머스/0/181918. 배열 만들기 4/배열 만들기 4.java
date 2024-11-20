import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<arr.length; i++){
            if(st.isEmpty()){
                st.push(arr[i]);
            }else{
                if(st.peek() < arr[i]){
                    st.push(arr[i]);
                }else{
                    st.pop();
                    i--;
                }
            }
        }
        
        int[] stk = new int[st.size()];
        int len = st.size();
        System.out.println(len);
        for(int i = 0; i<len ; i++){
            stk[len - i -1] = st.pop();
        }
        
        return stk;
    }
}