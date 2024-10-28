/*
n 12
12*12 => 144


*/
class Solution {
    int cnt = 0;
    public int solution(int n) {
        boolean[][] chk = new boolean[n][n];
        boolean[] line = new boolean[n];
        
        chkFunction(n,line,chk,0);
        
        
        
        return cnt;
    }
    
    void chkFunction(int n, boolean[] line, boolean[][] chk,int count){
        if (count == n){
            cnt++;
            return;
        }
        
        for(int i =0; i<n; i++){
            if(!line[i]){
                boolean can = true;
                int tempCount = count;
                int tempIdx = i;
                while(tempCount<n && tempIdx<n){
                    if(chk[tempCount++][tempIdx++] == true){
                        can = false;
                    }
                }
                tempCount = count;
                tempIdx = i;
                while(tempCount>=0 && tempIdx>=0){
                    if(chk[tempCount--][tempIdx--] == true){
                        can = false;
                    }
                }
                tempCount = count;
                tempIdx = i;
                
                while(tempCount<n && tempIdx>=0){
                    if(chk[tempCount++][tempIdx--] == true){
                        can = false;
                    }
                }
                tempCount = count;
                tempIdx = i;
                
                while(tempCount>=0 && tempIdx<n){
                    if(chk[tempCount--][tempIdx++] == true){
                        can = false;
                    }
                }
                
                if(!can){
                    continue;
                }
                line[i] = true;
                chk[count][i] = true;
                chkFunction(n,line,chk,count+1);
                line[i] = false;
                chk[count][i] = false;
            }
        }
    }
}