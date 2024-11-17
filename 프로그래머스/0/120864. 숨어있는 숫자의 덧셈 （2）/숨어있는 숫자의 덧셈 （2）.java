class Solution {
    public int solution(String my_string) {

        int answer = 0;
        for(int i = 0; i<my_string.length(); i++){
            int num = (int) my_string.charAt(i);
            if(num >= 48  && num <= 57 ){
                String now = my_string.substring(i,i+1);
                i++;
                while(i < my_string.length()){
                    if((int) my_string.charAt(i) >= 48 && (int) my_string.charAt(i) <=57){
                        now += my_string.substring(i,i+1);
                        i++;
                        continue;
                    }else{
                        break;
                    }
                }
                answer += Integer.parseInt(now);
            }
            
        }
        

        return answer;
    }
}