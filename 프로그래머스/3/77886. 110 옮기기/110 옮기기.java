class Solution {
    public String[] solution(String[] s) {
            String[] answer = new String[s.length];
            int answerIdx =0;
        for(String str : s){
            int count = 0;
            StringBuilder st = new StringBuilder(str);
            int index = 0;
            while ((index = st.indexOf("110", index)) != -1) {
                st.delete(index, index + 3);
                count++;
                index = Math.max(index - 2, 0);
            }
            int idx = -1;
                for(int i =0; i<st.length(); i++){
                    if(st.substring(i,i+1).equals("0")){
                        idx = i+1;   
                    }
                }
            if(idx == -1){
                idx=0;
            }

            for(int i =0; i<count; i++){
                st.insert(idx,"110");
            }
            
            answer[answerIdx++] = st.toString();
        }
        
        

        return answer;
    }
}