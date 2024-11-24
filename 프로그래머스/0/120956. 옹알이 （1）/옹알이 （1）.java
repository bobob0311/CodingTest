class Solution {
    public int solution(String[] babbling) {
                
        int answer = 0;
        for(String bab : babbling){
            String now = bab.replace("aya"," ").replace("ye"," ").replace("woo"," ").replace("ma"," ");
            boolean chk = true;
            for(int i =0; i<now.length();i++){
                if(now.charAt(i) != ' '){
                    chk = false;
                    break;
                }
            }
            if(chk){
                answer++;
            }
        }

        return answer;
    }
}