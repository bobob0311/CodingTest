class Solution {
    static long[] lenDp;
    static long[] sumDp;
    static int n;
    static int[] arr;
    
    public long[] solution(int[] arr, long l, long r) {
        n = arr.length;
        this.arr = arr;
        
        lenDp = new long[n+1];
        sumDp = new long[n+1];
        for(int i = 1; i<n+1; i++){
            lenDp[i] = arr[i-1] +lenDp[i-1];
            sumDp[i] = 1L* arr[i-1] * arr[i-1]  + sumDp[i-1];
        }
        
        long sumVal = findSubSum(l,r);
        
        long count = findCntOfSubSumVal(r-l+1,sumVal);
        
        return new long[] {sumVal,count};
    }
    
    static long findCntOfSubSumVal(long len, long sumVal){
        long curSum = findSubSum(1, len);
        long totalWindowCnt = lenDp[n] - len +1;
        
        long count = 0;
        long start = 1;
        
        while(start < totalWindowCnt){
            long outPos = start;
            long inPos = start+len;

            int outIdx = findIdx(outPos);
            int inIdx = findIdx(inPos);

            long outVal = arr[outIdx -1];
            long inVal = arr[inIdx -1];

            long diff = inVal - outVal;

            long outRemain = lenDp[outIdx] - outPos +1;
            long inRemain = lenDp[inIdx] - inPos +1;

            long moveCnt = Math.min(outRemain,inRemain);
            moveCnt = Math.min(moveCnt, totalWindowCnt - start); 
            
            count += sol(curSum, diff, moveCnt, sumVal);
            
            curSum += diff *moveCnt;
            start += moveCnt;
        }

        if(curSum == sumVal) count++;
        return count;
        
    }
    
    static long sol(long curSum, long diff, long moveCnt, long target){
        if(diff == 0){
            if(curSum == target) return moveCnt;
            return 0;
        }
        long delta = target - curSum;
        
        if(delta % diff != 0) return 0;
        
        long k = delta /diff;
        
        if(0 <= k && k < moveCnt) return 1;
        return 0;
    }
    
    static long findSubSum(long start, long end){
        int startIdx = findIdx(start);
        int endIdx = findIdx(end);
        
        long startDiff = start - lenDp[startIdx-1] -1;
        long endDiff = arr[endIdx-1] - (end - lenDp[endIdx-1]);
        
        long diffVal = arr[endIdx-1] * endDiff + arr[startIdx-1] * startDiff;
        
        long answer = sumDp[endIdx] - sumDp[startIdx-1] - diffVal;
        return answer;
    }
    
    static int findIdx(long target){
        int start = 1;
        int end = n;
        
        while(start < end){
            int mid = (start + end)/2;
            
            if(lenDp[mid] >= target){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        return start;
    }
    
    
    
}