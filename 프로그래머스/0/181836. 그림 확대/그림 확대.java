class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        int idx = 0;
        
        StringBuilder st = new StringBuilder();
        
        for(int i = 0; i<picture.length;i++){
            st.setLength(0);
            
            for(int j = 0; j<picture[i].length(); j++){
                char nowStr = picture[i].charAt(j);
                for(int z = 0; z<k;z++){
                    st.append(nowStr);
                }
            }
            
            String nowString = st.toString();
            for(int z = 0 ; z<k; z++){
                answer[idx++] = nowString;
            }
        }
        
        return answer;
    }
}