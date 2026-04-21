import java.util.function.Function;

class Solution {
    static int[][] dp;
    static int[][] choice;
    
    public int solution(int[] depth, int money, Function<Integer, Integer> excavate) {
        int n = depth.length;
        dp = new int[n+2][n+2];
        choice = new int[n+2][n+2];
        
        for(int len = 1; len <=n; len++){
            for(int left = 1; left + len -1 <=n; left++){
                int right = left + len -1;
                
                dp[left][right] = Integer.MAX_VALUE;
                
                for(int mid = left; mid <=right; mid++){
                    int leftCost = (mid > left)? dp[left][mid-1] : 0;
                    int rightCost = (right > mid)? dp[mid+1][right] : 0;
                    
                    int cost = depth[mid-1];
                    
                    int worstChoiceCost = Math.max(leftCost,rightCost);
                    int totalCost = cost + worstChoiceCost;
                    
                    if(totalCost < dp[left][right]){
                        dp[left][right] = totalCost;
                        choice[left][right] = mid;
                    }
                    
                }
            }
        }
        
        int start = 1;
        int end = n;
        
        while(start <= end){
            int targetIdx = choice[start][end];
            
            int result = excavate.apply(targetIdx);
            
            if(result == 0) return targetIdx;
            else if(result == -1) end = targetIdx-1;
            else start = targetIdx +1;
        }
        
        return -1;
    }
    
}