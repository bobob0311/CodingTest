class Solution {
    public int solution(String[] order) {
        int answer = 0;
        
        for(String o : order){
            if(o.equals("anything")){
                answer+=4500;
            }else if(o.contains("americano")){
                answer+=4500;
            }else{
                answer+=5000;
            }
        }
        

        return answer;
    }
}