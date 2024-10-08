import java.util.*;

class Solution {
    static int[] ginfo;
    static int[] answer;
    static int max = -1; 
    
    public int[] solution(int n, int[] info) {
        ginfo = info;
        answer = new int[info.length];
        int[] lion = new int[info.length];
        
        dfs(n, 0, lion);
        if (max == -1) {
            return new int[] {-1};
        }
        return answer;
    }
    
    void dfs(int n, int idx, int[] lion) {
        if (idx == 11) { 
            if (n > 0) {
                lion[10] += n; 
            }
            int lionScore = 0, peachScore = 0;
            
            for (int i = 0; i < 11; i++) {
                if (lion[i] > ginfo[i]) {
                    lionScore += 10 - i;
                } else if (ginfo[i] > 0) {
                    peachScore += 10 - i;
                }
            }
            
            if (lionScore > peachScore) {
                int scoreDiff = lionScore - peachScore;
                if (scoreDiff > max) {
                    max = scoreDiff;
                    answer = lion.clone(); 
                } else if (scoreDiff == max) {
                    for (int i = 10; i >= 0; i--) {
                        if (lion[i] > answer[i]) {
                            answer = lion.clone();
                            break;
                        } else if (lion[i] < answer[i]) {
                            break;
                        }
                    }
                }
            }
            
            if (n > 0) {
                lion[10] -= n;
            }
            return;
        }
        
        if (n > ginfo[idx]) {
            lion[idx] = ginfo[idx] + 1;
            dfs(n - lion[idx], idx + 1, lion); 
            lion[idx] = 0;
        }
        
        dfs(n, idx + 1, lion);
    }
}
