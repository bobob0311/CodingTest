class Solution {
    public String solution(String a, String b) {
        while(a.length() != b.length()){
            if(a.length() < b.length()){
                a = "0" +a;
            }else{
                b = "0" +b;
            }
        }
        StringBuilder st = new StringBuilder();
        int prev = 0;
        for(int i = a.length() -1; i>=0; i--){
            int now = prev + Integer.parseInt(a.substring(i,i+1)) + Integer.parseInt(b.substring(i,i+1));

            if(now >=10){
                st.append(now % 10);
                prev = now /10;
            }else{
                st.append(now);
                prev = 0;
            }
        }
        if(prev > 0){
            st.append(prev);
        }
        StringBuilder st2 = new StringBuilder();
        String reverseAnswer = st.toString();
        for(int i = st.length()-1; i>=0; i--){
            st2.append(reverseAnswer.substring(i,i+1));
        }

        return st2.toString();
    }
}