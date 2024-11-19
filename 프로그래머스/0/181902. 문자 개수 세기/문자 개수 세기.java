class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        int k = (int) 'A';
        int k2 = (int) 'a';
        for(int i = 0; i<my_string.length(); i++){
            int nowInt = (int) my_string.charAt(i);
            if(nowInt <= (int) 'Z'){
                answer[nowInt - k]++;    
            }else{
                answer[nowInt -k2 +26 ]++;
            }
            
        }
        return answer;
    }
}