class Solution {
    public String[] solution(String[] names) {
        int len = 0;
        
        if(names.length% 5 != 0){
            len = names.length/5 +1;
        }else{
            len = names.length/5;
        }
        String[] answer = new String[len];
        int idx = 0;
        for(int i = 0; i<names.length; i+=5){
            answer[idx++] = names[i];
        }
        
        
        
        return answer;
    }
}