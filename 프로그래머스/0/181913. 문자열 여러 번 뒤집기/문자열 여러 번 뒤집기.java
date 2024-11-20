class Solution {
    public String solution(String my_string, int[][] queries) {
        for(int[] query : queries){
            int start = query[0];
            int end = query[1];
            String temp = "";
            temp += my_string.substring(0,start);
            for(int i = end; i>=start ; i--){
                temp += my_string.substring(i,i+1);
            }
            temp += my_string.substring(end+1);
            my_string = temp;
            
        }
        
        
        return my_string;
    }
}