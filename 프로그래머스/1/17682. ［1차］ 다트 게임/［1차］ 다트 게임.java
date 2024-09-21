class Solution {
    public int solution(String dartResult) {
        String tempStr = "";
        int nowV = -99;
        int preV = 0;
        int answer = 0;
        for(int i =0; i<dartResult.length(); i++){
            char target = dartResult.charAt(i);
            
            if(target == 'S'){
                nowV = Integer.parseInt(tempStr);
            }else if(target == 'D'){
                int v = Integer.parseInt(tempStr);
                nowV = v*v;
            }else if(target == 'T'){
                int v = Integer.parseInt(tempStr);
                nowV = v*v*v;
            }else if(target == '*'){
                answer += preV;
                nowV *=2;
            }else if(target == '#'){
                nowV *=(-1);
            }else{
                if(nowV != -99){
                    answer+= nowV;
                    tempStr = "";
                    preV = nowV;
                    nowV = -99;
                }
                tempStr += String.valueOf(target);
            }
        }
        answer+= nowV;
        

        return answer;
    }
}