class Solution {
    public int solution(String A, String B) {

        for(int i = 0; i<A.length(); i++){
            boolean chk = true;
            for(int j =0 ; j < A.length(); j++){
                int num = i+j;
                
                if(num + 1 > A.length()){
                    num = num % A.length();
                }
                
                if(A.charAt(j) != B.charAt(num)){
                    chk = false;
                    break;
                }
            }
            if(chk){
                return i;
            }
        }

        return -1;
    }
}