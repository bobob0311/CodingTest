class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int maxTime = change(video_len);
        int now = change(pos);
        int opS = change(op_start);
        int opE = change(op_end);
        
        if(opS<=now && opE>=now){
            now = opE;
        }
        
        for(String v:commands){
            if(v.equals("prev")){
                now-=10;
                if(now<0){
                    now=0;
                }
            }else if(v.equals("next")){
                now+=10;
                if(now>maxTime){
                    now = maxTime;
                }
            }
            if(opS<=now && opE>=now){
                now = opE;
            }

        }
        int m = now / 60;
        int s = now % 60;
        String M = String.valueOf(m);
        String S = String.valueOf(s);
        if(M.length() == 1){
            M = "0"+M;
        }
        if(S.length() == 1){
            S = "0"+S;
        }
        
        
        
        String answer = M + ":" + S;
        return answer;
    }
    
    int change(String str){
        return Integer.parseInt(str.substring(0,2)) * 60 + Integer.parseInt(str.substring(3));
    }
}