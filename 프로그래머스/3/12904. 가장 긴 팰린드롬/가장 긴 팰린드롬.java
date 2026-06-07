class Solution{
    public int solution(String s){
        int answer = 0;
        
        
        // 길이가 1일 때는 1 조기 리턴
        if(s.length() == 1){
            return 1;
        }
        
        int count;
        // 2500 * 2500 => 6250000
        for(int i = 0 ; i<s.length()-1; i++){
            char v = s.charAt(i);
            
            int start = i-1;
            int end = i +1;
            int initCnt = 1;
            
            // 문자열 범위 안에 있을 때만
            // 양옆으로 늘려가면서 확인
            count = lengthCounter(start, end, s, initCnt);   
            answer = Math.max(answer,count);
        
            // "bbaabb" 이런 경우에는 어떻게 할것인가?
            // 가운데 문자가 짝수번 반복될때는 해결이 불가능
            if(s.charAt(i+1) == v){
                start = i-1;
                end = i+2;
                initCnt = 2;
            }
            count = lengthCounter(start, end, s, initCnt);        
            answer = Math.max(answer,count);
        }

        return answer;
    }
    static public int lengthCounter(int start, int end, String s, int cnt){
        
        int count = cnt;
        
        while(start>=0 && end <s.length()){
            if(s.charAt(start) == s.charAt(end)){
                count+=2;
                start--;
                end++;
                continue;
            }
            break;
        }
        return count;
    }
}