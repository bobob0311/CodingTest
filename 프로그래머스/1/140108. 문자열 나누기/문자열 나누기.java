class Solution {
    public int solution(String s) {
        int cnt1 = 0;
        int cnt2 = 0;
        char temp = '0';
        int count = 0;
        for(int i =0 ; i<s.length(); i++){
            if(temp == '0'){
                temp = s.charAt(i);
                cnt1++;
                continue;
            }else if(temp == s.charAt(i)){
                cnt1++;
            }else{
                cnt2++;
            }
            if(cnt1 == cnt2){
                count++;
                cnt1 = 0;
                cnt2 = 0;
                temp = '0';
            }
        }
        if(cnt1 != 0){
            count++;
        }        
        
        return count;
    }
}