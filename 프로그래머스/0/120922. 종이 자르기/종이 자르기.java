class Solution {
    public int solution(int M, int N) {
        if(M==1 && N==1){
            return 0;
        }
        if(M ==0){
            return N-1;
        }
        if(N ==0){
            return M-1;
        }
        return (M-1) + M*(N-1);
    }
}