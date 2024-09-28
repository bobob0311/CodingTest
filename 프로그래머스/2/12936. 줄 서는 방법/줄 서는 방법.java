class Solution {
    public int[] solution(int n, long k) {
        long[] F = new long[n];

        F[1] = 1L;
        for(int i = 2; i<n;i++){
            F[i] =  F[i-1] * i;  
        }
        
        
        boolean[] chk = new boolean[n];
        int[] arr= new int[n];
        int answerIdx = 0;
        if(n==1){
            return new int[] {1};
        }

        while(answerIdx<= n-2){
            long nowTarget = F[n-1-answerIdx];
            //
            int m = (int) (k / nowTarget);
            long p = k % nowTarget;
            int idx;
            
                if(p == 0){
                    idx = (int) m-1;
                    
                    k -= nowTarget*(m-1);
                }else{
                    idx = (int)m;
                    k -= nowTarget*m;
                }    
            
            
            int count = 0;
            for(int i =0; i<n; i++){
                if(chk[i] == false){
                    count++;    
                }
                if(count == idx+1){
                    chk[i] = true;
                    arr[answerIdx] = i+1;
                    answerIdx++;
                    break;
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            if(chk[i] == false){
                arr[answerIdx] = i+1;
                break;
            }
        }
        return arr;
    }
}