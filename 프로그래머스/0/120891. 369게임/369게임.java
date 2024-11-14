class Solution {
    public int solution(int order) {
        int answer = 0;
        String orderStr = String.valueOf(order);
        for(int i = 0; i<orderStr.length(); i++){
            char nowChar = orderStr.charAt(i);
            if(nowChar == '3' || nowChar == '6' || nowChar == '9'){
                answer++;
            }
        }
        return answer;
    }
}