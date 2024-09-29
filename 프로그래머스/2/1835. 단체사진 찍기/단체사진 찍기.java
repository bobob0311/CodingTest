/*
n => 조건의 개수


배치한게 되는가를 보자?

40320 개 
100개의 조건
5번씩 

*/

class Solution {
    static int answer = 0;
    public int solution(int n, String[] data) {
        String[] ca = new String[] {"A","C","F","J","M","N","R","T"};
        answer = 0;
        boolean[] chk = new boolean[8];
        StringBuilder st = new StringBuilder();
        dfs(st,ca,chk,data);

        return answer;
    }
    void dfs(StringBuilder st, String[] ca, boolean[] chk,String[] data){
        if(st.length() == 8){
            chkValid(data,st.toString());
            return;
        }
        
        for(int i =0; i<ca.length; i++){
            if(!chk[i]){
                chk[i] = true;
                st.append(ca[i]);
                dfs(st,ca,chk,data);
                st.delete(st.length()-1,st.length());
                chk[i] = false;
            }
        }
    }
    void chkValid(String[] data,String target){
        boolean valid = true;
        for(String v : data){
            
            int num = Integer.parseInt(v.substring(4,5));
            num ++;
            int startIdx = target.indexOf(String.valueOf(v.charAt(0)));
            int endIdx = target.indexOf(String.valueOf(v.charAt(2)));
            char giho = v.charAt(3);
            if(giho == '='){
               if(!(Math.abs(startIdx-endIdx) == num)){
                   valid = false;
                   break;
               }
            }else if(giho == '>'){
                if(!(Math.abs(startIdx-endIdx) > num)){
                    valid = false;
                    break;
                }
            }else{
                if(!(Math.abs(startIdx - endIdx) < num)){
                    valid = false;
                    break;
                }
            }
        }
        if(valid){
            answer++;
        }
    }
}